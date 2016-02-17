package com.example.eaversenq.blblcar_android;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import static com.example.eaversenq.blblcar_android.R.layout.activity_maps;
/**
 * Created by CGONZALEZ on 10/02/2016.
 */
public class MapsActivity extends Activity{
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
       /* SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);*/
        //On récupère les composants graphiques
        mMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();

        //On récupère le départ et l'arrivée, et le périmètre
        final String editDepart = getIntent().getStringExtra("DEPART");
        final String editArrivee = getIntent().getStringExtra("ARRIVEE");
        final Double editPerimetre = getIntent().getDoubleExtra("PERIMETRE",5000);


        //Appel de la méthode asynchrone
        new ItineraireTask(this, mMap, editDepart, editArrivee, editPerimetre).execute();

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


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
   /* @Override */
    /* public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng BL = new LatLng(43.5432517 ,1.5122082999999975);
        mMap.addMarker(new MarkerOptions().position(BL).title("Marker in Berger-Levrault"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(BL));
    }*/


}
