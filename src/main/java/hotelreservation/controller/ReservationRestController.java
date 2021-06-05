package hotelreservation.controller;

import hotelreservation.domain.HotelReservationHelper;
import hotelreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ReservationRestController {

    @Autowired
    ReservationService reservationService;


    @PostMapping(value = "/api/search", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<HotelReservationHelper>> getAvailableReservations(@RequestBody ReservationRequestModel reservationDetails){

        LocalDate localDate = LocalDate.parse(reservationDetails.getDate());

        List<HotelReservationHelper> reservations = reservationService.availableRoomsOneNight(localDate);
        return ResponseEntity.ok(reservations);


    }


}
