package com.example.leonc.lorgin_register_real;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {
    public SMSReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundles = intent.getExtras();
        SmsMessage[] msgs = null;
        String str = "";
        if(bundles != null){
            Object[]pdus = (Object[]) bundles.get("pdus");
            msgs = new SmsMessage[pdus.length];
            for (int i = 0;i <msgs.length; i++){
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                str += "SMS from " + msgs[i].getOriginatingAddress();
                str += " :";
                str += msgs[i].getMessageBody().toString();
                str += "\n";
            }
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(context, "Hey", Toast.LENGTH_SHORT).show();
    }

}
