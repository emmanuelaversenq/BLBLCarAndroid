package com.example.eaversenq.blblcar_android.model;

import android.util.Log;

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
        calcDistance();
    }

    //calcule la distance entre deux points
    private void calcDistance()  {
        double a = Math.PI / 180;
        double lat1 = latitude * a;
        double lat2 = Connexion.getInstance().getLatitude() * a;
        double lon1 = longitude * a;
        double lon2 = Connexion.getInstance().getLongitude() * a;
        double t1 = Math.sin(lat1) * Math.sin(lat2);
        double t2 = Math.cos(lat1) * Math.cos(lat2);
        double t3 = Math.cos(lon1 - lon2);
        double t4 = t2 * t3;
        double t5 = t1 + t4;
        double rad_dist = Math.atan(-t5/Math.sqrt(-t5 * t5 +1)) + 2 * Math.atan(1);
        distance = (rad_dist * 3437.74677 * 1.1508) * 1.6093470878864446;
 //       distance /= 1000;
        Log.i("List", "Distance = " + distance);
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
