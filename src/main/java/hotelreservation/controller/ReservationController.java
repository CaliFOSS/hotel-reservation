package hotelreservation.controller;

import hotelreservation.domain.HotelReservationHelper;
import hotelreservation.domain.Status;
import hotelreservation.domain.Users;
import hotelreservation.service.LoginService;
import hotelreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    
    @Autowired
    LoginService loginService;
    
    @GetMapping("/")
    public String index() {
    	return "index";
    }
    
    @GetMapping("/login")
    public String login(Model model){
    	model.addAttribute("user", new Users());
    	return "login";
    }
    
    @PostMapping("/login")
    public String loginProcess(Users user, Model model, HttpServletResponse response){
    	
    	if(loginService.logMeIn(user) == Status.SUCCESS) {
    		System.out.println("successful login");
    		Cookie cookie = new Cookie("loggedIn","true");
			response.addCookie(cookie);
    		return "index";
    	}
    	
    	return "index";
    }
    
    @GetMapping("/logout")
    public String logoutProcess(HttpServletResponse response) {
    		Cookie cookie = new Cookie("loggedIn","null");
    		cookie.setMaxAge(0);
    		response.addCookie(cookie);
    	return "index";
    }
    
//    @RequestMapping("login_error")
//    public String loginError(Model model) {
//    	model.addAttribute("loginError", true);
//    	return "login";
//    }
    
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
