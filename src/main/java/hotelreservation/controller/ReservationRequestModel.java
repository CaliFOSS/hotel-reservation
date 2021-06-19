package hotelreservation.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ReservationRequestModel {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String date;
    private String city;
    private String state;
    private String authToken;
    private int hotelId;
    private int userId;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ReservationRequestModel(LocalDate parse, LocalDate localDate, int i, String adsf, int i1){};

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ReservationRequestModel(){

    }

    public ReservationRequestModel(String date, String city, String state) {
        this.date = date;
        this.city = city;
        this.state = state;
    }

    public ReservationRequestModel(String date, String authToken, int hotelId, int userId) {
        this.date = date;
        this.authToken = authToken;
        this.hotelId = hotelId;
        this.userId = userId;
    }

    public ReservationRequestModel(String date, int hotelId, String authToken, int userId) {
        this.date = date;
        this.authToken = authToken;
        this.hotelId = hotelId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ReservationRequestModel{" +
                "date='" + date + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", authToken='" + authToken + '\'' +
                ", hotelId=" + hotelId +
                ", userId=" + userId +
                '}';
    }
}



