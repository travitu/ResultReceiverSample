package com.example.toshikazu.resultreceiversample;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SomeClass {

    private TestListener mTestListener;

    private CustomResultReceiver mCustomResultReceiver = new CustomResultReceiver(new Handler()) {
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            switch (resultCode) {
                case 1:
                    if (mTestListener != null) {
                        mTestListener.listenerA(resultData.getString("bundleKey1"));
                    }
                    break;
                case 2:
                    if (mTestListener != null) {
                        mTestListener.listenerB(resultData.getString("bundleKey2"));
                    }
                    break;
                default:
                    break;
            }
        }
    };

    public void setTestListener(TestListener testListener) {
        mTestListener = testListener;
    }

    public void testMethod(Context context) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("receiver", mCustomResultReceiver);
        context.startActivity(intent);
    }

    interface TestListener {
        void listenerA(String message);
        void listenerB(String message);
    }
}
