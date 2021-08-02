package com.example.phidecapp;

public class List_data {
    private String nom;
    private String email;
    private String rs;

    public List_data(String nom, String email, String rs) {
        this.nom = nom;
        this.email = email;
        this.rs = rs;
    }



    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }
    public String getRs() {
        return rs;
    }
}
