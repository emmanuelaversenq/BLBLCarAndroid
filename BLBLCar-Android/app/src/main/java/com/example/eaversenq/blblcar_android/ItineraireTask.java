package com.example.eaversenq.blblcar_android;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import static com.google.android.gms.maps.model.BitmapDescriptorFactory.*;

/**
 * Created by CGONZALEZ on 10/02/2016.
 */
public class ItineraireTask extends AsyncTask<Void, Integer, Boolean> {
    /*******************************************************/
    /**
     * CONSTANTES.
     * /
     *******************************************************/
    private static final String TOAST_MSG = "Calcul de l'itinéraire en cours";
    private static final String TOAST_ERR_MAJ = "Impossible de trouver un itinéraire";

    /*******************************************************/
    /**
     * ATTRIBUTS.
     * /
     *******************************************************/
    private Context context;
    private GoogleMap gMap;
    private String editDepart;
    private String editArrivee;
    private String editPerimetre;
    private final ArrayList<LatLng> lstLatLng = new ArrayList<LatLng>();
    private final ArrayList<LatLng> tableauMarqueurs = new ArrayList<LatLng>();



    /*******************************************************/
    /** METHODES / FONCTIONS.
     /*******************************************************/
    /**
     * Constructeur.
     *
     * @param context
     * @param gMap
     * @param editDepart
     * @param editArrivee
     * @param editPerimetre

     */
    public ItineraireTask(final Context context, final GoogleMap gMap, final String editDepart, final String editArrivee, final String editPerimetre) {
        this.context = context;
        this.gMap = gMap;
        this.editDepart = editDepart;
        this.editArrivee = editArrivee;
        this.editPerimetre = editPerimetre ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onPreExecute() {
        Toast.makeText(context, TOAST_MSG, Toast.LENGTH_LONG).show();
    }

    /***
     * {@inheritDoc}
     */
    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            //Construction de l'url à appeler
            final StringBuilder url = new StringBuilder("http://maps.googleapis.com/maps/api/directions/xml?sensor=false&language=fr");
            url.append("&origin=");
            url.append(editDepart.replace(' ', '+'));
            url.append("&destination=");
            url.append(editArrivee.replace(' ', '+'));
          //  double editPerimetre = this.editPerimetre;
           // url.append(editPerimetre);

            //Appel du web service
            final InputStream stream = new URL(url.toString()).openStream();

            //Traitement des données
            final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setIgnoringComments(true);

            final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            final Document document = documentBuilder.parse(stream);
            document.getDocumentElement().normalize();

            //On récupère d'abord le status de la requête
            final String status = document.getElementsByTagName("status").item(0).getTextContent();
            if (!"OK".equals(status)) {
                return false;
            }

            //On récupère les steps
            final Element elementLeg = (Element) document.getElementsByTagName("leg").item(0);
            final NodeList nodeListStep = elementLeg.getElementsByTagName("step");
            final int length = nodeListStep.getLength();

            for (int i = 0; i < length; i++) {
                final Node nodeStep = nodeListStep.item(i);

                if (nodeStep.getNodeType() == Node.ELEMENT_NODE) {
                    final Element elementStep = (Element) nodeStep;

                    //On décode les points du XML
                    decodePolylines(elementStep.getElementsByTagName("points").item(0).getTextContent());
                }
            }

            return true;
        } catch (final Exception e) {
            return false;
        }
    }

    /**
     * Méthode qui décode les points en latitudes et longitudes
     * //* @param points
     */

    private void decodePolylines(final String encodedPoints) {
        int index = 0;
        int lat = 0, lng = 0;

        while (index < encodedPoints.length()) {
            int b, shift = 0, result = 0;

            do {
                b = encodedPoints.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);

            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;
            shift = 0;
            result = 0;

            do {
                b = encodedPoints.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);

            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            lstLatLng.add(new LatLng((double) lat / 1E5, (double) lng / 1E5));
        }
    }

    public void intialisationTableauMarqueursUser(){
        //  On inititalise un tableau de markers avec latitude/longitude des utilisateurs présents dans le périmètre
        // = sublist de AbonneActivity
        int lat = 0, lng = 0;
        for(int i = 0; i< AbonneActivity.getUserSubList().size();i++){
            tableauMarqueurs.add(new LatLng((double) lat/AbonneActivity.getUserSubList().get(i).getLatitude(), lng/ AbonneActivity.getUserSubList().get(i).getLongitude()));
            Log.i("intialisationTableau: ", " result : " + tableauMarqueurs.get(i));
        }
    }
/* public void ajouteMarqueur( LatLng latlng ) {
        Long latitude = latlng.lat;
        Long longitude = latlng.lng;
        final  MarkerOptions marqueurs = {
                map: gMap,
                marqueurs.position: new google.maps.LatLng( latitude, longitude )
        };
        Long marqueur = new google.maps.Marker( MarkerOptions );
        zoneMarqueurs.extend( marqueur.getPosition() );
    }; */





    /**
     * {@inheritDoc}
     */
    @Override
    protected void onPostExecute(final Boolean result) {
        intialisationTableauMarqueursUser();
        if (!result) {
            Toast.makeText(context, TOAST_ERR_MAJ, Toast.LENGTH_SHORT).show();
        } else {
            //On déclare le polyline, c'est-à-dire le trait (ici bleu) que l'on ajoute sur la carte pour tracer l'itinéraire
            final PolylineOptions polylines = new PolylineOptions();
            polylines.color(Color.BLUE);

            //On construit le polyline
            for (final LatLng latLng : lstLatLng) {
                polylines.add(latLng);
            }

            //On déclare un marker vert que l'on placera sur le départ
            final MarkerOptions markerA = new MarkerOptions();
            markerA.position(lstLatLng.get(0));
            markerA.icon(defaultMarker(HUE_GREEN));

            //On déclare un marker rouge que l'on mettra sur l'arrivée
            final MarkerOptions markerB = new MarkerOptions()
                    .title("Berger-Levrault")
                    .icon(fromResource(R.drawable.bl))
                    .snippet("Mon lieu de travail");


            markerB.position(lstLatLng.get(lstLatLng.size() - 1));
            // markerB.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

            //On met à jour la carte
            gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lstLatLng.get(0), 10));
            gMap.addMarker(markerA);
            gMap.addPolyline(polylines);
            gMap.addMarker(markerB);

            // ajout marqueurs
            for (int i =0; i< tableauMarqueurs.size();i++){
                LatLng ll = new LatLng(tableauMarqueurs.get(i).latitude, tableauMarqueurs.get(i).longitude);
                double lat = tableauMarqueurs.get(i).latitude ;
                double longi = tableauMarqueurs.get(i).longitude;

                gMap.addMarker(new MarkerOptions()
                                .position(new LatLng(lat, longi))
                                .icon(defaultMarker(HUE_BLUE))
                );


            }
            final Circle circle = gMap.addCircle(new CircleOptions()
                    .center(lstLatLng.get(0))
                    .radius(Double.parseDouble(editPerimetre)*1000)// en mètres => km
                    .strokeWidth(5).strokeColor(Color.RED));
        }

    }
}
