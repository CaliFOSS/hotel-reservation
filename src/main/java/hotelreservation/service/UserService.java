package hotelreservation.service;

import hotelreservation.domain.Users;
import hotelreservation.domain.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;


    public boolean isAuthorized(int userId, String password){
       if( usersRepository.findByPasswordAndIdusers(password, userId) != null){
           return true;
       }
       return false;
    };

    public Users authenticateUser(String firstname, String password){
        Users tempUser = usersRepository.findByfirstNameAndPassword(firstname, password);
        if ( tempUser != null){
            tempUser.setAuthenticated(true);
            return tempUser;
        }
        return tempUser;
    }



}
