package com.example.serviceImpl;

import com.example.entity.User;
import com.example.exception.UserAlreadyFoundException;
import com.example.exception.UserNotFoundException;
import com.example.repository.UserRepo;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;


    @Override
    public User registerUser(User user) throws UserAlreadyFoundException{
        if(user != null){
            return userRepo.save(user);
        }else{
            throw new UserAlreadyFoundException("User already present with userId");
        }
    }

    @Override
    public User loginUser(String userName, String password) throws UserNotFoundException {
        if(userRepo.existsByUserName(userName) != null){
            User user = userRepo.findByUserName(userName);
            if(user.getPassword().equals(password)){
                return user;
            }else{
                System.out.println("userName or password incorrect");
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public void changePassword(User user) throws UserNotFoundException{
        userRepo.save(user);
    }

//    @Override
//    public void forgotPassword(String userName) {
//        User user = new User(userName);
//        userRepo.save(user);
//    }

//    notWorking
    @Override
    public void emailPassword(String email) {

    }

    @Override
    public User searchUserByUserName(String userName) throws UserNotFoundException{
        if(userName != null){
            return userRepo.readUserByUserName(userName);
        }else{
            throw new UserNotFoundException("user not found for the given userName ");
        }
    }

    @Override
    public User searchUserByUserId(int userId) throws UserNotFoundException{
        if(userId != 0){
            return userRepo.readUserByUserId(userId);
        }else{
            throw new UserNotFoundException("user not found for the given userId ");
        }
    }
}
