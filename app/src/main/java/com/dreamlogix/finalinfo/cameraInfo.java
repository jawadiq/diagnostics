package com.dreamlogix.finalinfo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.camera2.params.*;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class cameraInfo extends AppCompatActivity {
    TextView textView,generaal ;
    ProcessBuilder processBuilder;
    String Holder = "";
    String[] DATA = {"/system/bin/cat", "/proc/cpuinfo"};
    InputStream inputStream;
    Process process ;
    byte[] byteArry;
    TextView textMemInfo;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_camera_info);
        generaal = (TextView)findViewById(R.id.generals);
        //general
        generaal.setText(genere);

        //Camera
        CameraManager manager = (CameraManager)
                getSystemService(CAMERA_SERVICE);
        String result = "";
        try {
            for (String cid : manager.getCameraIdList()) {
                CameraCharacteristics cc =
                        manager.getCameraCharacteristics(cid);

                Integer camdir = cc.get
                        (CameraCharacteristics.LENS_FACING);
                if (camdir != null && camdir ==
                        CameraCharacteristics.LENS_FACING_FRONT)
                    result += ("Camera " + cid +
                            ": value=" + camdir + ", facing front\n");
                else
                    result += ("Camera " + cid + ": value=" +
                            camdir + ", not facing front\n");

                Boolean flash = cc.get
                        (CameraCharacteristics.FLASH_INFO_AVAILABLE);
                if (flash != null && flash == true)
                    result += ("Camera " + cid + ": value=" + flash +
                            ", flash available\n");
                else
                    result += ("Camera " + cid + ": value=" + flash +
                            ", flash not available\n");

                List<CameraCharacteristics.Key<?>> keys = cc.getKeys();
                result += ("Camera " + cid + ": " + keys.toString() +
                        "\n\n");
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }


        result = result.replaceAll("\\)", "");
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(result);


        //Memory
        textMemInfo = (TextView) findViewById(R.id.txmeminfo);

        textMemInfo.setText(getMemInfo());

        textView = (TextView)findViewById(R.id.CPUinfo);

        byteArry = new byte[1024];

        try{
            processBuilder = new ProcessBuilder(DATA);

            process = processBuilder.start();

            inputStream = process.getInputStream();

            while(inputStream.read(byteArry) != -1){

                Holder = Holder + new String(byteArry);
            }

            inputStream.close();

        } catch(IOException ex){

            ex.printStackTrace();
        }

        textView.setText(Holder);
    }
    private String getMemInfo() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager =
                (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(memoryInfo);

        Runtime runtime = Runtime.getRuntime();


        String strMemInfo =

                         "Total Memory = " + memoryInfo.totalMem/1024/1024 + "MBs\n"
                                + "Available Memory = " + memoryInfo.availMem/1024/1024 + "MBs\n"// API 16
                        + "\n";

        return strMemInfo;
    }
    String genere = "VERSION.RELEASE : "+Build.VERSION.RELEASE
            +"\nVERSION.INCREMENTAL : "+Build.VERSION.INCREMENTAL
            +"\nVERSION.SDK.NUMBER : "+Build.VERSION.SDK_INT
            +"\nBOARD : "+Build.BOARD
            +"\nBOOTLOADER : "+Build.BOOTLOADER
            +"\nBRAND : "+Build.BRAND
            +"\nCPU_ABI : "+Build.CPU_ABI
            +"\nCPU_ABI2 : "+Build.CPU_ABI2
            +"\nDISPLAY : "+Build.DISPLAY
            +"\nFINGERPRINT : "+Build.FINGERPRINT
            +"\nHARDWARE : "+Build.HARDWARE
            +"\nHOST : "+Build.HOST
            +"\nID : "+Build.ID
            +"\nMANUFACTURER : "+Build.MANUFACTURER
            +"\nMODEL : "+Build.MODEL
            +"\nPRODUCT : "+Build.PRODUCT
            +"\nSERIAL : "+Build.SERIAL
            +"\nTAGS : "+Build.TAGS
            +"\nTIME : "+Build.TIME
            +"\nTYPE : "+Build.TYPE
            +"\nUNKNOWN : "+Build.UNKNOWN
            +"\nUSER : "+Build.USER;


}
