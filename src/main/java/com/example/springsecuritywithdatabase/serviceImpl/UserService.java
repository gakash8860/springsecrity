package com.example.springsecuritywithdatabase.serviceImpl;

import com.example.springsecuritywithdatabase.model.User;
import com.example.springsecuritywithdatabase.repos.UserRepos;
import com.example.springsecuritywithdatabase.services.UserServiceSimple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements UserServiceSimple {


  @Autowired
  UserRepos userRepos;

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepos.findAll();
        return users;
    }

    @Override
    public User getUser(String userName) {
        List<User> users = userRepos.findAll();
        return users.stream().filter((user)->user.getUsername().equalsIgnoreCase(userName)).findAny().get();
    }

    @Override
    public User addUser(User user) {
        userRepos.save(user);
        return user;
    }
}
