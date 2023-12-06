package com.example.csci4320project;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.csci4320project.databinding.HomefunctionSystemBinding;

public class Fan extends AppCompatActivity {
    private boolean fan;

    private HomefunctionSystemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = HomefunctionSystemBinding.inflate(getLayoutInflater());
        setContentView(R.layout.homefunction_system);

        binding.toggleButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fan == false){
                    fan = false;
                } else {
                    fan = true;
                }
            }
        });
    }
}
