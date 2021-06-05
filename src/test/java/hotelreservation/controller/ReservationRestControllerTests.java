package hotelreservation.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import hotelreservation.domain.HotelReservationHelper;
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

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationService.class)
public class ReservationRestControllerTests {

    @MockBean
    private ReservationService reservationService;

    @Autowired
    private MockMvc mvc;

    private JacksonTester<HotelReservationHelper> json;

    @Before
    public void setup(){
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void testStandardCall() throws Exception {
        ReservationRequestModel payload = new ReservationRequestModel("2021-06-01", "Sacramento", "CA");
        List<HotelReservationHelper> expected = (List<HotelReservationHelper>) new HotelReservationHelper("westong", "123 any street",
                3, "Sacramento", "CA", 100, LocalDate.parse("2021-06-01"), 4 );

        given(reservationService.availableRoomsForCity(LocalDate.parse("2021-06-01"), "Sacramento", "CA")).willReturn(expected);

        MockHttpServletResponse response = mvc.perform(post("/api/search").contentType(
                "application/json").content(payload.toString()).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(json.write((HotelReservationHelper) expected).getJson());
    }


}
