package com.example.eaversenq.blblcar_android.model;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by SGUILLERMOND on 24/02/2016.
 */
public class InscriptionThread extends AsyncTask<Void,Void,Void>  {

    String resultBack = new String();
    String log = null;
    String pwd = null;

    private Handler handler;
    private User userToSave;

    public String getResultBack() {
        return resultBack;
    }

    public void setResultBack(String resultBack) {
        this.resultBack = resultBack;
    }

    // constructeur public, liaison avec le Handler du service: AbonneeService
    public InscriptionThread(Handler handler, User user) {
        super();
        this.handler = handler;
        this.userToSave = user;
    }

    // not in use, but needed
    protected void onPreExecute() {
        //   Log.i("Stephan","PreExecute");
        //   Log.i("handler preExecute", resultBack);
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            String nom = URLEncoder.encode(userToSave.getNom(),"UTF-8");
            String prenom = URLEncoder.encode(userToSave.getPrenom(),"UTF-8");
            log = URLEncoder.encode(userToSave.getLogin(),"UTF-8");
            pwd = URLEncoder.encode(userToSave.getPwd(),"UTF-8");
            String email = URLEncoder.encode(userToSave.getEmail(),"UTF-8");
            String street =URLEncoder.encode(userToSave.getAdresse(),"UTF-8");
            Double longi = userToSave.getLongitude();
            String slongi = URLEncoder.encode(""+longi,"UTF-8");
            Double lat = userToSave.getLatitude();
            String slat = URLEncoder.encode("" + lat,"UTF-8");
            Double distance = userToSave.getDistance();
            String sdistance = URLEncoder.encode("" + distance,"UTF-8");
            String cp = URLEncoder.encode(userToSave.getCodePostal(),"UTF-8");
            String city = URLEncoder.encode(userToSave.getVille(),"UTF-8");
            String param = "city="+city+"&log="+log+"&pwd="+pwd+"&lat="+slat+"&nom="+nom+"&email="+email+"&prenom="+prenom+"&long="+slongi+"&distance="+sdistance+"&cp="+cp+"&street="+street;


            String strURl = "http://blblcar.cloudapp.net/inscription.php?"+param;
            Log.i("stephan",strURl);
            URL url = new URL(strURl);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(false);

            // int response = con.getResponseCode();
            //  String mess = con.getResponseMessage();

            //Log.i("stephan","log " + log + " pwd: "+pwd);
            // Log.i("Stephan","Message " + mess);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }
            br.close();
            resultBack = sb.toString();
            // Log.i("stephan", resultBack);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void result) {
        // utilisation du HAndler
        Message message = new Message();
        handler.sendMessage(message);
        // Log.i("depuis handler PostEx", resultBack);
    }

}
