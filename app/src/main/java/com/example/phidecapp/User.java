package com.example.phidecapp;

public class User {
    private int id;
    private String name, username, email, telephone;

    public User(int id, String name, String username, String email, String telephone) {
        this.id = id;
        this.email = email;
        this.username=username;
        this.telephone = telephone;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //set and get username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;

    }
}
