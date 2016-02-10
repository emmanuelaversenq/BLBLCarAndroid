package com.example.eaversenq.blblcar_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InscriptionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        // NAVIGATION : vers l'écran des abonnés
        Button but_abonne = (Button)findViewById(R.id.but_abonne);
        but_abonne.setOnClickListener(new View.OnClickListener() {
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

    /*    if (login.getText().toString().equals("khalil") && motpasse.getText().toString().equals("1234")) {

            Toast.makeText(this, "mot de passe corret", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Login ou mot de passe incorrect", Toast.LENGTH_LONG).show();

        }*/
    }
}
