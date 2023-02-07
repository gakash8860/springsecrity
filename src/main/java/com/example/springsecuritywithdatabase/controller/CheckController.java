package com.example.springsecuritywithdatabase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class CheckController {

@GetMapping("/welcome")
    public String welco(){
    return "welcome";
}


}
