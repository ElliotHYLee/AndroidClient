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
        Log.d("Client", "To IP:" + hostName + "\nPort: " + port);
        this.tv = tv;
    }

    public void run(){
        try{
            //tv.setText("Trying to Connect1");
            Log.d("Client", "Trying to connect1");
            Log.d("Client", "Client: connectting to " + hostName+":" + String.valueOf(port));
            Socket sock = new Socket(hostName, port);
            Log.d("Client", "Connection Established");
            ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
            outstream.writeObject("Client: Hello I'm Android");
            Log.d("Client", "Client: Hello I'm Android");
            outstream.flush();
            ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
            String obj = (String) instream.readObject();
            Log.d("Client", "Server: " + obj);
            sock.close();
            Log.d("Client", "Socket closed");

        }catch (Exception e){
            //tv.setText("No response");
            Log.d("Client", "error ");
            e.printStackTrace();
        }
    }

}
