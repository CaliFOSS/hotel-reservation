package hotelreservation.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails implements UserDetails{
	private Users user;
	
	public CustomUserDetails(Users user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return null;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	public boolean isEnabled() {
		return true;
	}
	
	public String getFullName() {
		return user.getFirstName() + " " + user.getLastName();
	}
	
	//Mistake in not storing username earlier on has been built upon so for the
	//purposes of the class project we are using the first name as the user name.
	@Override
	public String getUsername() {
		return user.getFirstName();
	}
}
