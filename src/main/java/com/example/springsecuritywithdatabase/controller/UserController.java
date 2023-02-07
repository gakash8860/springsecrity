package com.example.springsecuritywithdatabase.controller;

import com.example.springsecuritywithdatabase.serviceImpl.UserService;
import com.example.springsecuritywithdatabase.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public List<User> getAllUser(){
        return new ArrayList<>();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return userService.getUser(username);
    }


    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }






}
