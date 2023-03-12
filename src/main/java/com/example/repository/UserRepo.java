package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select count(*) from User u where u.userName=?1")
    public String existsByUserName(String userName);

    @Query("select u from User u where u.userName=?1")
    public User findByUserName(String userName);

//    public void forgotPassword(String userName);

    @Query(nativeQuery = true, value= "Select * from user_table u where u.user_name=?1")
    public User readUserByUserName(String userName);

    @Query(nativeQuery = true, value= "Select * from user_table u where u.user_id=?1")
    public User readUserByUserId(int userId);
}
