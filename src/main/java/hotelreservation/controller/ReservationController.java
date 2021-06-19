package hotelreservation.controller;

import hotelreservation.domain.HotelReservationHelper;
import hotelreservation.domain.Users;
import hotelreservation.service.LoginService;
import hotelreservation.service.ReservationService;
import hotelreservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    
    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;
    
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
    	
        Users authUser = userService.authenticateUser(user.getFirstName(), user.getPassword());
        
    	if(authUser.isAuthenticated() == true) {
    		System.out.println("successful login");
    		Cookie cookie = new Cookie("loggedIn","true");
    		Cookie userId = new Cookie("userid", (Integer.toString(authUser.getIdusers())));
			response.addCookie(cookie);
			response.addCookie(userId);
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
    
//    @GetMapping("/reservation/delete")
    
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
