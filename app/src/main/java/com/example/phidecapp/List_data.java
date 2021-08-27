package com.example.phidecapp;

public class List_data {
    private int id;
    private String nom;
    private String username;
    private String email;
    private String cin;
    private String ville;
    private String rs;
    private String phone;
    private String addresse;

    public List_data(int id, String nom, String username, String email, String cin, String ville, String rs, String phone, String addresse) {
        this.id= id;
        this.nom = nom;
        this.username = username;
        this.email = email;
        this.cin = cin;
        this.ville = ville;
        this.rs = rs;
        this.phone = phone;
        this.addresse = addresse;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getCin() {
        return cin;
    }

    public String getVille() {
        return ville;
    }

    public String getRs() {
        return rs;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }
}
