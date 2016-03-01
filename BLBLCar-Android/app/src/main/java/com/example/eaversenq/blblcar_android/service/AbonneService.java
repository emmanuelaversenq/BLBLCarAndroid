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
                abonne = new Abonne(json_data.getString("firstName"), json_data.getString("name").toUpperCase(), json_data.getString("email"), json_data.getString("longitude"),  json_data.getString("latitude"));
                result.add(abonne);
            }
        } catch(JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }
        if (result.size() == 0) result = defaultFournirListeAbonne();
        return result;
    }

    /*
     * méthode bouchon qui donne un exemple de fourniture de données
     */
    public static ArrayList<Abonne> defaultFournirListeAbonne() {
        ArrayList<Abonne> result = new ArrayList<Abonne>();

        Log.i("List", "Le service « fournirListeAbonne » n'a retourné aucun abonné");
        result.add(new Abonne("Paul", "DURAND", "paul.durand@wanadoo.fr", "1.4476179000000684", "43.6086616"));
        result.add(new Abonne("Jenny", "KETAMER", "jenny.ketamer@free.fr", "1.4476179000000684", "43.6489616"));
        result.add(new Abonne("Nadine", "AMOK", "nadine.amok@gmail.com", "1.5134387000000515", "43.545368"));
        result.add(new Abonne("Julien", "ZARBI", "julien.zarbi@gmail.com", "1.398490914143622","43.609184087368526"));

        return result;
    }
}
