package com.social.network.services;

import com.social.network.dao.UserRepository;
import com.social.network.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository usersRepository;
    public ResponseEntity<Object> getAllUsers() {
        List<User> dbUsers = usersRepository.findAll();
        if (dbUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // TODO Auto-generated method stub
        return new ResponseEntity<>(dbUsers, HttpStatus.OK);
    }
}