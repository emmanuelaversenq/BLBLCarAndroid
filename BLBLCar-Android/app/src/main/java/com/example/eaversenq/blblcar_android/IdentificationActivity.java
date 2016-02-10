package com.example.eaversenq.blblcar_android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;

public class IdentificationActivity extends Activity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);

        // NAVIGATION : vers l'écran des abonnés
        Button IdSeconnecter = (Button) findViewById(R.id.but_abonne);
        IdSeconnecter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AbonneActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivityForResult(intent, 0);
            }
        });

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

        if (login.getText().toString().equals("khalil") && motpasse.getText().toString().equals("1234")) {

            Toast.makeText(this, "mot de passe corret", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Login ou mot de passe incorrect", Toast.LENGTH_LONG).show();

        }
    }
}
