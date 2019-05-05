package com.droider.hijackactivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class HijackActivity extends Activity{
	private TextView tv;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hijack);
        
        setTitle("Activity�ٳ�ҳ��");
        
        tv = (TextView) findViewById(R.id.tv_process);
        tv.setTextColor(Color.RED);
        tv.setText("���ٳֵĽ��̣�");
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
        	if(bundle.containsKey("processname")) {
        		String str = bundle.getString("processname");
            	tv.setText("���ٳֵĽ��̣�" + str);
        	}
        } 
    }
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Intent intent = new Intent(HijackActivity.this, Hijacker.class);
        stopService(intent);	//ֹͣ�ٳַ���
    	moveTaskToBack(true);
		return super.onTouchEvent(event);
	}
	
	
}
