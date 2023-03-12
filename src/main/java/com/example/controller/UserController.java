package com.example.controller;

import com.example.entity.User;
import com.example.exception.UserAlreadyFoundException;
import com.example.exception.UserNotFoundException;
import com.example.service.UserService;
import com.example.serviceImpl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

//    working
    @PostMapping("/user")
    public User createUser(@RequestBody User user) throws UserAlreadyFoundException {
        return userService.registerUser(user);
    }


//    working
    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam("userName") String userName,
                                  @RequestParam("password") String password) throws UserNotFoundException {
        User login = userService.loginUser(userName, password);
        if(login != null){
            return new ResponseEntity(login, HttpStatus.OK);
        }else {
            return new ResponseEntity("User not found", HttpStatus.BAD_REQUEST);
        }
    }

//    working
    @PutMapping("/updatePassword")
    public void changePassword(@RequestBody User user) throws UserNotFoundException{
         userService.changePassword(user);
    }

//    working
    @GetMapping("/user/byUserName/{userName}")
    public ResponseEntity<User> searchUserByUserName(@PathVariable String userName) throws UserNotFoundException{
        User user = null;
        try{
            user = userService.searchUserByUserName(userName);
        }catch (UserNotFoundException e){
            e.getMessage();
        }
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity("User not found with userName "+userName, HttpStatus.BAD_REQUEST);
        }
    }

//    working
    @GetMapping("/user/byUserId/{userId}")
    public ResponseEntity<User> searchUserByUserId(@PathVariable int userId) throws UserNotFoundException{
        User user = null;
        try{
            user = userService.searchUserByUserId(userId);
        }catch (UserNotFoundException e){
            e.getMessage();
        }
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity("User not found with userId "+userId, HttpStatus.BAD_REQUEST);
        }
    }
}
