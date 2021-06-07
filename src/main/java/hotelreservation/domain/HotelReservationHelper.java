package hotelreservation.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class HotelReservationHelper {

    private int hotelId;
    private String hotelName;
    private String hotelAddress;
    private int hotelStars;
    private String hotelCity;
    private String hotelState;
    private int hotelPricePerDay;
    //json formatter for the unit tests
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate availableDate;
    private int roomsAvailable;

    public HotelReservationHelper(String hotelName, String hotelAddress, int hotelStars, String hotelCity, String hotelState, int hotelPricePerDay, LocalDate availableDate) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelStars = hotelStars;
        this.hotelCity = hotelCity;
        this.hotelState = hotelState;
        this.hotelPricePerDay = hotelPricePerDay;
        this.availableDate = availableDate;
    }
    //built this constructor so didn't have to fix all past code.
    public HotelReservationHelper(String hotelName, String hotelAddress, int hotelStars, String hotelCity, String hotelState, int hotelPricePerDay, LocalDate availableDate, int roomsAvailable) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelStars = hotelStars;
        this.hotelCity = hotelCity;
        this.hotelState = hotelState;
        this.hotelPricePerDay = hotelPricePerDay;
        this.availableDate = availableDate;
        this.roomsAvailable =roomsAvailable;
    }

    public HotelReservationHelper(int hotelId, String hotelName, String hotelAddress, int hotelStars, String hotelCity, String hotelState, int hotelPricePerDay, LocalDate availableDate, int roomsAvailable) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.hotelStars = hotelStars;
        this.hotelCity = hotelCity;
        this.hotelState = hotelState;
        this.hotelPricePerDay = hotelPricePerDay;
        this.availableDate = availableDate;
        this.roomsAvailable = roomsAvailable;
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

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public void setRoomsAvailable(int roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}
