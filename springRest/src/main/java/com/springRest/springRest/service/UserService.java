package com.springRest.springRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springRest.springRest.api.model.User;

@Service
public class UserService {
    
    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();
        userList.add(new User("Kalle", 20));
        userList.add(new User("Anna", 30));
        userList.add(new User("Bengt", 29));
        userList.add(new User("Kajsa", 56));
    }

    public User getUser(UUID id) {
        return userList.stream()
        .filter(user -> id.equals(user.getId()))
        .findFirst()
        .orElse(null);
    }

    public List<User> getUsers() {
        return userList;
    }

    public User createUser(User user) {
        userList.add(user);
        return user;
    }

    public User editUser(UUID id, User updateUser) {
        User editUser = userList.stream()
        .filter(user -> user.getId().equals(id))
        .findFirst()
        .orElse(null);

        if(editUser != null) {
            editUser.setName(updateUser.getName());
        }

        return editUser;
    }

}
