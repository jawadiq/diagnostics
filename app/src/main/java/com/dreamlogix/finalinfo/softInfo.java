package com.dreamlogix.finalinfo;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

public class softInfo extends AppCompatActivity {
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9;
    TextView textView1, textv34;
    String imei;
    String item2;
    String item3;
    int item4,item5;
    static final int PERM_READ_STATE = 123;
    TelephonyManager tm;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft_info);
        tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        int permissioncheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        if (permissioncheck == PackageManager.PERMISSION_GRANTED) {
            //method
            myphone();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, PERM_READ_STATE);
        }


        textView1 = (TextView) findViewById(R.id.textView1);

        t1 = (TextView) findViewById(R.id.textView1a);
        t2 = (TextView) findViewById(R.id.textView2a);
        t3 = (TextView) findViewById(R.id.textView3a);
        t4 = (TextView) findViewById(R.id.textView4a);
        t5 = (TextView) findViewById(R.id.textView5a);
        t6 = (TextView) findViewById(R.id.textView6a);
        t7 = (TextView) findViewById(R.id.textView7a);
        t8 = (TextView) findViewById(R.id.textView8a);
        t9 = (TextView) findViewById(R.id.textView9a);
        textv34 = (TextView) findViewById(R.id.textView34);
        //Telephony


        //Calling the methods of TelephonyManager the returns the information

        int simState = tm.getSimState();
        switch (simState) {
            case TelephonyManager.SIM_STATE_ABSENT:
                textv34.setText("Sim not present");

                break;
            case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
                textv34.setText("SIM Net Locked");
                break;
            case TelephonyManager.SIM_STATE_PIN_REQUIRED:
                textv34.setText("SIM Locked with PIN");
                break;
            case TelephonyManager.SIM_STATE_PUK_REQUIRED:
                textv34.setText("SIM Locked with PUK");
                break;
            case TelephonyManager.SIM_STATE_READY:
                textv34.setText("SIM is working");
                break;
            case TelephonyManager.SIM_STATE_UNKNOWN:
                textv34.setText("SIM status Unknown");
                break;

        }

        String networkCountryISO = tm.getNetworkCountryIso();
        String SIMCountryISO = tm.getSimCountryIso();


        //Get the phone type
        String strphoneType = "";

        int phoneType = tm.getPhoneType();

        switch (phoneType) {
            case (TelephonyManager.PHONE_TYPE_CDMA):
                strphoneType = "CDMA";
                break;
            case (TelephonyManager.PHONE_TYPE_GSM):
                strphoneType = "GSM";
                break;
            case (TelephonyManager.PHONE_TYPE_NONE):
                strphoneType = "NONE";
                break;
        }

        //getting information if phone is in roaming
        boolean isRoaming = tm.isNetworkRoaming();

        String info = "\n";

        info += "\n Network Country ISO:" + networkCountryISO;
        info += "\n SIM Country ISO:" + SIMCountryISO;
        info += "\n Phone Network Type:" + strphoneType;
        info += "\n In Roaming? :" + isRoaming;
        info += "\n Phone IMEI Number:" + imei;
        info += "\n SIM Serial Number:" + item2;
        info += "\n Network Operator:" + item3;
        info += "\n Phone Count:" + item4;


        textView1.setText(info);//displaying the information in the textView
    }

    @Override
    protected void onStart() {
        String release = Build.VERSION.RELEASE;
        int sdkVersion = Build.VERSION.SDK_INT;
        String q = Build.VERSION.CODENAME;
        String t = Build.VERSION.INCREMENTAL;
        String m = Build.BOARD;

        String h = Build.BOOTLOADER;
        String j = Build.BRAND;
        String k = Build.DEVICE;

        String z = Build.HARDWARE;

        String c = Build.MANUFACTURER;
        String b = Build.SERIAL;
        t3.setText("Name of underlying board \n" + m);
        t4.setText("System bootloader version number \n" + h);
        t5.setText("Brand of the software is \n " + j);
        t6.setText("Name of the industrial design \n " + k);
        t7.setText("Name of the ternel \n" + z);
        t8.setText("Manufacturer of the product \n" + c);
        t9.setText("Hardware serial number\n " + b);

        t2.setText("Build no :" + t);
        t1.setText("Android SDK: " + sdkVersion + q + " (" + release + ")");
        super.onStart();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERM_READ_STATE:
                if (grantResults.length >= 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //method
                    myphone();
                } else {
                    Toast.makeText(this, "No permission", Toast.LENGTH_LONG).show();
                }
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void myphone() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        imei = tm.getImei();
        item2 = tm.getSimSerialNumber();
        item3 = tm.getNetworkOperatorName();
        item4 = tm.getPhoneCount();
        item5 = tm.getCallState();


    }

}

