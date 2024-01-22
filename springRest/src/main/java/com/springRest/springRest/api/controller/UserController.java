package com.springRest.springRest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.springRest.api.model.User;
import com.springRest.springRest.service.UserService;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/user")
    public User getUser(@RequestParam Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();

    }
}
