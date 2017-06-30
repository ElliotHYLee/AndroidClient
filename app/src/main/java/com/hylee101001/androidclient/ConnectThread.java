package com.hylee101001.androidclient;

import android.util.Log;
import android.widget.TextView;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by hylee on 6/23/2017.
 */

public class ConnectThread extends Thread {
    String hostName;
    int port;
    TextView tv;

    public ConnectThread(String addr, int port, TextView tv){
        hostName = addr;
        this.port = port;
        Log.d("Client Thread", String.valueOf(port));
        this.tv = tv;
    }

    public void run(){
        try{
            tv.setText("Trying to Connect1");
            Socket sock = new Socket(hostName, port);
            tv.setText("Trying to Connect2");
            ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
            outstream.writeObject("Hello I'm Android");
            outstream.flush();
            tv.setText("Sent");

            ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
            String obj = (String) instream.readObject();

            Log.d("MainActivity", "Server: " + obj);

            sock.close();

        }catch (Exception e){
            //tv.setText("No response");
            e.printStackTrace();
        }
    }

}
