package com.dreamlogix.finalinfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class heaphone extends AppCompatActivity {
    private MusicIntentReceiver myReceiver;
    TextView s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heaphone);
        s = (TextView) findViewById(R.id.textView14);
        myReceiver = new MusicIntentReceiver();
    }

    @Override
    public void onResume() {
        IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(myReceiver, filter);
        super.onResume();
    }

    private class MusicIntentReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Intent.ACTION_HEADSET_PLUG)) {
                int state = intent.getIntExtra("state", -1);
                switch (state) {
                    case 0:
                        s.setText("Headset is unplugged");
                        break;
                    case 1:
                        s.setText("Headset is plugged");
                        break;
                    default:
                        s.setText("Plugin the headset");
                }
            }
        }
    }
}
