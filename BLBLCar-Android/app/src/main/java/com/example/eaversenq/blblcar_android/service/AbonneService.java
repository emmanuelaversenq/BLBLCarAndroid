package com.example.eaversenq.blblcar_android.service;

import android.util.Log;

import com.example.eaversenq.blblcar_android.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    public static ArrayList<User> fournirListeUserBDD(String strJson){
        ArrayList<User> result = new ArrayList<User>();
        User user;

        //parse json data
            try{
                JSONArray jArray = new JSONArray(strJson);
                for(int i=0;i<jArray.length();i++){
                    JSONObject json_data = jArray.getJSONObject(i);
                  /*  Log.i("log_tag","id: "+json_data.getInt("id")+
                                    ", name: "+json_data.getString("name")+
                                    ", sex: "+json_data.getInt("sex")+
                                    ", birthyear: "+json_data.getInt("birthyear")
                    );*/
                    user = new User("", "", json_data.getString("name").toUpperCase(), json_data.getString("firstname"), json_data.getString("email"), "", "", "", false, false);
                    result.add(user);
                }
            }
        catch(JSONException e){
            Log.e("log_tag", "Error parsing data " + e.toString());
        }
        return result;
    }
}
