package com.example.khawlasal7.phone_state;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.textView1);

        //Get the instance of TelephonyManager
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        String line1Number = tm.getLine1Number();
        String IMEINumber = tm.getImei();
        int callState=tm.getCallState();
        int simState=tm.getSimState();
        String Type = "";

        //Get the phone type


        int phoneType=tm.getPhoneType();

        switch (phoneType)
        {
            case (TelephonyManager.PHONE_TYPE_CDMA):
                Type="CDMA";
                break;
            case (TelephonyManager.PHONE_TYPE_GSM):
                Type="GSM";
                break;
            case (TelephonyManager.PHONE_TYPE_NONE):
                Type="NONE";
                break;
        }


        String info="Phone Details:\n";
        info+="\n Phone Type :"+Type;
        info+="\n IMEI Number:"+IMEINumber;
        info+="\n Line number :"+line1Number;
        info+="\n SIM State"+simState;
        info+="\n Call State:"+callState;



        textView1.setText(info);//displaying the information in the textView
    }


}