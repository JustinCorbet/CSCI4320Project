package com.example.csci4320project;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.csci4320project.databinding.HomefunctionSystemBinding;

public class Alarm extends AppCompatActivity {
    private boolean alarm;

    private HomefunctionSystemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = HomefunctionSystemBinding.inflate(getLayoutInflater());
        setContentView(R.layout.homefunction_system);

        binding.toggleButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(alarm == false){
                    alarm = false;
                } else {
                    alarm = true;
                }
            }
        });
    }
}
