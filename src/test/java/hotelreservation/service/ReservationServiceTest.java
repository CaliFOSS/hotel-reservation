package hotelreservation.service;

import hotelreservation.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class ReservationServiceTest extends ReservationService{

    @MockBean
    private HotelRepository mockHotelRepository;

    @MockBean
    private RoomsRepository mockRoomsRepository;

    @Autowired
    private ReservationService reservationService;

    @MockBean
    private UserService mockUserService;

    @MockBean
    private UsersRepository mockUsersRepository;

    @MockBean
    private ReservationRepository mockReservationRepository;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.initMocks(this);
    }
    private Hotel hotel1 = new Hotel(1, "Weston", "12456 some address", 3, "Sacramento", "CA", 100);
    private HotelReservationHelper hotelReservation1 = new HotelReservationHelper(1, "Weston",
            "12456 some address", 3, "Sacramento", "CA", 100, LocalDate.parse("2021-06-01"), 3);

    private Users userInDB = new Users(1, "user", "db", "12345");
    private Users userBadPW = new Users(1, "user", "db", "123456");


    @Test
    public void testHotelReservation(){
        //hotel and dates to use
        Hotel mockHotel = new Hotel(1, "Weston", "12456 some address", 3, "Sacramento", "CA", 100);
        LocalDate date = LocalDate.parse("2021-06-01");
        // List we wil operate against
        List<HotelReservationHelper> reservations = new ArrayList<>();
        reservations.add(hotelReservation1);
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(mockHotel);


        //provide mocks
        //Mockito.when(mockRoomsRepository.findRoomsByHotelAndDate(mockHotel, date)).thenReturn(new Room(1, LocalDate.parse("2021-06-01"), 3, mockHotel));
        given(mockHotelRepository.findAll()).willReturn(hotels);
        given(mockRoomsRepository.findRoomsByHotelAndDate(mockHotel, date)).willReturn(new Room(1, LocalDate.parse("2021-06-01"), 3, mockHotel));



        reservationService = new ReservationService(mockHotelRepository, mockRoomsRepository, mockUserService, mockUsersRepository);

        List<HotelReservationHelper> test = reservationService.availableRoomsOneNight(date);

        assertThat(test.toString()).isEqualTo(reservations.toString());

    }


    @Test
    public void testBookReservationBadAuth(){
        //hotel and dates to use
        Hotel mockHotel = new Hotel(1, "Weston", "12456 some address", 3, "Sacramento", "CA", 100);
        LocalDate date = LocalDate.parse("2021-06-01");
        // List we wil operate against
        List<HotelReservationHelper> reservations = new ArrayList<>();
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(mockHotel);

        //provide mocks
        //Mockito.when(mockRoomsRepository.findRoomsByHotelAndDate(mockHotel, date)).thenReturn(new Room(1, LocalDate.parse("2021-06-01"), 3, mockHotel));
        given(mockHotelRepository.findHotelByIdhotel(mockHotel.getIdhotel())).willReturn(mockHotel);
        given(mockUsersRepository.findByidusers(userInDB.getIdusers())).willReturn(userInDB);
        given(mockUserService.isAuthorized(userBadPW.getIdusers(), userBadPW.getPassword())).willReturn(Boolean.FALSE);

        Reservation reservationExpected = new Reservation("User Not found", HttpStatus.FORBIDDEN);

        ReservationService reservationService = new ReservationService(mockHotelRepository, mockRoomsRepository, mockUserService, mockUsersRepository);

        Reservation test = reservationService.bookReservation(hotel1.getIdhotel(), date, userBadPW.getIdusers(), userBadPW.getPassword());

        assertThat(test.getError()).isEqualTo(reservationExpected.getError());
        assertThat(test.getErrorCode()).isEqualTo(reservationExpected.getErrorCode());

    }

    @Test
    public void testBookReservationNoRooms(){

        LocalDate date = LocalDate.parse("2021-06-01");

        //provide mocks
        //Mockito.when(mockRoomsRepository.findRoomsByHotelAndDate(mockHotel, date)).thenReturn(new Room(1, LocalDate.parse("2021-06-01"), 3, mockHotel));
        given(mockHotelRepository.findHotelByIdhotel(hotel1.getIdhotel())).willReturn(hotel1);
        given(mockUsersRepository.findByidusers(userInDB.getIdusers())).willReturn(userInDB);
        given(mockUserService.isAuthorized(userBadPW.getIdusers(), userInDB.getPassword())).willReturn(Boolean.TRUE);
        given(mockRoomsRepository.findRoomsByHotelAndDate(hotel1, date)).willReturn(new Room(1, date, 0, hotel1));

        Reservation reservationExpected = new Reservation("No Reservations available", HttpStatus.NOT_FOUND);

        ReservationService reservationService = new ReservationService(mockHotelRepository, mockRoomsRepository, mockUserService, mockUsersRepository);

        Reservation test = reservationService.bookReservation(hotel1.getIdhotel(), date, userInDB.getIdusers(), userInDB.getPassword());

        assertThat(test.getError()).isEqualTo(reservationExpected.getError());
        assertThat(test.getErrorCode()).isEqualTo(reservationExpected.getErrorCode());

    }

    @Test
    public void testCancellation(){

        LocalDate date = LocalDate.parse("2021-06-01");

        //provide mocks
        //Mockito.when(mockRoomsRepository.findRoomsByHotelAndDate(mockHotel, date)).thenReturn(new Room(1, LocalDate.parse("2021-06-01"), 3, mockHotel));
        given(mockUserService.isAuthorized(userInDB.getIdusers(), userInDB.getPassword())).willReturn(Boolean.TRUE);
        given(mockReservationRepository.findByIdreservations(1)).willReturn(new Reservation(1, date, date.plusDays(1), hotel1, userInDB));
        given(mockRoomsRepository.findRoomsByDateAndHotel_Idhotel(date, hotel1.getIdhotel())).willReturn(new Room(1, date, 10, hotel1));
        given(mockHotelRepository.findHotelByIdhotel(hotel1.getIdhotel())).willReturn(hotel1);
        given(mockUsersRepository.findByidusers(userInDB.getIdusers())).willReturn(userInDB);

        ReservationService reservationService = new ReservationService(mockHotelRepository, mockUsersRepository, mockRoomsRepository, mockReservationRepository, mockUserService);

        HttpStatus test = reservationService.cancelReservation(1, userInDB.getIdusers(), userInDB.getPassword());

        assertThat(test).isEqualTo(HttpStatus.OK);


    }

    @Test
    public void testCancellationBadPW(){

        LocalDate date = LocalDate.parse("2021-06-01");

        //provide mocks
        //Mockito.when(mockRoomsRepository.findRoomsByHotelAndDate(mockHotel, date)).thenReturn(new Room(1, LocalDate.parse("2021-06-01"), 3, mockHotel));
        given(mockUserService.isAuthorized(userInDB.getIdusers(), userInDB.getPassword())).willReturn(Boolean.TRUE);
        given(mockReservationRepository.findByIdreservations(1)).willReturn(new Reservation(1, date, date.plusDays(1), hotel1, userInDB));
        given(mockRoomsRepository.findRoomsByDateAndHotel_Idhotel(date, hotel1.getIdhotel())).willReturn(new Room(1, date, 10, hotel1));
        given(mockHotelRepository.findHotelByIdhotel(hotel1.getIdhotel())).willReturn(hotel1);
        given(mockUsersRepository.findByidusers(userInDB.getIdusers())).willReturn(userInDB);

        ReservationService reservationService = new ReservationService(mockHotelRepository, mockUsersRepository, mockRoomsRepository, mockReservationRepository, mockUserService);

        HttpStatus test = reservationService.cancelReservation(1, userInDB.getIdusers(), userBadPW.getPassword());

        assertThat(test).isEqualTo(HttpStatus.FORBIDDEN);


    }

    @Test
    public void testCancellationReservationNotFound(){

        LocalDate date = LocalDate.parse("2021-06-01");

        //provide mocks
        //Mockito.when(mockRoomsRepository.findRoomsByHotelAndDate(mockHotel, date)).thenReturn(new Room(1, LocalDate.parse("2021-06-01"), 3, mockHotel));
        given(mockUserService.isAuthorized(userInDB.getIdusers(), userInDB.getPassword())).willReturn(Boolean.TRUE);
        given(mockReservationRepository.findByIdreservations(1)).willReturn(null);
        given(mockRoomsRepository.findRoomsByDateAndHotel_Idhotel(date, hotel1.getIdhotel())).willReturn(new Room(1, date, 10, hotel1));
        given(mockHotelRepository.findHotelByIdhotel(hotel1.getIdhotel())).willReturn(hotel1);
        given(mockUsersRepository.findByidusers(userInDB.getIdusers())).willReturn(userInDB);

        ReservationService reservationService = new ReservationService(mockHotelRepository, mockUsersRepository, mockRoomsRepository, mockReservationRepository, mockUserService);

        HttpStatus test = reservationService.cancelReservation(1, userInDB.getIdusers(), userInDB.getPassword());

        assertThat(test).isEqualTo(HttpStatus.NOT_FOUND);


    }




}


