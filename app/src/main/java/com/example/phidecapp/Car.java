package com.example.phidecapp;

public class Car {
    private int id;
    private String nom,matricule,conducteur,cg,dateexp,npermis,getDateexpp,cin,datevcin,carburant,assurance,nchassi,modele;
    public Car(int id,String nom,String modele, String matricule, String conducteur, String cg, String dateexp, String npermis, String getDateexpp, String cin, String datevcin, String carburant, String assurance, String nchassi) {
        this.id = id;
        this.nom = nom;
        this.modele=modele;
        this.matricule = matricule;
        this.conducteur = conducteur;
        this.cg = cg;
        this.dateexp = dateexp;
        this.npermis = npermis;
        this.getDateexpp = getDateexpp;
        this.cin = cin;
        this.datevcin = datevcin;
        this.carburant = carburant;
        this.assurance = assurance;
        this.nchassi = nchassi;

    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getConducteur() {
        return conducteur;
    }

    public String getCg() {
        return cg;
    }

    public String getDateexp() {
        return dateexp;
    }

    public String getNpermis() {
        return npermis;
    }

    public String getGetDateexpp() {
        return getDateexpp;
    }

    public String getCin() {
        return cin;
    }

    public String getDatevcin() {
        return datevcin;
    }

    public String getCarburant() {
        return carburant;
    }

    public String getAssurance() {
        return assurance;
    }

    public String getNchassi() {
        return nchassi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setConducteur(String conducteur) {
        this.conducteur = conducteur;
    }

    public void setCg(String cg) {
        this.cg = cg;
    }

    public void setDateexp(String dateexp) {
        this.dateexp = dateexp;
    }

    public void setNpermis(String npermis) {
        this.npermis = npermis;
    }

    public void setGetDateexpp(String getDateexpp) {
        this.getDateexpp = getDateexpp;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setDatevcin(String datevcin) {
        this.datevcin = datevcin;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public void setAssurance(String assurance) {
        this.assurance = assurance;
    }

    public void setNchassi(String nchassi) {
        this.nchassi = nchassi;
    }
}
