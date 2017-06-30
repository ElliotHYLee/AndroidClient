package com.hylee101001.androidclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnCon;
    EditText etIP, etPort;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIP = (EditText) findViewById(R.id.editText1);
        etPort = (EditText) findViewById(R.id.editText2);
        tv = (TextView) findViewById(R.id.textView);

        btnCon = (Button) findViewById(R.id.btnCon);

        btnCon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String addr = etIP.getText().toString();
                int port = Integer.parseInt(etPort.getText().toString());
                ConnectThread thread = new ConnectThread(addr, port, tv);
                thread.start();
            }
        });
    }

}
