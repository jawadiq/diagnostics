package com.dreamlogix.finalinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class sTouch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SingleTouchEventView(this, null));
    }
}
