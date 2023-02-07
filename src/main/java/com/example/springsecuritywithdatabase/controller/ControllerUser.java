package com.example.springsecuritywithdatabase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class ControllerUser {


    @GetMapping("/home")
    public String home() {
        return "this is home page";
    }


    @GetMapping("/login")
    public String login() {
        return "this is login page";
    }

    @GetMapping("/reg")
    public String reg() {
        return "this is signup page";
    }

}
