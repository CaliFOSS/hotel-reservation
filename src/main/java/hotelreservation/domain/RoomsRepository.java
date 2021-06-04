package hotelreservation.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RoomsRepository extends JpaRepository<Room, String> {
    Room findRoomsByHotelAndDate(Hotel hotel, LocalDate date);

}
