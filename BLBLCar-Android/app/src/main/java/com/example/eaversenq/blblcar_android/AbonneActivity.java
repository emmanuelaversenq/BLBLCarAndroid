package com.example.eaversenq.blblcar_android;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eaversenq.blblcar_android.model.Abonne;
import com.example.eaversenq.blblcar_android.model.Connexion;
import com.example.eaversenq.blblcar_android.model.User;
import com.example.eaversenq.blblcar_android.model.UserListAll;
import com.example.eaversenq.blblcar_android.service.AbonneService;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AbonneActivity extends Activity {

    private EditText editDepart;
    private EditText editArrivee;
    private EditText editPerimetre;
    private EditText editLogin;
    private EditText editNomPrenom;
//    private EditText editPrenom;
    private EditText editEmail;
    private Button btnRechercher;
    private Button btnPerimetre;
    private TableLayout table;

    private ArrayList<Abonne> userList;
    private static ArrayList<Abonne> userSubList = new ArrayList<Abonne>();
    private UserListAll myList;
    private String strTrairement;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abonne);

        // Handler de communication avec le thread des listes
        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(final Message msg) {
                runOnUiThread(new Runnable() {
                    public void run() {
                        strTrairement = myList.getResultBack();
                        userList = AbonneService.fournirListeAbonne(strTrairement);
                        extractSubList();
                    }
                });
                return false;
            }
        });
        myList = new UserListAll(handler);
        myList.execute();

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
        //editDepart.setText("1 rue des muguets,  31700 Blagnac");
        editDepart.setText(Connexion.getInstance().getAdresse() + " , " + Connexion.getInstance().getVille());

        // editArrivee = (EditText) findViewById(R.id.editArrivee);
        editArrivee = (EditText) findViewById(R.id.editArrivée);
        //editPerimetre =(EditText)
        editPerimetre =(EditText) findViewById(R.id.editPerimetre);

        editLogin =(EditText)findViewById(R.id.editIdentification);
        editLogin.setText(Connexion.getInstance().getLogin());

        editNomPrenom = (EditText)findViewById(R.id.editNom);
        editNomPrenom.setText(Connexion.getInstance().getNom()+ " " +Connexion.getInstance().getPrenom() );


        editEmail= (EditText)findViewById(R.id.editEMail);
        editEmail.setText(Connexion.getInstance().getEmail());


//        editEmail= (EditText)findViewById(R.id.editEmail);
        btnPerimetre = (Button) findViewById(R.id.btnValidePerimetre);
        btnRechercher = (Button) findViewById(R.id.btnSearch);
        table = (TableLayout)findViewById(R.id.idTable);

        btnPerimetre.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                extractSubList();
            }
        });

        btnRechercher.setOnClickListener(new OnClickListener() {
            /**
             * {@inheritDoc}
             */
            @Override
            public void onClick(final View v) {
                if("".equals(editDepart.getText().toString().trim())) {
                    Toast.makeText(AbonneActivity.this, R.string.msgDepart, Toast.LENGTH_SHORT).show();
                }
                else if("".equals(editArrivee.getText().toString().trim())) {
                    Toast.makeText(AbonneActivity.this, R.string.msgArrive, Toast.LENGTH_SHORT).show();
                }
                else {
                    //On transmet les données à l'activité suivante
                    final Intent intent = new Intent(AbonneActivity.this, MapsActivity.class);
                    intent.putExtra("DEPART", editDepart.getText().toString().trim());
                    intent.putExtra("ARRIVEE", editArrivee.getText().toString().trim());
                    intent.putExtra("PERIMETRE",editPerimetre.getText().toString().trim());
                    AbonneActivity.this.startActivity(intent);
                }
            }
        });
    }

    /*
     * Extrait la liste des abonnés filtrés par rapport au périmètre
     */
    private void extractSubList() {

        double radius = Double.parseDouble(editPerimetre.getText().toString());
        userSubList.clear();
        for (int i = 0 ; i < userList.size(); i++) {
            if (userList.get(i).getDistance() <= radius) {
                userSubList.add(userList.get(i));
            }
        }
        displayTableAbonne();
    }

    /*
     * Affiche la liste des abonnés
     */
    private void displayTableAbonne() {
        TableRow row;
        TextView tvPrenom;
        TextView tvNom;
        TextView tvMail;
        TextView tvDistance;

        // On vide la table
        table.removeAllViews();

        // En-têtes de colonnes
        row = new TableRow(this);
        tvPrenom = formatCell(getString(R.string.prenom), true);
        tvNom = formatCell(getString(R.string.nom), true);
        tvMail = formatCell(getString(R.string.email), true);
        tvDistance = formatCell(getString(R.string.distance), true);
        row.addView(tvPrenom);
        row.addView(tvNom);
        row.addView(tvMail);
        row.addView(tvDistance);
        table.addView(row);

        // Corps de la liste
        for (int i = 0 ; i < userSubList.size(); i++) {

            row = new TableRow(this);
            tvPrenom = formatCell(userSubList.get(i).getPrenom(), (i % 2 == 1));
            tvNom = formatCell(userSubList.get(i).getNom(), (i % 2 == 1));
            tvMail = formatCell(userSubList.get(i).getEmail(), (i % 2 == 1));
            tvMail.setTextSize(10);

            //Formataoge distance à 3 points avec virgule
            DecimalFormat f= new DecimalFormat();
            f.setMinimumFractionDigits(2);


            tvDistance= formatCell(String.valueOf(f.format(userSubList.get(i).getDistance())),(i%2 ==1));


            row.addView(tvPrenom);
            row.addView(tvNom);
            row.addView(tvMail);
            row.addView(tvDistance);
            table.addView(row);
        }
    }

    private TextView formatCell(String title, boolean isShadow) {
        TextView result;
        result = new TextView(this);
        result.setText(title);
        result.setGravity(Gravity.LEFT);
        result.setLayoutParams(new TableRow.LayoutParams(0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        if (isShadow) result.setBackgroundColor(Color.rgb(221, 238, 255));
        return result;
    }


    public static ArrayList<Abonne> getUserSubList() {
        return userSubList;
    }
}
