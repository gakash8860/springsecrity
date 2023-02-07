package com.example.springsecuritywithdatabase.repos;


import com.example.springsecuritywithdatabase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends JpaRepository<User,Long> {

   @Query(value = "SELECT * FROM user where username=:username",nativeQuery = true)
    User findByUserName(String username);
}
