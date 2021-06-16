package hotelreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import hotelreservation.domain.CustomUserDetails;
import hotelreservation.domain.Users;
import hotelreservation.domain.UsersRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepo.findByFirstName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not Found");
		}
		return new CustomUserDetails(user);
	}
}
