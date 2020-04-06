package com.dreamlogix.finalinfo;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.security.KeyStore;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class fingerPrint extends AppCompatActivity {
    private static final String KEY_NAME = "yourKey";
    private Cipher cipher;
    private KeyStore keyStore;
    private KeyGenerator keyGenerator;
    private TextView textView, showf;
    private FingerprintManager.CryptoObject cryptoObject;
    private FingerprintManager fingerprintManager;
    private KeyguardManager keyguardManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {





            keyguardManager =
                        (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    fingerprintManager =
                            (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
                }


                showf = (TextView) findViewById(R.id.displayresult);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (!fingerprintManager.isHardwareDetected()) {

                        showf.setText("Sorry! Your Phone does not support Finger print hardware");


                    }
                }


                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.USE_FINGERPRINT) == PackageManager.PERMISSION_GRANTED) {
                    String sensor = Build.FINGERPRINT;
                    showf.setText("Finger print hardware present" + "\n\n\n" + "Hardware Details" + "\n\n" + sensor);

                } else {

                    showf.setText("Your Device is not Finger Print compatible");

                }



            }


        }

    }
