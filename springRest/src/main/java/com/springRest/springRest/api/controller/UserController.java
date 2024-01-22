package com.springRest.springRest.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    @GetMapping("/user") //För att skriva ut en enskild user med hjälp av id
    public User getUser(@RequestParam UUID id) {
        return userService.getUser(id);
    }

    @GetMapping("/users") //För att skriva ut hela listan av users
    public List<User> getUsers() {
        return userService.getUsers();

    }

    @PostMapping("/user") //Det är OK att det finns 2 med routing "/user" eftersom en är Get, denna är Post!
    public User createUser(@RequestBody User user) {
        System.out.println("user body " + user);
        return userService.createUser(user);
    }
}
