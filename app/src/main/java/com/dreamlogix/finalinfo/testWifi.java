package com.dreamlogix.finalinfo;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class testWifi extends AppCompatActivity {
    TextView t,u,v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_wifi);
        t=(TextView)findViewById(R.id.textView32);

        v=(TextView)findViewById(R.id.textView30);
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo wInfo = wifiManager.getConnectionInfo();
        String macAddress = wInfo.getMacAddress();
        int ip = wInfo.getIpAddress();
        String bssid = wInfo.getBSSID();
        String n= wInfo.LINK_SPEED_UNITS;
        int speed = wInfo.getLinkSpeed();
        int netwrk = wInfo.getNetworkId();
        String Iadress = Formatter.formatIpAddress(ip);
        String y=wInfo.getSSID();
        if (macAddress == null)
        {
            macAddress = "Device don't have mac address or wi-fi is disabled";
        }
        t.setText("Mac address "+macAddress);

        v.setText("SSID: "+y +"\n" + "BSSID:" +bssid+"\n"+ "Speed Unit:" +n +"\n"+"IP Adress:" + ip
        +"\n" +"Link Speed:" + speed +"\n"+ "Network ID:" + netwrk+ "\n" +"IP ADRESS:" +Iadress);

    }


}
