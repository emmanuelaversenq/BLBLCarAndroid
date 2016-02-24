package com.example.eaversenq.blblcar_android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.eaversenq.blblcar_android.model.IdentificationThread;
import com.example.eaversenq.blblcar_android.model.User;
import com.example.eaversenq.blblcar_android.model.UserListAll;
import com.example.eaversenq.blblcar_android.service.AbonneService;
import com.example.eaversenq.blblcar_android.service.IdentificationService;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class IdentificationActivity extends Activity {

    // Variables traitement thread
    private boolean bLoginOk;
    private IdentificationThread identity;
    private String strTrairement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);

        // visibilité

        TextView res = (TextView) findViewById(R.id.idRes);
        res.setVisibility(View.GONE);

        // NAVIGATION : retour à l'écran d'accueil
        Button but_exit = (Button) findViewById(R.id.but_exit);
        but_exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AccueilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }


    public void onClick(View v) {
        TextView login = (TextView) findViewById(R.id.lg);
        TextView motpasse = (TextView) findViewById(R.id.mp);
        final TextView res = (TextView) findViewById(R.id.idRes);

        // Handler de communication avec le thread d'identification
        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(final Message msg) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        strTrairement = identity.getResultBack();
                        bLoginOk = IdentificationService.abonneIdenifieBDD(strTrairement);
                        // if (IdentificationService.abonneIdenifie(login.getText().toString(), motpasse.getText().toString())){
                        if (bLoginOk){
                            // Toast.makeText(this, "mot de passe corret", Toast.LENGTH_LONG).show();
                            Button IdSeconnecter = (Button) findViewById(R.id.IdSeconnecter);
                            IdSeconnecter.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    Intent intent = new Intent(view.getContext(), AbonneActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                    startActivityForResult(intent, 0);
                                }
                            });

                        } else {
                            res.setVisibility(View.VISIBLE);
                           // Toast.makeText(this, R.string.msgLoginPwd, Toast.LENGTH_LONG).show();
                        }
                                          }
                });
                return false;
            }
        });
        identity = new IdentificationThread(handler,login.getText().toString(),motpasse.getText().toString());
        identity.execute();




    }


}

