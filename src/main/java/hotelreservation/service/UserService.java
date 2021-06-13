package hotelreservation.service;

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



}
