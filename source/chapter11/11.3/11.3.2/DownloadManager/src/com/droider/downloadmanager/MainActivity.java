package com.droider.downloadmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText edit1;
	private Button btn1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("�ļ����ع�����ʾ����");
        edit1 = (EditText) findViewById(R.id.editText1);
        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String url = edit1.getText().toString().trim();
				if (url == null || url.length() == 0) return;
				Intent intent = new Intent();			//����Intent����
		        intent.setAction("com.droider.download");
		        intent.putExtra("url", url);			//Ҫ���ص��ļ�URL
		        String fileName = url.substring(url.lastIndexOf("/") + 1);
		        Log.d("com.droider.download", fileName);
		        if (fileName == null | fileName.length() == 0) fileName = "file.dat";
		        intent.putExtra("filename", fileName);	//������ļ���
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
