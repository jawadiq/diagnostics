package com.dreamlogix.finalinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class displayPr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_pr);
    }
    public void mTouch(View view){
        Intent v = new Intent(this,MultiTouch.class);
        startActivity(v);
    }
    public void sTouch(View view){
        Intent i = new Intent(this,sTouch.class);
        startActivity(i);
    }
    public void clickDp(View view){
        Intent i = new Intent(this,clickDisplay.class);
        startActivity(i);
    }
    public void clickBrighness(View view){
        Intent u = new Intent(this,BrightnessTest.class);
        startActivity(u);
    }
}
