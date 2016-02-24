package com.example.eaversenq.blblcar_android.model;

public class Connexion {

    private static Connexion cnx;

    private Connexion(){}

    public static Connexion getInstance() {
        if (cnx == null) cnx = new Connexion();
        return cnx;
    }
}
