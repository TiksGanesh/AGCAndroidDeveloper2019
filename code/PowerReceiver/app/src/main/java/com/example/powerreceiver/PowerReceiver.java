package com.example.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (null != intent){
            String action = intent.getAction();
            if (Intent.ACTION_POWER_CONNECTED.equals(action)){
                showToas(context, "Connected from power supply");
            }else if (Intent.ACTION_POWER_DISCONNECTED.equals(action)){
                showToas(context, "Disconnected from power supply");
            }
        }
    }

    private void showToas(Context context, String message){
        PowerNotification.notify(context,message,1);



    }
}
