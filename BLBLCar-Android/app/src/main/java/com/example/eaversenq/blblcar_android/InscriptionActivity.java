package com.example.eaversenq.blblcar_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InscriptionActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        // Navigation : vers l'écran des abonnés
        Button but_abo = (Button)findViewById(R.id.but_abo);
        but_abo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AbonneActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

        // Navigation : fermeture, retour à l'écran d'accueil
//        Button but_acc = (Button) findViewById(R.id.but_acc);
//        but_acc.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent myIntent = new Intent();
//                setResult(RESULT_OK, myIntent);
//                finish();
        //            }
        //        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_CANCELED) {
            Intent myIntent = new Intent();
                setResult(RESULT_OK, myIntent);
                finish();
        }

    }
}
