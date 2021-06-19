package hotelreservation.service;

import hotelreservation.domain.Status;
import hotelreservation.domain.Users;
import hotelreservation.domain.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService{
	private static final long serialVersionUID = 1L;

	@Autowired
	UsersRepository userRepo;

	//Using User service instead.
	public Users logMeIn(Users user) {
		Users tempUser = user;
		String firstName = user.getFirstName();
		String password = user.getPassword();
		
		System.out.println("Firstname: " + firstName +
						   " Password: " + password);

		List<Users> users = userRepo.findAll();
		
		
		for(Users other : users) {
			System.out.println("Firstname2: " + other.getFirstName() +
					   " Password2: " + other.getPassword());
			if(other.getFirstName().equals(user.getFirstName()) && other.getPassword().equals(user.getPassword())) {
				tempUser.setAuthenticated(true);
				return tempUser;


			}
		}
		return user;
	}
	
	public Status logMeOut(Users user) {
		
		return Status.FAILURE;
	}
}
