package com.dreamlogix.finalinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void toHardware(View view){
    Intent x = new Intent(this,hardInfo.class);
    startActivity(x);
}

   public void toSoftInfo(View view){
        Intent pj = new Intent(this,softInfo.class);
        startActivity(pj);
    }

    public void toCaminfo(View view) {
        Intent wer = new Intent(this,cameraInfo.class);
        startActivity(wer);
    }
    public void web(View view) {
        Intent wers = new Intent(this,webstor.class);
        startActivity(wers);
    }
    public void toFingerPrint(View view) {
        Intent wers = new Intent(this,fingerPrint.class);
        startActivity(wers);
    }
}
