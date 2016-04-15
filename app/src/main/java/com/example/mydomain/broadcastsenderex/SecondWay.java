package com.example.mydomain.broadcastsenderex;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SecondWay extends AppCompatActivity {

    private String TAG = SecondWay.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_way);
        // In MainActivity.onCreate()

        IntentFilter filter = new IntentFilter("com.example.mydomain.broadcastsenderex");
        // filter.setPriority(10); // could do this if you want to

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle results = getResultExtras(true);
                String hierarchy = results.getString("hierarchy");
                results.putString("hierarchy", hierarchy + "->" + TAG);

                Log.d(TAG, "Anonymous class broadcast receiver");
            }
        }, filter);

        Intent intent = new Intent("com.example.mydomain.broadcastsenderex");

        sendOrderedBroadcast(intent, null, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle results = getResultExtras(true);
                String hierarchy = results.getString("hierarchy");
                System.out.println(hierarchy);
                //Toast.makeText(SecondWay.this, hierarchy, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Final Receiver");
            }
        }, null, Activity.RESULT_OK, null, null);

    }
}
