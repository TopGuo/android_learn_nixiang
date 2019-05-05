package com.example.a13739.l1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    private EditText edit_userName;
    private EditText edit_sn;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.unregister);
        edit_userName = findViewById(R.id.edit_username);
        edit_sn = findViewById(R.id.edit_sn);
        btn_register = findViewById(R.id.button_register);
        btn_register.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                if (!checkSN(edit_userName.getText().toString().trim(),
                        edit_sn.getText().toString().trim())) {
                    Toast.makeText(MainActivity.this,
                            R.string.unsuccessed, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,
                            R.string.successed, Toast.LENGTH_SHORT).show();
                    btn_register.setEnabled(false);
                    setTitle(R.string.registered);
                }
            }
        });
    }

    /*
     * 检验name sn
     * */
    private boolean checkSN(String userName, String sn) {
        try {
            if ((userName == null) || (userName.length() == 0))
                return false;
            if ((sn == null) || (sn.length() != 16))
                return false;
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.reset();
            digest.update(userName.getBytes());
            byte[] bytes = digest.digest();
            String hexstr = toHexString(bytes, "");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hexstr.length(); i += 2) {
                sb.append(hexstr.charAt(i));
            }
            String userSN = sb.toString();
            if (!userSN.equalsIgnoreCase(sn))
                return false;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static String toHexString(byte[] bytes, String separator) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex).append(separator);
        }
        return hexString.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
