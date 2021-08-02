package com.example.phidecapp;

public class Client {
    private int id;
    private String name, email, rc;

    public Client(int id, String name, String email, String rc) {
        this.id = id;
        this.email = email;
        this.rc = rc;
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


    public String getRC() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;

    }
}
