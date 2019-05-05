package com.droider.ndkapp;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn1;
	private static String workString;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String str1 = "NDK������������֤��ʾ����";
        String str2;
        int m = ((MyApp)getApplication()).m;
        if (m == 0) {
        	str2 = "-δע��";
		} else if (m == 1) {
			str2 = "-��ʽ��";
		} else if (m == 2) {
			str2 = "-רҵ��";
		} else if (m == 3) {
			str2 = "-��ҵ��";
		} else if (m == 4) {
			str2 = "-ר����";
		} else {
			str2 = "-δ֪��";
		}
        setTitle(str1 + str2);	//���ñ���
        
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int m = ((MyApp)getApplication()).m;
				if (m == 0 ) {					
					doRegister();	//��ʾע��
				} else {
					((MyApp)getApplication()).work();	//����NDK����ִ�к������ܣ��ڼ�����ע����
					Toast.makeText(getApplicationContext(), workString, Toast.LENGTH_SHORT).show();
				}
			}
		});
        
    }
    
    public void doRegister() {
    	new AlertDialog.Builder(MainActivity.this)
	        .setTitle("����δע��")
	        .setMessage("����ȷ��ע�᱾������ߵ��ȡ���˳�����")
	        .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent();
					ComponentName cpname = new ComponentName("com.droider.ndkapp", 
						"com.droider.ndkapp.RegActivity");
					intent.setComponent(cpname);
					startActivity(intent);
					MainActivity.this.finish();
				}
			}).setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					android.os.Process.killProcess(android.os.Process.myPid());							
				}
			}).show();
    }
    
    public void work(String str) {
    	workString = str;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
