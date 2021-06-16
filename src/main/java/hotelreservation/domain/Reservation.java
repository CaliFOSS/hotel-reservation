package hotelreservation.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private int idreservations;
    @Column(name = "start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @Column(name = "end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @ManyToOne
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "users_idusers", referencedColumnName = "idusers")
    private Users users;

    public Reservation() {
    }

    public Reservation(int idreservations, LocalDate startDate, LocalDate endDate, Hotel hotel, Users users) {
        this.idreservations = idreservations;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hotel = hotel;
        this.users = users;
    }

    public Reservation(LocalDate startDate, LocalDate endDate, Hotel hotel, Users users) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.hotel = hotel;
        this.users = users;
    }

    public int getIdreservations() {
        return idreservations;
    }

    public void setIdreservations(int idreservations) {
        this.idreservations = idreservations;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate getStart_date() {
        return startDate;
    }

    public void setStart_date(LocalDate start_date) {
        this.startDate = start_date;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public LocalDate getEnd_date() {
        return endDate;
    }

    public void setEnd_date(LocalDate end_date) {
        this.endDate = end_date;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users user) {
        this.users = user;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idreservations=" + idreservations +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", hotel=" + hotel +
                ", users=" + users +
                '}';
    }
}
