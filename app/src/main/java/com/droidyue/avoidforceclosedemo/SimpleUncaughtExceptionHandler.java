package com.droidyue.avoidforceclosedemo;

import android.util.Log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by androidyue on 11/29/15.
 */
public class SimpleUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final String LOGTAG = "SimpleUncaughtExceptionHandler";

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        ex.printStackTrace(printWriter);
        String errorReport = result.toString();
        Log.i(LOGTAG, "uncaughtException errorReport=" + errorReport);
    }
}
