package com.example.eaversenq.blblcar_android.service;

import android.util.Log;

import com.example.eaversenq.blblcar_android.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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


    public static boolean abonneIdenifieBDD(String strJson) {
        //parse json data
        boolean bloginOk=false;
        try{
            JSONArray jArray = new JSONArray(strJson);
            JSONObject json_data = jArray.getJSONObject(0);

            Log.i("stephan","login service-test: "+json_data.getString("name"));

            if (json_data.getString("name").equals("")){
                bloginOk = false;
            } else {
                bloginOk=true;
            }
             /*  Log.i("log_tag","id: "+json_data.getInt("id")+
                                    ", name: "+json_data.getString("name")+
                                    ", sex: "+json_data.getInt("sex")+
                                    ", birthyear: "+json_data.getInt("birthyear")
                    );*/

        }
        catch(JSONException e){
            Log.e("log_tag", "Error parsing data " + e.toString());
        }
        Log.i("stephan","login service: "+bloginOk);
        return bloginOk;
    }
}
