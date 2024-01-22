package com.springRest.springRest.api.model;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private int age;
    
    public User(String name, int age) {
        id = UUID.randomUUID();
        this.name = name;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
}
