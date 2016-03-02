package com.example.eaversenq.blblcar_android;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityTestCase;
import android.widget.EditText;
import android.widget.TextView;

import junit.framework.Test;
import junit.framework.TestCase;
import com.example.eaversenq.blblcar_android.AbonneActivity;
import com.example.eaversenq.blblcar_android.model.Connexion;

/**
 * Created by CGONZALEZ on 24/02/2016.
 */
public class AbonneActivityTest extends TestCase{

AbonneActivity activity ;



  /*  public AbonneActivityTest(Class<AbonneActivity> activityClass) {
        super(activityClass);
    }*/
    public String TestCase(){return "";};

    
    public void testCheckEditTextDefaut() {

        String result = Connexion.getInstance().getAdresse() + " , " + Connexion.getInstance().getVille();
        assertEquals("1 rue des muguets , Blagnac", result);
    }
}
