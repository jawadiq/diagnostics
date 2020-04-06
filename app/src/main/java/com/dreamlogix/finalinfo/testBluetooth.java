package com.dreamlogix.finalinfo;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class testBluetooth extends AppCompatActivity {
    BluetoothAdapter mBluetoothAdapter;
    TextView r,t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bluetooth);
        r=(TextView)findViewById(R.id.textView12);
        t=(TextView)findViewById(R.id.textView41);
        r.setText("name "+getLocalBluetoothName());
        t.setText("address "+getLocalBluetoothAddress());
    }


    public String getLocalBluetoothName(){
        if(mBluetoothAdapter == null){
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        String name = mBluetoothAdapter.getName();
        if(name == null){
            System.out.println("Name is null!");
        }

        return name;
    }
    public String getLocalBluetoothAddress(){
        if(mBluetoothAdapter == null){
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        String address = mBluetoothAdapter.getAddress();
        if(address == null){
            System.out.println("Address is null!");
        }

        return address;
    }



}

