package com.example.service;

import com.example.entity.User;
import com.example.exception.UserAlreadyFoundException;
import com.example.exception.UserNotFoundException;

public interface UserService {

    public User registerUser(User user) throws UserAlreadyFoundException;
    public User loginUser(String userName, String password) throws UserNotFoundException;
    public void changePassword(User user);
//    public void forgotPassword(String userName);
    public void emailPassword(String email);
    public User searchUserByUserName(String userName);
    public User searchUserByUserId(int userId);

}
