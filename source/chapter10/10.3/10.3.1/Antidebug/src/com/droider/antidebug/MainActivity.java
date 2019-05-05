package com.droider.antidebug;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("��������ʾ����");
        if ((getApplicationInfo().flags &= 
        		ApplicationInfo.FLAG_DEBUGGABLE) != 0){
        	Log.e("com.droider.antidebug", "�����޸�Ϊ�ɵ���״̬");
        	android.os.Process.killProcess(android.os.Process.myPid());
        }  
        if (android.os.Debug.isDebuggerConnected()) {	//��������
        	Log.e("com.droider.antidebug", "��⵽������");
        	android.os.Process.killProcess(android.os.Process.myPid());
        }       
    }   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
