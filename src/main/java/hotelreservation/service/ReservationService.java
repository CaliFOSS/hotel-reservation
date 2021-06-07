package hotelreservation.service;


import hotelreservation.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoomsRepository roomsRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    //constructor
    public ReservationService(){}

    //constructor for dependency Injection
    public ReservationService(HotelRepository hotelRepository, RoomsRepository roomsRepository){
        this.hotelRepository = hotelRepository;
        this.roomsRepository = roomsRepository;
    }

    //internal function for easy reuse
    private List<HotelReservationHelper> findAvailableRooms(List<Hotel> hotels, LocalDate date){
        List<HotelReservationHelper> availableReservations = new ArrayList<>();
        hotels.forEach((hotel)->{
            Room rooms = roomsRepository.findRoomsByHotelAndDate(hotel, date);
            System.out.println(rooms);
            if (rooms != null) {
                HotelReservationHelper temp = new HotelReservationHelper(hotel.getIdhotel(), hotel.getName(), hotel.getAddress(),
                        hotel.getStars(), hotel.getCity(), hotel.getState(), hotel.getPrice_per_day(), date, rooms.getFree_rooms());
                availableReservations.add(temp);
            }
        });
        return availableReservations;
    }

    //used by webpage
    public List<HotelReservationHelper> availableRoomsOneNight(LocalDate date){
        List<Hotel> hotels = hotelRepository.findAll();
        return findAvailableRooms(hotels, date);
    }

    //used by RESTApi
    public List<HotelReservationHelper> availableRoomsForCity(LocalDate date, String city, String state){

        List<Hotel> hotels = hotelRepository.findHotelByCityAndState(city, state );
        return findAvailableRooms(hotels, date);
    }

    //used by rest service
    public Reservation bookReservation(int hotelId, LocalDate date, int Userid){

        Hotel hotel = hotelRepository.findHotelByIdhotel(hotelId);
        Users user = usersRepository.findByidusers(Userid);

        //TODO: update to check if reservation exists first

        //check for available rooms
        Room rooms = roomsRepository.findRoomsByHotelAndDate(hotel, date);

        if (rooms.getFree_rooms() > 0){
            rooms.setFree_rooms(rooms.getFree_rooms()-1);
            roomsRepository.save(rooms);
            Reservation reservation = new Reservation(date, date.plusDays(1), hotel, user);
            reservationRepository.save(reservation);
            return reservation;
        }else{
            return null;
        }


    }

}
