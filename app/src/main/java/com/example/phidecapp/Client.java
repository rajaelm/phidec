package com.example.phidecapp;

public class Client {
    private int id;

    private String nomp;
    private String credit;
    private String debit;
    private String nom_client;
    private String ville;
    private String phone;
    private String email;
    private String rs;
    private String com;

    public Client(int id, String nomp, String credit, String debit, String nom_client, String ville, String phone, String email, String rs, String com) {
        this.id = id;

        this.nomp = nomp;
        this.credit = credit;
        this.debit = debit;
        this.nom_client = nom_client;
        this.ville = ville;
        this.phone = phone;
        this.email = email;
        this.rs = rs;
        this.com = com;
    }

    public int getId() {
        return id;
    }



    public String getNomp() {
        return nomp;
    }

    public String getCredit() {
        return credit;
    }

    public String getDebit() {
        return debit;
    }

    public String getNom_client() {
        return nom_client;
    }

    public String getVille() {
        return ville;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getRs() {
        return rs;
    }

    public String getCom() {
        return com;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setNomp(String nomp) {
        this.nomp = nomp;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRs(String rs) {
        this.rs = rs;
    }

    public void setCom(String com) {
        this.com = com;
    }
}
