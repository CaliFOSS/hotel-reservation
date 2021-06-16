package hotelreservation.controller;

import hotelreservation.domain.HotelReservationHelper;
import hotelreservation.domain.Reservation;
import hotelreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @PostMapping(value = "/api/search",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<HotelReservationHelper>> getAvailableReservations(@RequestBody ReservationRequestModel reservationDetails) {
        System.out.println("Incoming API: POST api/search");
        System.out.println(reservationDetails.toString());
        LocalDate localDate = LocalDate.parse(reservationDetails.getDate());
        List<HotelReservationHelper> reservations = reservationService.availableRoomsForCity(localDate, reservationDetails.getCity(), reservationDetails.getState());

        ResponseEntity<List<HotelReservationHelper>> response = new ResponseEntity<List<HotelReservationHelper>>(reservations, HttpStatus.OK);
        System.out.println("Outgoing API: ");
        System.out.println(response);

        return response;

    }

    @PostMapping(value = "/api/reservation",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Reservation> bookReservation(@RequestBody ReservationRequestModel reservationRequest){
        System.out.println("Incoming API: POST api/reservation/");
        System.out.println(reservationRequest.toString());

        LocalDate localDate = LocalDate.parse(reservationRequest.getDate());
        Reservation reservation = reservationService.bookReservation(reservationRequest.getHotelId(), localDate, reservationRequest.getUserId());
        if (reservation == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(reservation);
        }

        System.out.println("Outgoing API: ");
        System.out.println(reservation.toString());
        return ResponseEntity.status(HttpStatus.OK).body(reservation);
    }

    @PostMapping(value = "/api/reservation/cancel",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity cancellation(@RequestBody ReservationCancellationModel reservationCancellation){

        System.out.println("Incoming API: POST api/reservation/cancel ");
        System.out.println(reservationCancellation.toString());
        ResponseEntity response = new ResponseEntity(
            reservationService.cancelReservation(reservationCancellation.getReservationId(),
                    reservationCancellation.getUserId(), reservationCancellation.getAuthToken())
        );
        System.out.println("Outgoing API: ");
        System.out.println(response.toString());
        return response;
    }


}
