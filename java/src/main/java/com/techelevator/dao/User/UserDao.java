package com.techelevator.dao.User;

import com.techelevator.dao.User.model.RegisterUserDto;
import com.techelevator.dao.User.model.User;

import java.security.Principal;
import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);

    User getLoggedInUserByPrinciple(Principal principal);
}
