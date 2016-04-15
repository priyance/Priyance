package com.example.mydomain.broadcastsenderex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ThirdWay extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_way);
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("foo");
            Toast.makeText(ThirdWay.this, "Data: Hiee i m: " + message, Toast.LENGTH_SHORT).show();
            Log.d("LocalBroadcastManager", "Hiee i m : " + message);
        }
    };
    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("my-custom-event"));
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        super.onPause();
    }

    public void onBtnLocalBroadcastClick(View view){
        Intent intent = new Intent("my-custom-event");
        intent.putExtra("foo", "priyance");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
