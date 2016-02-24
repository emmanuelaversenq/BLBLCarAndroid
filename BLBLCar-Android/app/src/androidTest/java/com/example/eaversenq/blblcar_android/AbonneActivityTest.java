package com.example.eaversenq.blblcar_android;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityTestCase;
import android.widget.EditText;

import junit.framework.Test;
import junit.framework.TestCase;
import com.example.eaversenq.blblcar_android.AbonneActivity;
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
        final EditText nameEditText = (EditText) activity.findViewById(R.id.editArrivée);
        assertEquals("64 rue Jean Rostand, Labege", nameEditText.getText().toString());
    }
}
