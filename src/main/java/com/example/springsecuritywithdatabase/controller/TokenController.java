package com.example.springsecuritywithdatabase.controller;

import com.example.springsecuritywithdatabase.config.CustomUserDetailService;
import com.example.springsecuritywithdatabase.helper.JwtUtil;
import com.example.springsecuritywithdatabase.model.JwtRequest;
import com.example.springsecuritywithdatabase.model.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class TokenController {


    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/token")
    public String generateToken(@RequestBody JwtRequest request) {

        try {
//            authenticate(request.getUsername(), request.getPassword());

            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
            UserDetails user = this.customUserDetailService.loadUserByUsername(request.getUsername());
            String token = this.jwtUtil.generateToken(user);
            System.err.println(token);
            return token;
        } catch (Exception exception) {
            exception.printStackTrace();

        }
    return "Invalid Credentials";
    }

    private void authenticate(String username, String password) throws Exception {

        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            token.setDetails(token);

            SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(token));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

