package com.example.springsecuritywithdatabase;

import com.example.springsecuritywithdatabase.model.User;
import com.example.springsecuritywithdatabase.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringsecuritywithdatabaseApplication implements CommandLineRunner {


	@Autowired
	UserRepos userRepos;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritywithdatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setId(1l);
		user.setRole("ROLE_NORMAL");
		user.setName("Aksh");
		user.setEmail("akash1@gmail.com");
		user.setPassword(passwordEncoder.encode("1234567890"));
		user.setUsername("akash");
//		userRepos.save(user);
	}
}
