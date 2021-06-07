package hotelreservation.service;

import hotelreservation.domain.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class ReservationServiceTest {

    @MockBean
    private HotelRepository mockHotelRepository;

    @MockBean
    private RoomsRepository mockRoomsRepository;

    @Autowired
    private ReservationService reservationService;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHotelReservation(){
        //hotel and dates to use
        Hotel mockHotel = new Hotel(1, "Weston", "12456 some address", 3, "Sacramento", "CA", 100);
        LocalDate date = LocalDate.parse("2021-06-01");
        // List we wil operate against
        List<HotelReservationHelper> reservations = new ArrayList<>();
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(mockHotel);

        //provide mocks
        //Mockito.when(mockRoomsRepository.findRoomsByHotelAndDate(mockHotel, date)).thenReturn(new Room(1, LocalDate.parse("2021-06-01"), 3, mockHotel));
        given(mockHotelRepository.findAll()).willReturn(hotels);
        given(mockRoomsRepository.findRoomsByHotelAndDate(mockHotel, date)).willReturn(new Room(1, LocalDate.parse("2021-06-01"), 3, mockHotel));



        reservationService = new ReservationService(mockHotelRepository, mockRoomsRepository);

        List<HotelReservationHelper> test = reservationService.availableRoomsOneNight(date);

        assertThat(test == reservations);

    }





}


