package com.droider.checkcrc;

import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView text_info;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("У�鱣����ʾ����");
        text_info = (TextView) findViewById(R.id.textView1);
        if (checkCRC()) {	//�Ա�classes.dex��У���
        	text_info.setTextColor(Color.GREEN);
        	text_info.setText("����������");
        } else {
        	text_info.setTextColor(Color.RED);
        	text_info.setText("�����޸Ĺ���");
        }
    }
    
    private boolean checkCRC() {
    	boolean beModified = false;
    	long crc = Long.parseLong(getString(R.string.crc));
    	ZipFile zf;
		try {
			zf = new ZipFile(getApplicationContext().getPackageCodePath());
	    	ZipEntry ze = zf.getEntry("classes.dex");
	    	Log.d("com.droider.checkcrc", String.valueOf(ze.getCrc()));
	    	if (ze.getCrc() == crc) {
	    		beModified = true;
	    	} 
		} catch (IOException e) {
			e.printStackTrace();
			beModified = false;
		}
		return beModified;
    }    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
