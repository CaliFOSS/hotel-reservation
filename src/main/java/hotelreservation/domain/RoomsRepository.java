package hotelreservation.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface RoomsRepository extends JpaRepository<Room, String> {
    Room findRoomsByHotelAndDate(Hotel hotel, Date date);

}
