package hotelreservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {

    @GetMapping("/hotel/search")
    public String searchForReservation(){

        return "reservation_search";
    }

}
