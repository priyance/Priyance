package com.example.mydomain.broadcastsenderex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BroadCast App");
    }
    public void onBtnSendBroadcastClick(View view){
        Intent intent=new Intent("com.example.mydomain.broadcastsenderex");
        //Android 3.0
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        this.sendBroadcast(intent);
    }
}
