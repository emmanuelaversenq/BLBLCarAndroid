package com.example.eaversenq.blblcar_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        // Navigation : vers l'écran d'identification
        Button but_inscription = (Button)findViewById(R.id.but_inscription);
        but_inscription.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), InscriptionActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });

//        // Navigation : vers l'écran d'inscription
//        Button but_inscription = (Button)findViewById(R.id.but_inscription);
//        but_inscription.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent myIntent = new Intent(view.getContext(), InscriptionActivity.class);
//                startActivityForResult(myIntent, 0);
//            }
//        });
    }
}
