package com.example.springsecuritywithdatabase.services;

import com.example.springsecuritywithdatabase.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceSimple {
    List<User> getAllUser();
    User getUser(String userName);
    User addUser(User user);
}
