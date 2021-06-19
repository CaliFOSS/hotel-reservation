package hotelreservation.service;

import hotelreservation.domain.Status;
import hotelreservation.domain.Users;
import hotelreservation.domain.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class LoginServiceTest extends LoginService {

	@Mock
	UsersRepository mockUserRepo;
	
	@InjectMocks
	LoginService loginService;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testLogMeInExists() {
		//Arrange
		Users user = new Users(1,"testFName","testLName","testPass");
		List<Users> users = new ArrayList<Users>();
		users.add(user);
		
		when(mockUserRepo.findAll()).thenReturn(users);
		
		Users actual = loginService.logMeIn(user);
		Status expected = Status.SUCCESS;
		
		assertEquals(expected, actual);
	}

	@Test
	void testLogMeInDoesntExist() {
		//Arrange
		Users user = new Users(1,"testFName","testLName","testPass");
		List<Users> users = new ArrayList<Users>();
		
		when(mockUserRepo.findAll()).thenReturn(users);
		
		Users actual = loginService.logMeIn(user);
		Status expected = Status.FAILURE;
		
		assertEquals(expected, actual);
	}
}
