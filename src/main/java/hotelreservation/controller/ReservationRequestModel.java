package hotelreservation.controller;

public class ReservationRequestModel {
    private String date;
    private String city;
    private String state;


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

    public ReservationRequestModel(){};

    @Override
    public String toString(){
        return "Date: " +this.date + "  City: " + this.city + "  State: " + this.state;
    }


}



