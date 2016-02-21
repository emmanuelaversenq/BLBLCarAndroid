package com.example.eaversenq.blblcar_android;

import com.example.eaversenq.blblcar_android.service.GeolocalisationService;

import junit.framework.TestCase;

/**
 * Created by JFBIRE on 20/02/2016.
 */
public class geolocalisationTest extends TestCase {
    GeolocalisationService geolocal;

    public void rechercheCoordonnées() {
        geolocal = new GeolocalisationService();
        geolocal.rechercheCoordonnees("rue bayard","Toulouse");
        assertEquals(geolocal.getLatitude(), 43.6086616);
        assertEquals(geolocal.getLongitude(),1.4476179000000684);
    }
}
