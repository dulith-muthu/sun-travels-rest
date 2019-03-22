package it.suntravelrest.repository;

import it.suntravelrest.model.User;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Long>
{
    User save(User user);
    User findOneByUserName(String userName);
    List<User> findAll();
}
