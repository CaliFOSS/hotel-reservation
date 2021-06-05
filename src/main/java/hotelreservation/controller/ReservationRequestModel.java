package hotelreservation.controller;

public class ReservationRequestModel {
    private String date;
    private String city;
    private char[] state = new char[2];


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

    public char[] getState() {
        return state;
    }

    public void setState(char[] state) {
        this.state = state;
    }
}



