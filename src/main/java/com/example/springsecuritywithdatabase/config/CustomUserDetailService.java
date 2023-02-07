package com.example.springsecuritywithdatabase.config;

import com.example.springsecuritywithdatabase.model.User;
import com.example.springsecuritywithdatabase.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepos userRepos;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepos.findByUserName(username);
       if (Objects.isNull(user)){
           throw new UsernameNotFoundException("User not found");
       }
       return new CustomUserDetails(user);
    }
}
