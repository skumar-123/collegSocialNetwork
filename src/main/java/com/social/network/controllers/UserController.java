package com.social.network.controllers;

import com.social.network.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUsers")
    public ResponseEntity<Object> getAllUsers() {
        return userService.getAllUsers();
    }

}
