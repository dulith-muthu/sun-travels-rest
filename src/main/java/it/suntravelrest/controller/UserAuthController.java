package it.suntravelrest.controller;

import io.swagger.annotations.ApiOperation;
import it.suntravelrest.model.User;
import it.suntravelrest.model.viewmodel.UserViewModel;
import it.suntravelrest.service.base.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(UserAuthController.BASE_URL)
public class UserAuthController
{
    public static final String BASE_URL = "/api/v1/auth";
    private final UserService userService;

    public UserAuthController( UserService userService )
    {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation( value = "Get all Users")
    List<User> getAllHotels(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    @ApiOperation( value = "Get user by UserName")
    User getUserByUserName( @PathVariable String userName ){
        return userService.getUserByUserName(userName);
    }

    @RequestMapping(value = "/authenticateUser", method = RequestMethod.POST)
    @ApiOperation( value = "Authenticate user by user name and password")
    HttpStatus getUserByUserName( @RequestBody UserViewModel user ){
        if(userService.authenticateUser(user.getUserName(), user.getPassword()) != null){
            return HttpStatus.ACCEPTED;
        }
        else
            return HttpStatus.UNAUTHORIZED;
    }
}
