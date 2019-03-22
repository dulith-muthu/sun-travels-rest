package it.suntravelrest.service;

import it.suntravelrest.model.User;
import it.suntravelrest.repository.UserRepository;
import it.suntravelrest.service.base.UserService;
import it.suntravelrest.utill.PasswordUtill;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    public UserServiceImpl( UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    @Override public User getUserByUserName(String userName)
    {
        return userRepository.findOneByUserName( userName );
    }

    @Override public User authenticateUser( String userName, String password )
    {
        User currentUser = userRepository.findOneByUserName( userName );
        String inputPasswordHash = PasswordUtill.getHash( password+currentUser.getSalt() );
        if(inputPasswordHash.equals( currentUser.getPassword() )){
            return currentUser;
        }
        return null;
    }


}
