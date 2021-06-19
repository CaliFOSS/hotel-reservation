package hotelreservation.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import hotelreservation.domain.Status;
import hotelreservation.domain.Users;
import hotelreservation.domain.UsersRepository;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
		
		Status actual = loginService.logMeIn(user);
		Status expected = Status.SUCCESS;
		
		assertEquals(expected, actual);
	}

	@Test
	void testLogMeInDoesntExist() {
		//Arrange
		Users user = new Users(1,"testFName","testLName","testPass");
		List<Users> users = new ArrayList<Users>();
		
		when(mockUserRepo.findAll()).thenReturn(users);
		
		Status actual = loginService.logMeIn(user);
		Status expected = Status.FAILURE;
		
		assertEquals(expected, actual);
	}
}
