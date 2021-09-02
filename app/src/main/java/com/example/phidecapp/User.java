package com.example.phidecapp;

public class User {
    private int id;
    private String name, username, email, telephone,ville,addresse,cin,rs;

    public User(int id, String name, String username, String email, String telephone, String ville, String addresse, String cin, String rs) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.ville = ville;
        this.addresse = addresse;
        this.cin = cin;
        this.rs = rs;
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

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public String getVille() {
        return ville;
    }

    public String getAddresse() {
        return addresse;
    }

    public String getCin() {
        return cin;
    }

    public String getRs() {
        return rs;
    }
}
