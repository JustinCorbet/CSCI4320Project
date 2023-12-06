package com.example.csci4320project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;

import com.example.csci4320project.databinding.SplashScreenBinding;

public class SplashScreen extends AppCompatActivity {

    private SplashScreenBinding binding;
    private long splashDelay = 3000;

    Handler mDelayHandler = new Handler();

    Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            finish();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        mDelayHandler.postDelayed(mRunnable, splashDelay);
        Intent splashToLogin = new Intent(this, Login.class);
    }
}
