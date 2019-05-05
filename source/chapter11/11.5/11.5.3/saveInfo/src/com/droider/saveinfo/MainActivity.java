package com.droider.saveinfo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent intent = new Intent();				//����Intent����
        intent.setAction("com.droider.saveinfo");	//Action
        intent.putExtra("username", "droider");		//�û���
        intent.putExtra("password", "123456");		//����
        startService(intent);		//�����������û���������
        sendBroadcast(intent);		//���͹㲥�����û���������
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
