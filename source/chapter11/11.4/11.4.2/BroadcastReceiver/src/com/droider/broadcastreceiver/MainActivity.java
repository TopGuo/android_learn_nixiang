package com.droider.broadcastreceiver;

import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button btn1;
	private Button btn2;
	private TextView tv;
	private boolean working = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("�����㲥�����߳���");
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				working = true;
				work();	//��ʼ���㲥
				btn1.setEnabled(false);
				btn2.setEnabled(true);
			}
		});
        
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				working = false;		//ֹͣ�߳�
				btn1.setEnabled(true);
				btn2.setEnabled(false);
			}
		});
    }

    private void work(){
		new Thread(){
			@Override
			public void run() {
				while(working) {	//ѭ������
					Log.d("com.droider.broadcastreceiver", "���͹㲥");
			        Intent intent = new Intent();//����Intent����
			        intent.setAction("com.droider.workbroadcast");
			        //intent.setClass(MainActivity.this, DataReceiver.class);	//��ȷָ��Ҫ���͵�Ŀ�ĵ�
			        intent.putExtra("data", Math.random());	//ʹ�����ֵģ���̨�������
			        sendBroadcast(intent);	//���͹㲥
					try {
		                Thread.sleep(5000);	//˯��3��
			        } catch(Exception e){
			        	e.printStackTrace();
			        }
				}
				Log.d("com.droider.broadcastreceiver", "�㲥ֹͣ");
			}
		}.start();
	}    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
