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


    private List<HotelReservationHelper> findAvailableRooms(List<Hotel> hotels, LocalDate date){
        List<HotelReservationHelper> availableReservations = new ArrayList<>();
        hotels.forEach((hotel)->{
            Room rooms = roomsRepository.findRoomsByHotelAndDate(hotel, date);
            System.out.println(rooms);
            if (rooms != null) {
                HotelReservationHelper temp = new HotelReservationHelper(hotel.getName(), hotel.getAddress(),
                        hotel.getStars(), hotel.getCity(), hotel.getState(), hotel.getPrice_per_day(), date, rooms.getFree_rooms());
                availableReservations.add(temp);
            }
        });
        return availableReservations;
    }


    public List<HotelReservationHelper> availableRoomsOneNight(LocalDate date){
        List<Hotel> hotels = hotelRepository.findAll();
        return findAvailableRooms(hotels, date);
    }

    public List<HotelReservationHelper> availableRoomsForCity(LocalDate date, String city, String state){

        List<Hotel> hotels = hotelRepository.findHotelByCityAndState(city, state );
        return findAvailableRooms(hotels, date);
    }

    public ReservationService(){}

    //constructor for dependency Injection
    public ReservationService(HotelRepository hotelRepository, RoomsRepository roomsRepository){
        this.hotelRepository = hotelRepository;
        this.roomsRepository = roomsRepository;
    }

}
