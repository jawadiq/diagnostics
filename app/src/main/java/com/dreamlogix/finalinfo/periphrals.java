package com.dreamlogix.finalinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class periphrals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periphrals);
    }
    public void toVibrate(View view){
        Intent px = new Intent(this,viberation.class);
        startActivity(px);
    }
    public void toHeadphone(View view){
        Intent pxq = new Intent(this,heaphone.class);
        startActivity(pxq);
    }
       public void toBtnss(View view) {
        Intent lms = new Intent(this,siButtons.class);
        startActivity(lms);
    }
    public void toMic(View view) {
        Intent vxq = new Intent(this,micTest.class);
        startActivity(vxq);
    }

    public void toMicrophone(View view) {
        Intent mic = new Intent(this,testMicphone.class);
        startActivity(mic);
    }
}
