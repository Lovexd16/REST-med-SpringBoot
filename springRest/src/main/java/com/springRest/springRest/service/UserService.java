package com.springRest.springRest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springRest.springRest.api.model.User;

@Service
public class UserService {
    
    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
        userList.add(new User(1, "Kalle", 20));
        userList.add(new User(2, "Anna", 30));
        userList.add(new User(3, "Bengt", 29));
        userList.add(new User(4, "Kajsa", 56));
    }

    public User getUser(Integer id) {
        return userList.stream()
        .filter(user -> id.equals(user.getId()))
        .findFirst()
        .orElse(null);
    }

    public List<User> getUsers() {
        return userList;
    }

}
