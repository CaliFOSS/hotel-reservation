package hotelreservation.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceHelper {
	@Autowired
	UsersRepository userRepo;
	
	public Users getUser(String firstName, String password) {
		Users user = userRepo.findByfirstNameAndPassword(firstName, password);
		return user;
	}
}