package hotelreservation.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import hotelreservation.domain.Users;
import hotelreservation.domain.UsersRepository;

class UserServiceTest extends UserService {

	@Mock
	UsersRepository mockUserRepo;
	
	@InjectMocks
	UserService userService;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void isAuthorizedTest() {
		Users user = new Users(1,"testFName","testLName","testPass");
		List<Users> users = new ArrayList<Users>();
		users.add(user);
		
		when(mockUserRepo.findByPasswordAndIdusers(user.getPassword(),user.getIdusers()))
		.thenReturn(user);
		
		Boolean actual = userService.isAuthorized(user.getIdusers(), user.getPassword());
		Boolean expected = true;
		
		assertEquals(expected, actual);
	}

}
