package hotelreservation.domain;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelReservationHelper {

    private String hotelName;
    private String hotelAddress;
    private int hotelStars;
    private String hotelCity;
    private String hotelState;
    private int hotelPricePerDay;
    private List<LocalDate> availableDate = new ArrayList<>();

    public HotelReservationHelper(String hotelName, String hotelAddress, int hotelStars, String hotelCity, String hotelState, int hotelPricePerDay, LocalDate availableDate) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelStars = hotelStars;
        this.hotelCity = hotelCity;
        this.hotelState = hotelState;
        this.hotelPricePerDay = hotelPricePerDay;
        this.availableDate.add(availableDate);
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public int getHotelStars() {
        return hotelStars;
    }

    public void setHotelStars(int hotelStars) {
        this.hotelStars = hotelStars;
    }

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getHotelState() {
        return hotelState;
    }

    public void setHotelState(String hotelState) {
        this.hotelState = hotelState;
    }

    public int getHotelPricePerDay() {
        return hotelPricePerDay;
    }

    public void setHotelPricePerDay(int hotelPricePerDay) {
        this.hotelPricePerDay = hotelPricePerDay;
    }

    public List<LocalDate> getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(List<LocalDate> availableDate) {
        this.availableDate = availableDate;
    }
}
