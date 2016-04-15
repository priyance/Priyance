package com.example.mydomain.broadcastsenderex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MySecondReceiver extends BroadcastReceiver {
    private String TAG = MySecondReceiver.class.getSimpleName();
    public MySecondReceiver() {
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle results = getResultExtras(true);
        results.putString("hierarchy", TAG);
        Log.d(TAG, "MySecondReceiver");
    }
}
