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

/**
 * Created by SGUILLERMOND on 17/02/2016.
 */
public class IdentificationThread extends AsyncTask<Void,Void,Void> {
    String resultBack = new String();
    String log = null;
    String pwd = null;

    private Handler handler;

    public String getResultBack() {
        return resultBack;
    }

    public void setResultBack(String resultBack) {
        this.resultBack = resultBack;
    }

    // constructeur public, liaison avec le Handler du service: AbonneeService
    public IdentificationThread(Handler handler, String log, String pwd) {
        super();
        this.handler = handler;
        this.log = log;
        this.pwd = pwd;//  Log.i("Stephan", "Init avec Handler");
    }

    // not in use, but needed
    protected void onPreExecute() {
        //   Log.i("Stephan","PreExecute");
        //   Log.i("handler preExecute", resultBack);
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            String strURl = "http://blblcar.cloudapp.net/testLogin.php?log="+log+"&pwd="+pwd+" ";
            Log.i("stephan",strURl);
            URL url = new URL(strURl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setDoOutput(true);

              int response = con.getResponseCode();
            //  String mess = con.getResponseMessage();

             Log.i("stephan","Code " + response);
            // Log.i("Stephan","Message " + mess);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }
            br.close();

            // Log.i("stephan", sb.toString());
            resultBack = sb.toString();
            //Log.i("depuis handler inBack", resultBack);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Void result) {
        // Log.i("Stephan","PostExecute");

        // utilisation du HAndler
        Message message = new Message();
        handler.sendMessage(message);
        // Log.i("depuis handler PostEx", resultBack);
    }

}

