package com.droidyue.avoidforceclosedemo;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

/**
 * Created by androidyue on 11/23/15.
 */
public class DroidUncaughtExceptionHandler  implements  Thread.UncaughtExceptionHandler{
    private static final String LOGTAG = "DroidUncaughtExceptionHandler";
    private Thread.UncaughtExceptionHandler mDefaultExceptionHandler;
    private Context mAppContext;

    public DroidUncaughtExceptionHandler(Context context) {
        mAppContext = context.getApplicationContext();
        mDefaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    public static String getProcessName(Context appContext) {
        String currentProcessName = "";
        int pid = android.os.Process.myPid();
        ActivityManager manager = (ActivityManager) appContext.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.pid == pid) {
                currentProcessName = processInfo.processName;
                break;
            }
        }
        return currentProcessName;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        String processName =  getProcessName(mAppContext);
        if (mAppContext.getPackageName().equals(processName)) {
            Log.i(LOGTAG, "uncaughtException main process");
            mDefaultExceptionHandler.uncaughtException(thread, ex);
        } else {
            Log.i(LOGTAG, "uncaughtException process name=" + processName);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }
}
