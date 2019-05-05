package com.droider.checksignature;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView text_info;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("ǩ�������ʾ����");
        text_info = (TextView) findViewById(R.id.textView1);
        int sig = getSignature("com.droider.checksignature");
        if (sig != 2071749217) {
        	text_info.setTextColor(Color.RED);
        	text_info.setText("��⵽����ǩ����һ�£��ó������´������");
        } else {
        	text_info.setTextColor(Color.GREEN);
        	text_info.setText("�ó���û�б����´������");
        }
    }

	public int getSignature(String packageName) {      
		PackageManager pm = this.getPackageManager();
		PackageInfo pi = null;
		int sig = 0;
		try {
			pi = pm.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
			Signature[] s = pi.signatures;
			sig = s[0].hashCode();  
		} catch (Exception e1) {
			sig = 0;
			e1.printStackTrace();
		}
		return sig;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
