package com.example.toshikazu.resultreceiversample;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    private ResultReceiver mResultReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        mResultReceiver = intent.getParcelableExtra("receiver");
    }

    public void clickButton(View view) {
        if (mResultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putString("bundleKey1", "resultValue1");
            mResultReceiver.send(1, bundle);
        }
        finish();
    }

    public void clickButton2(View view) {
        if (mResultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putString("bundleKey2", "resultValue2");
            mResultReceiver.send(2, bundle);
        }
        finish();
    }

}
