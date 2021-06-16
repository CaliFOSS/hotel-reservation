package hotelreservation.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    Users findByLastName(String lastname);
    Users findByidusers(int id);
    Users findByPasswordAndIdusers(String password, int id);
    @Query("SELECT u FROM Users u WHERE u.firstName = ?1")
    Users findByFirstName(String firstName);
}
