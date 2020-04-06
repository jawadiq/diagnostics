package com.dreamlogix.finalinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class hardInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_info);
    }

    public void toDisplay(View view){
        Intent k = new Intent(this,displayPr.class);
        startActivity(k);
    }
    public void toSensors(View view){
        Intent p = new Intent(this,toSensors.class);
        startActivity(p);
    }

    public void toDevices(View view){
        Intent px = new Intent(this,periphrals.class);
        startActivity(px);
    }
    public void toGPS(View view){
        Intent xy = new Intent(this,gpsloc.class);
        startActivity(xy);
    }
    public void toBattery(View view){
        Intent xyh = new Intent(this,testBattery.class);
        startActivity(xyh);
    }
    public void toComs(View view){
        Intent lmg = new Intent(this,testComs.class);
        startActivity(lmg);
    }
}
