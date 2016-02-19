package com.example.eaversenq.blblcar_android.model;

import android.location.Address;
import android.location.Geocoder;

import android.content.Context;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

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
    private double distance; //distance avec abonnée.
    private double latitude;
    private double longitude;

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
        distance=0.0;
        latitude=0.0;
        longitude=0.0;
    }

    public User(String login, String pwd, String nom, String prenom, String email, String adresse, String codePostal,
                String ville, boolean passager, boolean conducteur, double distance, double latitude, double longitude) {
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
        this.distance = distance;
        this.latitude = latitude;
        this.longitude = longitude;

    }

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

    public double getDistance() {return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getLatitude() { return latitude; }
    public void setatitude(double latitude) { this.latitude = latitude; }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", adresse='" + adresse + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", passager=" + passager +
                ", conducteur=" + conducteur +
                ", distance=" + distance +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
