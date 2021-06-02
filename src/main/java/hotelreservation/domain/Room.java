package hotelreservation.domain;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private int idrooms;
    private Date date;
    private int free_rooms;


    @ManyToOne
    private Hotel hotel;

    public Room() {
    }

    public Room(int idrooms, Date date, int free_rooms, Hotel hotel) {
        this.idrooms = idrooms;
        this.date = date;
        this.free_rooms = free_rooms;

        this.hotel = hotel;
    }

    public int getIdrooms() {
        return idrooms;
    }

    public void setIdrooms(int idrooms) {
        this.idrooms = idrooms;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getFree_rooms() {
        return free_rooms;
    }

    public void setFree_rooms(int free_rooms) {
        this.free_rooms = free_rooms;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
