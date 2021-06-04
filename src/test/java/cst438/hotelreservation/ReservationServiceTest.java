package cst438.hotelreservation;

import java.time.LocalDate;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import hotelreservation.domain.Hotel;
import hotelreservation.domain.HotelRepository;
import hotelreservation.domain.HotelReservationHelper;
import hotelreservation.domain.Room;
import hotelreservation.domain.RoomsRepository;
import hotelreservation.service.ReservationService;

@SpringBootTest
public class ReservationServiceTest {
	
	@MockBean
	private ReservationService reservationService;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private RoomsRepository roomsRepository;
	
	@Test
	public void testAvailableRoomsOneNight_Found() throws Exception {
		
		//Arrange
		//Hotel Info
		int id = 12;
		String name = "TestHotel";
		String address = "123 Main St.";
		int stars = 4;
		String city = "TestCity";
		String state = "TS";
		int price_per_day = 20;
		
		//Room Info
		int roomId = 1;
		LocalDate date = LocalDate.of(2021,7,1);
		int free_rooms = 10;
		
		List<Hotel> hotels = Lists.newArrayList(new Hotel(id, name, address, stars, city, state, price_per_day));
		
		Room testRoom = new Room(roomId, date, free_rooms, hotels.get(0));
		
		//Act
		given(reservationService.availableRoomsOneNight(date)).willReturn();
		
		
		//Assert
		
	}
}
