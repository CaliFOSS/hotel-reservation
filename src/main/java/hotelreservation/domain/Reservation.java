package hotelreservation.domain;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private int idreservations;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    private Users user;

    public Reservation() {
    }

    public Reservation(int idreservations, Date startDate, Date enDate, Hotel hotel, Users user) {
        this.idreservations = idreservations;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hotel = hotel;
        this.user = user;
    }

    public int getIdreservations() {
        return idreservations;
    }

    public void setIdreservations(int idreservations) {
        this.idreservations = idreservations;
    }

    public Date getStart_date() {
        return startDate;
    }

    public void setStart_date(Date start_date) {
        this.startDate = start_date;
    }

    public Date getEnd_date() {
        return endDate;
    }

    public void setEnd_date(Date end_date) {
        this.endDate = end_date;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
