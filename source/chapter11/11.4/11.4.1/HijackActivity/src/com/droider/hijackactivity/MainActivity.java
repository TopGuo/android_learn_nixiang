package com.droider.hijackactivity;

import java.util.Iterator;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tv;
	private Button btn;
	private EditText txtProcess;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("Activity�ٳ���ʾ����");
        
        tv = (TextView) findViewById(R.id.editInfo);
        tv.setTextColor(Color.BLUE);
        txtProcess = (EditText) findViewById(R.id.editText1);
        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String str = txtProcess.getText().toString().trim();
				if (str == null || str.length() == 0) return;
				((MyApp)getApplication()).hijackingList.add(str);
				setHijackingText();
				txtProcess.setText("");	//��ս��������
			}
		});
        
        setHijackingText();
        
        Intent intent = new Intent(MainActivity.this, Hijacker.class);
        startService(intent);	//�����ٳַ���
    }
    
    private void setHijackingText() {
    	StringBuilder sb = new StringBuilder("�ٳֵĽ����б�\n");
        List<String> list = ((MyApp)getApplication()).hijackingList;
        Iterator<String> strs = list.iterator();
        while (strs.hasNext())
        	sb.append(strs.next() + '\n');	//��ȡ���нٳֵĽ���
        tv.setText(sb.toString());	//��ʾ�ٳֵĽ����б�
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
}
