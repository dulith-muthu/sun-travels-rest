package it.suntravelrest.service.base;

import it.suntravelrest.model.User;

import java.util.List;

public interface UserService
{
    List<User> getAllUsers();
    User getUserByUserName(String user);
    User authenticateUser(String userName, String password);
}
