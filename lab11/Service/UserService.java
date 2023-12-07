package com.example.lab11.Service;


import com.example.lab11.API.ApiException;
import com.example.lab11.Model.User;
import com.example.lab11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {



    private final UserRepository userRepository;



    public List<User>  getAllUses(){

        return userRepository.findAll();
    }


    public void addUses(User user){

        userRepository.save(user);
    }


    public User updateUser(Integer id , User user){

        User user1 = userRepository.findUserByUserId(id);
        if(user1==null){
            throw new ApiException("Uses id not found");

        }
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setRegistrationDate(user.getRegistrationDate());


        userRepository.save(user1);
        return user1;
    }


    public void deleteUser(Integer id){

        User user = userRepository.findUserByUserId(id);
        if(user == null){
            throw new ApiException("user id not found");
        }
        userRepository.delete(user);

    }



    public  User Check(String username , String password){

        User user = userRepository.pleasCheckPasswordAndUsername(username,password);

        if(user == null){
            throw new ApiException("username and password not correct");

        }
        return user;
    }



}

