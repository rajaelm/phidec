package com.example.phidecapp;

public class User {
    private int id;
    private String name, email, rs;

    public User(int id, String name, String email, String rs) {
        this.id = id;
        this.email = email;
        this.rs = rs;
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


    public String getRS() {
        return rs;
    }

    public void setRc(String rs) {
        this.rs = rs;

    }
}
