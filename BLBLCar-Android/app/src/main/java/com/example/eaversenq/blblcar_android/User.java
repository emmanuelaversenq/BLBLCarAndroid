package com.example.eaversenq.blblcar_android;

/**
 * Created by JFBIRE on 10/02/2016.
 */
public class User {
    private String login;
    private String pwd;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String codePostal;
    private String ville;
    private boolean passager;
    private boolean conducteur;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public boolean isPassager() {
        return passager;
    }

    public void setPassager(boolean passager) {
        this.passager = passager;
    }

    public boolean isConducteur() {
        return conducteur;
    }

    public void setConducteur(boolean conducteur) {
        this.conducteur = conducteur;
    }

    public User() {
        login = "";
        pwd ="";
        nom="";
        prenom="";
        email="";
        adresse="";
        codePostal="";
        ville="";
        passager=false;
        conducteur=false;
    }

    public User(String login, String pwd, String nom, String prenom, String email, String adresse, String codePostal, String ville, boolean passager, boolean conducteur) {
        this.login = login;
        this.pwd = pwd;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.passager = passager;
        this.conducteur = conducteur;
    }
}
