package com.droider.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class DataReceiver extends BroadcastReceiver{
	@Override
    public void onReceive(Context context, Intent intent) {//��дonReceive����
    	Log.d("com.droider.broadcastreceiver", "�յ��㲥");
        double data = intent.getDoubleExtra("data", 0);
        Toast.makeText(context, "�յ�������:" + data, Toast.LENGTH_SHORT).show();                        
    }
}
