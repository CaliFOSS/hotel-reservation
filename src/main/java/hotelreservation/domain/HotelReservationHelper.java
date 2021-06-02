package hotelreservation.domain;


import java.util.Date;
import java.util.List;

public class HotelReservationHelper {

    private String hotelName;
    private String hotelAddress;
    private int hotelStars;
    private String hotelCity;
    private String hotelState;
    private int hotelPricePerDay;
    private List<Date> availableDate;

    public HotelReservationHelper(String hotelName, String hotelAddress, int hotelStars, String hotelCity, String hotelState, int hotelPricePerDay, Date availableDate) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelStars = hotelStars;
        this.hotelCity = hotelCity;
        this.hotelState = hotelState;
        this.hotelPricePerDay = hotelPricePerDay;
        this.availableDate.add(availableDate);
    }
}
