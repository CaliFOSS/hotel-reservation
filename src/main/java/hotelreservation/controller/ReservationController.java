package hotelreservation.controller;

import hotelreservation.domain.HotelReservationHelper;
import hotelreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/hotel/search")
    public String searchForReservation(){

        return "reservation_search";
    }


    @PostMapping("/hotel/search")
    public String getAvailableReservations(@RequestParam("date") String date, Model model)
    {
        LocalDate localDate = LocalDate.parse(date);

        List<HotelReservationHelper> reservations = reservationService.availableRoomsOneNight(localDate);
        model.addAttribute("reservations", reservations);

        return "available_reservations";

    }

}
