package com.droidyue.avoidforceclosedemo;

import android.app.Application;
import android.util.Log;

/**
 * Created by androidyue on 11/23/15.
 */
public class DroidApplication extends Application {
    private static final String LOGTAG = "DroidApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(LOGTAG, "onCreate");
        Thread.setDefaultUncaughtExceptionHandler(new DroidUncaughtExceptionHandler(this));
    }
}
