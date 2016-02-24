package com.example.eaversenq.blblcar_android.model;

public class Abonne {

    String prenom;
    String nom;
    String email;
    double longitude;
    double latitude;
    double distance;

    public Abonne(String prenom, String nom, String email, String longitude, String latitude) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.longitude = (longitude == null || longitude.equals("") ? 0. : Double.parseDouble(longitude));
        this.latitude = (latitude == null || latitude.equals("") ? 0. : Double.parseDouble(latitude));
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
