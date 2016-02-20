package com.example.eaversenq.blblcar_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eaversenq.blblcar_android.model.User;
import com.example.eaversenq.blblcar_android.service.GeolocalisationService;

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
        boolean errInscription=false;
        boolean conducteurSelectionne=false;
        boolean passagerSelectionne=false;
        User user = new User();
        GeolocalisationService geolocalisation = new GeolocalisationService();

        TextView login = (TextView) findViewById(R.id.identification);
        TextView motpasse = (TextView) findViewById(R.id.motDePasse);
        TextView confirmation = (TextView) findViewById(R.id.confirmation);
        TextView nom = (TextView) findViewById(R.id.nom);
        TextView prenom = (TextView) findViewById(R.id.prenom);
        TextView email = (TextView) findViewById(R.id.email);
        TextView adresse = (TextView) findViewById(R.id.adresse);
        TextView codePostal = (TextView) findViewById(R.id.codePostal);
        TextView ville = (TextView) findViewById(R.id.ville);
        CheckBox passager = (CheckBox) findViewById(R.id.passager);
        CheckBox conducteur = (CheckBox) findViewById(R.id.conducteur);

        if ((login.getText().length()==0) || (login.getText().equals(null))) {
            Toast.makeText(this, R.string.msgLogin, Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((motpasse.getText().length()==0) || (motpasse.getText().equals(null))) {
            Toast.makeText(this, R.string.msgMotDePasse, Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((confirmation.getText().length()==0) || (confirmation.getText().equals(null))) {
            Toast.makeText(this, R.string.msgConfirmationMotDePasse, Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if (!(confirmation.getText().toString()).equals(motpasse.getText().toString())) {
            Toast.makeText(this, R.string.msgPwdEtConfirmation, Toast.LENGTH_LONG).show();
        }
        if ((nom.getText().length()==0) || (nom.getText().equals(null))) {
            Toast.makeText(this, R.string.msgNom, Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((prenom.getText().length()==0) || (prenom.getText().equals(null))) {
            Toast.makeText(this, R.string.msgPrenom, Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((email.getText().length()==0) || (email.getText().equals(null))) {
            Toast.makeText(this, R.string.msgEmail, Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if (!(email.getText().toString().matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ))){
            Toast.makeText(this, R.string.msgMailValide, Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((adresse.getText().length()==0) || (adresse.getText().equals(null))) {
            Toast.makeText(this, R.string.msgAdresse, Toast.LENGTH_LONG).show();
            errInscription=true;
        }
/*        if ((codePostal.getText().length()==0) || (codePostal.getText().equals(null))) {
            Toast.makeText(this, R.string.msgCodePostal, Toast.LENGTH_LONG).show();
            errInscription=true;
        } */
        if ((ville.getText().length()==0) || (ville.getText().equals(null))) {
            Toast.makeText(this, R.string.msgVille, Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((!conducteur.isChecked())&&(!passager.isChecked())){
            Toast.makeText(this, R.string.msgConducteurPassager, Toast.LENGTH_LONG).show();
            errInscription=true;
        }else {
            if (conducteur.isChecked()) {
                 conducteurSelectionne=true;
            }
            if (passager.isChecked()) {
                passagerSelectionne=true;
            }

        }
        if (errInscription==true) {
            Toast.makeText(this, R.string.msgInscriptionEchec, Toast.LENGTH_LONG).show();
        } else {
            geolocalisation.rechercheCoordonnees(adresse.getText().toString(),ville.getText().toString());
            user=new User(login.getText().toString(), motpasse.getText().toString(), nom.getText().toString(), prenom.getText().toString(),
                    email.getText().toString(), adresse.getText().toString(), codePostal.getText().toString(), ville.getText().toString(),
                    passagerSelectionne, conducteurSelectionne, 0.0,geolocalisation.getLatitude(),geolocalisation.getLongitude());


            Toast.makeText(this, R.string.msgInscriptionSucces, Toast.LENGTH_LONG).show();
        }
    }
}
