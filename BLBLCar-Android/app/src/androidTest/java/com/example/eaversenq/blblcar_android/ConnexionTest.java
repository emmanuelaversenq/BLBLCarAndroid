package com.example.eaversenq.blblcar_android;

import com.example.eaversenq.blblcar_android.model.Abonne;
import com.example.eaversenq.blblcar_android.model.Connexion;

import junit.framework.TestCase;



/**
 * Created by CGONZALEZ on 02/03/2016.
 */
public class ConnexionTest extends TestCase{
    Connexion cnx = Connexion.getInstance();


    public void testConnexionInstanceNotNull() {
        assertNotNull(cnx);

    }

}
