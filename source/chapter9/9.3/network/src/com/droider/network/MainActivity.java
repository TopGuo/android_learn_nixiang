package com.droider.network;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Button btn_work;
	private TextView txt_info;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("������֤��ʾ����");        
        
        btn_work = (Button) findViewById(R.id.button1);
    	txt_info = (TextView) findViewById(R.id.text_info);
    	
    	btn_work.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (!CheckNetworkState()) {
		        	txt_info.setTextColor(Color.RED);
		        	txt_info.setText("�ù���ֻ��������״̬��ʹ�ã�");
		        } else {
		            getData();
		        }				
			}
		});
    }
    
	private void getData() {
		String result = HttpUtils.getStringFromURL("http://com-droider-network.googlecode.com/svn/info.txt");
        if (result == null || result.length() == 0) {	//��������������
        	txt_info.setTextColor(Color.RED);
        	txt_info.setText("��ȡ�������ݳ���");
        } else {
        	MSGInfo info = JSONUtils.getInfoFromString(result);	//����JSON��ʽ������
        	try {
				String str = Crypt.decrypt(info.getDecryptKey(), info.getMsg());	//���ܴ������ȡ������
	        	txt_info.setTextColor(Color.GREEN);
	        	txt_info.setText(str);	//��ʾ���ܵ�����
			} catch (Exception e) {
			}
        }
    }
    
    /**
     * �������״̬
     * @return
     */
    private boolean CheckNetworkState() {
        boolean flag = false;
        ConnectivityManager manager = (ConnectivityManager)getSystemService(
                Context.CONNECTIVITY_SERVICE);
        if(manager.getActiveNetworkInfo() != null) {
            flag = manager.getActiveNetworkInfo().isAvailable();
        }
        return flag;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
