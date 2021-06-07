package hotelreservation.domain;
import javax.persistence.*;


@Entity
@Table(name="hotel")
public class Hotel {
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private int idhotel;
    private String name;
    private String address;
    private int stars;
    private String city;
    private String state;
    private int price_per_day;

    public Hotel(){
    }

    public Hotel(int idhotel, String name, String address, int stars, String city, String state, int price_per_day) {
        this.idhotel = idhotel;
        this.name = name;
        this.address = address;
        this.stars = stars;
        this.city = city;
        this.state = state;
        this.price_per_day = price_per_day;
    }

    public int getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(int idhotel) {
        this.idhotel = idhotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
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

    public int getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(int price_per_day) {
        this.price_per_day = price_per_day;
    }

}


