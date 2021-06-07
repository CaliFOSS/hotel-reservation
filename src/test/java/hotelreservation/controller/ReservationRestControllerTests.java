package hotelreservation.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hotelreservation.domain.Hotel;
import hotelreservation.domain.HotelReservationHelper;
import hotelreservation.domain.Reservation;
import hotelreservation.domain.Users;
import hotelreservation.service.ReservationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationRestController.class)
public class ReservationRestControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired MockMvc mvc2;

    @MockBean
    private ReservationService reservationService;

    private JacksonTester<HotelReservationHelper> json;

    private ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
    //Hotels
    Hotel hotel1 = new Hotel(1, "weston", "123 any stree", 3, "Sacramento", "CA", 100);

    //hotelhelpers
    private HotelReservationHelper hotel_1 = new HotelReservationHelper(1, "weston", "123 any street",
            3, "Sacramento", "CA", 100, LocalDate.parse("2021-06-01"), 4 );
    private HotelReservationHelper hotel_2 = new HotelReservationHelper(2, "Hampton", "123 any street",
            3, "Sacramento", "CA", 100, LocalDate.parse("2021-06-01"), 3 );
    private HotelReservationHelper hotelNoRooms = new HotelReservationHelper(3, "WestGate", "123 any street",
            3, "Sacramento", "CA", 100, LocalDate.parse("2021-06-01"), 0 );

    //setup list will be useful for multiple scenarios
    private List<HotelReservationHelper> expectedSearch = new ArrayList<>();

    //Test users
    Users user_1 = new Users(1,"jeff", "garrett", "adsf");

    @Before
    public void setup(){
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void avaialableReservation() throws Exception {

        //setting up payload
        ReservationRequestModel rawPayload = new ReservationRequestModel("2021-06-01", "Sacramento", "CA");

        String payload = mapper.writeValueAsString(rawPayload);

        //adding hotels for this test
        //then writing as json string
        expectedSearch.add(hotel_1);
        String expectedJson = mapper.writeValueAsString(expectedSearch);

        //Mock API endpoint
        given(reservationService.availableRoomsForCity(LocalDate.parse("2021-06-01"), "Sacramento", "CA")).willReturn(expectedSearch);

        //Perform test
        MockHttpServletResponse response = mvc.perform(post("/api/search")
                .contentType("application/json")
                .content(payload)
                .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        //Validate
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(expectedJson);

    }

    @Test
    public void bookReservation() throws JsonProcessingException {
        //setting up payload  LocalDate startDate, LocalDate endDate, Hotel hotel, Users users
        LocalDate startDate = LocalDate.parse("2021-06-01");
        LocalDate endDate = LocalDate.parse("2021-06-02");

        ReservationRequestModel rawPayload = new ReservationRequestModel("2021-06-01", "asdf", hotel1.getIdhotel(), user_1.getIdusers());
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();
        String payload = mapper.writeValueAsString(rawPayload);


        Reservation reservation = new Reservation(1, startDate, endDate, hotel1, user_1);
        String expectedPayload = mapper.writeValueAsString(reservation);

        //given
        given(reservationService.bookReservation(1, LocalDate.parse("2021-06-01"), 1)).willReturn(reservation);

        //Perform test
        MockHttpServletResponse response = null;
        try {
            response = mvc2.perform(post("/api/reservation")
                    .contentType("application/json")
                    .content(payload)
                    .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Validate
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        try {
            assertThat(response.getContentAsString()).isEqualTo(expectedPayload);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


}
