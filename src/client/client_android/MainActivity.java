package client.client_android;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


/*
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<uses-permission android:name="android.permission.INTERNET"/>
*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread t = new Thread(){
            @Override
            public void run(){
                SimpleClient sc = new SimpleClient("192.168.", 15432);
            }
        };
        t.start();

        setContentView(R.layout.activity_main);
    }
}
