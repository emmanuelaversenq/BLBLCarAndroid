package com.example.eaversenq.blblcar_android.service;

import com.example.eaversenq.blblcar_android.model.User;

import java.util.ArrayList;

public class AbonneService {

    public ArrayList<User> fournirListeUser() {

        ArrayList<User> result = null;
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
