package com.droider.stealbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class DataReceiver extends BroadcastReceiver{
	@Override
    public void onReceive(Context context, Intent intent) {//��дonReceive����
    	Log.d("com.droider.broadcastreceiver", "͵�Ե��㲥");
        double data = intent.getDoubleExtra("data", 0);
        Toast.makeText(context, "͵�Ե�������:" + data, Toast.LENGTH_SHORT).show();
    }  
}
