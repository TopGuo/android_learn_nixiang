package com.droider.evildownloader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btn1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("��ı������ʾ����");
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();			//����Intent����
		        intent.setAction("com.droider.download");
		        intent.putExtra("url", 
		        		"http://developer.android.com/images/home/android-jellybean.png");			//Ҫ���ص��ļ�URL
		        String fileName = "jb.png";		//������ļ���
		        intent.putExtra("filename", fileName);
		        sendBroadcast(intent);	//���͹㲥
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
