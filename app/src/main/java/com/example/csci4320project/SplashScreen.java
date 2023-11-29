package com.example.csci4320project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    private long splashDelay = 3000;

    //Handler mDelayHandler = new Handler();

    Intent change = new Intent(this, MainActivity.class);

   /*
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            finish();
            startActivity(change);
        }
    };


    */

    public void splashToMain(){
        Intent changes = new Intent(this, MainActivity.class);
        finish();
        startActivity(change);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        splashToMain();
        // mDelayHandler.postDelayed(runnable, splashDelay);
    }

    /*
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mDelayHandler != null) {
            mDelayHandler.removeCallbacks(runnable);
        }
    }

     */
}
