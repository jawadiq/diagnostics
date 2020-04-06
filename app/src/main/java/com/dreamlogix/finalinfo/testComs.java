package com.dreamlogix.finalinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class testComs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_coms);
    }

    public void testWifi(View view) {
        Intent abc = new Intent(this,testWifi.class);
        startActivity(abc);
    }

    public void toBlueTooth(View view) {
        Intent gg = new Intent(this,testBluetooth.class);
        startActivity(gg);
    }
}
