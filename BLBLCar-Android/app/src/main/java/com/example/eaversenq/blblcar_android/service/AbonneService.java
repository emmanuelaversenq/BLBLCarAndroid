package com.example.eaversenq.blblcar_android.service;

import com.example.eaversenq.blblcar_android.model.User;

import java.util.ArrayList;
import java.util.List;

public class AbonneService {

    public static ArrayList<User> fournirListeUser(long idUser, double radius) {

        ArrayList<User> result = new ArrayList<User>();
        User user;

        user = new User("", "", "DUPONT", "Jean-Pierre", "jp-dupont@free.fr", "", "", "", false, false);
        result.add(user);
        user = new User("", "", "AVERSENQ", "Emmanuel", "emmanuel.aversenq@berger-levrault.fr", "", "", "", false, false);
        result.add(user);
        user = new User("", "", "DURAND", "Louise", "ld@wanadoo.fr", "", "", "", false, false);
        result.add(user);

        return result;
    }
}
