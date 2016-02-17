package com.example.eaversenq.blblcar_android.service;

/**
 * Created by KSAHNOUNE on 17/02/2016.
 */
public class IdentificationService {

     public static boolean abonneIdenifie(String login, String motDepasse) {
        if (login.equals("khalil") && motDepasse.equals("1234")) {
            return true;
        } else {
            return false;
        }
    }
}
