package com.example.eaversenq.blblcar_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.eaversenq.blblcar_android.model.User;
import com.example.eaversenq.blblcar_android.service.AbonneService;

import java.util.ArrayList;

public class AbonneActivity extends Activity {
    private EditText editDepart;
    private EditText editArrivee;
    private Button btnRechercher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abonne);

        // NAVIGATION : modification de l'inscription
        Button but_inscription = (Button)findViewById(R.id.but_inscription);
        but_inscription.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), InscriptionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivityForResult(intent, 0);
            }
        });

        // NAVIGATION : fermeture, retour à l'écran d'accueil
        Button but_exit = (Button) findViewById(R.id.but_exit);
        but_exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AccueilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        //On récupère les composants graphiques
        editDepart = (EditText) findViewById(R.id.editDepart);
        // editArrivee = (EditText) findViewById(R.id.editArrivee);
        editArrivee = (EditText) findViewById(R.id.editArrivée);

        btnRechercher = (Button) findViewById(R.id.btnSearch);

        btnRechercher.setOnClickListener(new OnClickListener() {
            /**
             * {@inheritDoc}
             */
            @Override
            public void onClick(final View v) {
                if("".equals(editDepart.getText().toString().trim())) {
                    Toast.makeText(AbonneActivity.this, "Merci de saisir un lieu de départ", Toast.LENGTH_SHORT).show();
                }
                else if("".equals(editArrivee.getText().toString().trim())) {
                    Toast.makeText(AbonneActivity.this, "Merci de saisir un lieu d'arrivée", Toast.LENGTH_SHORT).show();
                }
                else {
                    //On transmet les données à l'activité suivante
                    final Intent intent = new Intent(AbonneActivity.this, MapsActivity.class);
                    intent.putExtra("DEPART", editDepart.getText().toString().trim());
                    intent.putExtra("ARRIVEE", editArrivee.getText().toString().trim());


                    AbonneActivity.this.startActivity(intent);
                }
            }
        });

        // Chargement de la liste des utilisateurs abonnés
        ArrayList<User> userList = AbonneService.fournirListeUser();
        TableLayout table = (TableLayout) findViewById(R.id.idTable);

        for (int i=0 ; i<userList.size(); i++) {

        }

    }


}
