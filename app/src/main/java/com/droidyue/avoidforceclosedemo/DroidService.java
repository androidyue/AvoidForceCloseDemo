package com.droidyue.avoidforceclosedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by androidyue on 11/23/15.
 */
public class DroidService extends Service {

    private static final String LOGTAG = "DroidService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.i(LOGTAG, "onCreate ");
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int result = super.onStartCommand(intent, flags, startId);
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(5000);
                    String s = null;
                    s.length();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return result;
    }
}
