package com.example.toshikazu.resultreceiversample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SomeClass.TestListener mTestListener = new SomeClass.TestListener() {
        @Override
        public void listenerA(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void listenerB(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callMethod(View view) {
        SomeClass some = new SomeClass();
        some.setTestListener(mTestListener);
        some.testMethod(this);
    }
}
