package hotelreservation.service;


import hotelreservation.domain.*;
import hotelreservation.domain.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoomsRepository roomsRepository;
    private List<HotelReservationHelper> availableReservations;


    public List<HotelReservationHelper> availableRoomsOneNight(Date date){

        List<Hotel> hotels = hotelRepository.findAll();

        hotels.forEach((hotel)->{
            Room rooms = roomsRepository.findRoomsByHotelAndDate(hotel, date);


            if (rooms != null){
                HotelReservationHelper temp = new HotelReservationHelper(hotel.getName(), hotel.getAddress(),
                        hotel.getStars(), hotel.getCity(), hotel.getState(), hotel.getPrice_per_day(), date );
                availableReservations.add(temp);
            }
        });


        return availableReservations;
    }

    public ReservationService(){}





}
