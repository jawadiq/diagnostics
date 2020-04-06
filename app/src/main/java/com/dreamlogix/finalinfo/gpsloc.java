package com.dreamlogix.finalinfo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class gpsloc extends AppCompatActivity {

    static final int ID_ACT_CAMERA = 20001;

   private static final int CAMERA_REQUEST = 123;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpsloc);

        issueCameraIntent();
    }

    private void issueCameraIntent() {
        Intent cameraIntent = new Intent
                (MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, ID_ACT_CAMERA);
    }

    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ID_ACT_CAMERA &&
                resultCode == RESULT_OK) {
            Bitmap b = (data.getExtras()).getParcelable("data");

            ImageView iv = (ImageView)findViewById(R.id.iv);
            iv.setImageBitmap(b);
        }
    }
}
