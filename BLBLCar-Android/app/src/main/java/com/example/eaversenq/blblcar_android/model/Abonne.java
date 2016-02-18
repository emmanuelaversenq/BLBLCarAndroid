package com.example.eaversenq.blblcar_android.model;

public class Abonne {

    String prenom;
    String nom;
    String email;
    double longitude;
    double latitude;
    double distance;

    public Abonne(String prenom, String nom, String email, String longitude, String latitude, String distance) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.longitude = Double.parseDouble(longitude);
        this.latitude = Double.parseDouble(latitude);
        this.distance = Double.parseDouble(distance);
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getDistance() {
        return distance;
    }
}
