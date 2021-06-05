package hotelreservation.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String > {
    Hotel findHotelByName(String Name);
    List<Hotel> findHotelByCityAndState(String City, String State);

}
