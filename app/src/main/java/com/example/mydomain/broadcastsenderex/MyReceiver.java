package com.example.mydomain.broadcastsenderex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {
    private String TAG = MyReceiver.class.getSimpleName();

    public MyReceiver() {
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle results = getResultExtras(true);
        String hierarchy = results.getString("hierarchy");
        results.putString("hierarchy", hierarchy + "->" + TAG);
        Log.d(TAG, "MyReceiver");
    }
}
