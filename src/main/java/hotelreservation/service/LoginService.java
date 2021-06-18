package hotelreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelreservation.domain.Status;
import hotelreservation.domain.Users;
import hotelreservation.domain.UsersRepository;

@Service
public class LoginService{
	private static final long serialVersionUID = 1L;

	@Autowired
	UsersRepository userRepo;
	
	public Status logMeIn(Users user) {
		String firstName = user.getFirstName();
		String password = user.getPassword();
		
		System.out.println("Firstname: " + firstName +
						   " Password: " + password);

		List<Users> users = userRepo.findAll();
		
		
		for(Users other : users) {
			System.out.println("Firstname2: " + other.getFirstName() +
					   " Password2: " + other.getPassword());
			if(other.getFirstName().equals(user.getFirstName()) && other.getPassword().equals(user.getPassword())) {
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}
	
	public Status logMeOut() {
		
		return Status.FAILURE;
	}
}
