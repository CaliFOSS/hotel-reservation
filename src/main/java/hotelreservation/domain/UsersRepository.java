package hotelreservation.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    Users findByLastName(String lastname);
    Users findByidusers(int id);
    Users findByPasswordAndIdusers(String password, int id);
    Users findByfirstNameAndPassword(String firstName, String password);
}
