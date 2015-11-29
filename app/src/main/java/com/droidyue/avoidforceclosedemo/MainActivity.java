package com.droidyue.avoidforceclosedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.causeNPE).setOnClickListener(this);
        findViewById(R.id.startSickService).setOnClickListener(this);
    }



    private void causeNPE() {
        String s = null;
        s.length();
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.causeNPE) {
           causeNPE();
        } else if (viewId == R.id.startSickService) {
            startService(new Intent(MainActivity.this, DroidService.class));
        }
    }
}
