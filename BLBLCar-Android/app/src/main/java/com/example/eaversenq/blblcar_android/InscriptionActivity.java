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
        User user;

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
            Toast.makeText(this, "Le Login doit être renseigné", Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((motpasse.getText().length()==0) || (motpasse.getText().equals(null))) {
            Toast.makeText(this, "Le Mot de Passe doit être renseigné", Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((confirmation.getText().length()==0) || (confirmation.getText().equals(null))) {
            Toast.makeText(this, "La Confirmation du Mot de Passe doit être renseignée", Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if (!(confirmation.getText().toString()).equals(motpasse.getText().toString())) {
            Toast.makeText(this, "Le mot de passe et sa confirmation doit être identique", Toast.LENGTH_LONG).show();
        }
        if ((nom.getText().length()==0) || (nom.getText().equals(null))) {
            Toast.makeText(this, "Le nom doit être renseigné", Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((prenom.getText().length()==0) || (prenom.getText().equals(null))) {
            Toast.makeText(this, "Le Prénom doit être renseigné", Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((email.getText().length()==0) || (email.getText().equals(null))) {
            Toast.makeText(this, "L'e.mail doit être renseigné", Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if (!(email.getText().toString().matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ))){
            Toast.makeText(this, "Veuillez saisir une adresse mail valide", Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((adresse.getText().length()==0) || (adresse.getText().equals(null))) {
            Toast.makeText(this, "L'adresse doit être renseignée", Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((codePostal.getText().length()==0) || (codePostal.getText().equals(null))) {
            Toast.makeText(this, "Le code postal doit être renseigné", Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((ville.getText().length()==0) || (ville.getText().equals(null))) {
            Toast.makeText(this, "La ville doit être renseignée", Toast.LENGTH_LONG).show();
            errInscription=true;
        }
        if ((!conducteur.isChecked())&&(!passager.isChecked())){
            Toast.makeText(this, "vous devez cocher passager, conducteur ou les deux", Toast.LENGTH_LONG).show();
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
            Toast.makeText(this, "Echec de l'inscription", Toast.LENGTH_LONG).show();
        } else {
            user=new User(login.toString(), motpasse.toString(), nom.toString(), prenom.toString(), email.toString(),
                    adresse.toString(), codePostal.toString(), ville.toString(), passagerSelectionne, conducteurSelectionne);
            Toast.makeText(this, "Inscription effectuée avec succès", Toast.LENGTH_LONG).show();
        }
    }
}
