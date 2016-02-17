package com.example.eaversenq.blblcar_android;

/**
 * Created by KSAHNOUNE on 10/02/2016.
 */
public class Abonne {

    private String login;
    private String motPasse;


    public Abonne() {
    }

    public Abonne(String login, String motPasse) {
        this.login = login;
        this.motPasse = motPasse;
    }
    public boolean abonneInscrit() {
        if (getLogin().equals("khalil") && getMotPasse().equals("1234")) {
            return true;
        } else {
            return false;
        }
    }
    public String getLogin() {
        return login;
    }

    public String getMotPasse() {
        return motPasse;
    }
}
