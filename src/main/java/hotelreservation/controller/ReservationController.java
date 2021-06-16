package hotelreservation.controller;

import hotelreservation.domain.HotelReservationHelper;
import hotelreservation.domain.Users;
import hotelreservation.service.ReservationService;
import hotelreservation.domain.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("deprecation")
@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    
    @Autowired
    UsersRepository userRepo;
    
    @GetMapping("/")
    public String index() {
    	return "index.html";
    }
    
    @GetMapping("/register")
    public String showRegForm(Model model) {
    	model.addAttribute("user", new Users());
    	return "signup_form.html";
    }
    
    @PostMapping("/processSignup")
    public String processRegister(Users user) {
    	PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
    	String password = encoder.encode(user.getPassword());
    	user.setPassword(password);
    	
    	userRepo.save(user);
    	
    	return "login.html";
    }
    
    @RequestMapping("/login.html")
    public String login(){
    	return "login.html";
    }
    
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
    	model.addAttribute("loginError", true);
    	return "login.html";
    }

    
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
