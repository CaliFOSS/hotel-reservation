package hotelreservation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import hotelreservation.domain.Users;
import hotelreservation.domain.UsersRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private UsersRepository userRepo;
     
    @Test
    public void testCreateUser() {
    	Users user = new Users();
    	user.setFirstName("John");
    	user.setLastName("Smith");
    	user.setPassword("testPass");
    	
    	Users savedUser = userRepo.save(user);
    	
    	Users existingUser = entityManager.find(Users.class, savedUser.getIdusers());
    	
    	assertThat(user.getFirstName()).isEqualTo(existingUser.getFirstName());
    }
}