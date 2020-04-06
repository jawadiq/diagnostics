package com.dreamlogix.finalinfo;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class viberation extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viberation);
        b1=(Button)findViewById(R.id.but101);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator v1 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v1.vibrate(400);
                Toast.makeText(getApplicationContext(), "Your Vibration Working Very Well",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
