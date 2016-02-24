package com.example.eaversenq.blblcar_android.service;

import com.example.eaversenq.blblcar_android.model.Connexion;
import com.example.eaversenq.blblcar_android.model.User;

/**
 * Created by KSAHNOUNE on 24/02/2016.
 */
public class InscriptionService {

    public void inscriptionUser(User user){
        Connexion.getInstance().setLogin(user.getLogin());
        Connexion.getInstance().setPwd(user.getPwd());
        Connexion.getInstance().setNom(user.getNom());
        Connexion.getInstance().setPrenom(user.getPrenom());
        Connexion.getInstance().setEmail(user.getEmail());
        Connexion.getInstance().setAdresse(user.getAdresse());
        Connexion.getInstance().setCodePostal(user.getCodePostal());
        Connexion.getInstance().setVille(user.getVille());
        Connexion.getInstance().setPassager(user.isPassager());
        Connexion.getInstance().setConducteur(user.isConducteur());
        Connexion.getInstance().setDistance(user.getDistance());
        Connexion.getInstance().setLongitude(user.getLongitude());
        Connexion.getInstance().setLongitude(user.getLongitude());
    }
}
