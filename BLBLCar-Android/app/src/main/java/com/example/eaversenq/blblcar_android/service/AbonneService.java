package com.example.eaversenq.blblcar_android.service;

import android.util.Log;

import com.example.eaversenq.blblcar_android.model.Abonne;
import com.example.eaversenq.blblcar_android.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AbonneService {

    public static ArrayList<Abonne> fournirListeAbonne(String strJson) {
        ArrayList<Abonne> result = new ArrayList<Abonne>();
        Abonne abonne;

        try {
            JSONArray jArray = new JSONArray(strJson);
            for(int i=0;i<jArray.length();i++){
                JSONObject json_data = jArray.getJSONObject(i);
                // abonne = new Abonne(json_data.getString("firstname"), json_data.getString("name").toUpperCase(), json_data.getString("email"), json_data.getString("longitude"),  json_data.getString("latitude"));
                abonne = new Abonne(json_data.getString("firstName"), json_data.getString("name").toUpperCase(), json_data.getString("email"), "",  "");
                result.add(abonne);
            }
        } catch(JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }
        return result;
    }
}
