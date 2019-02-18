package com.example.helloworld;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private final static String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG,"Debug Message");
        Log.i(LOG_TAG,"Info Message");
        Log.w(LOG_TAG,"Warning Message");
        Log.e(LOG_TAG,"Error Message");
        Log.e(LOG_TAG,"-- onCreate --");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(LOG_TAG,"-- onRestart --");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(LOG_TAG,"-- onStart --");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(LOG_TAG,"-- onResume --");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(LOG_TAG,"-- onPause --");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(LOG_TAG,"-- onStop --");
    }

    @Override
    protected void onDestroy() {
        Log.e(LOG_TAG,"-- onDestroy --");
        super.onDestroy();
    }
}
