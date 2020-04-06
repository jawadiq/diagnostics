package com.dreamlogix.finalinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class siButtons extends AppCompatActivity implements View.OnTouchListener {
    private static final String TAG = "Touch";
    TextView ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_si_buttons);
        FrameLayout main = (FrameLayout) findViewById(R.id.main_view);
        ID = (TextView)findViewById(R.id.textId);

    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_UP) {
                    Toast.makeText(getApplicationContext(), "PRESSED VOLUME UP BUTTON", Toast.LENGTH_SHORT).show();
                    ID.setText("Volume Up button working fine");

                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    Toast.makeText(getApplicationContext(), "PRESSED VOLUME DOWN BUTTON", Toast.LENGTH_SHORT).show(); //TODO
                    ID.setText("Volume Down Button working fine");

                }
                return true;


            default:
                return super.dispatchKeyEvent(event);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}