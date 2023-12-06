package com.example.csci4320project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.csci4320project.databinding.HomefunctionSystemBinding;

public class Door extends AppCompatActivity {
    private boolean door;

    private HomefunctionSystemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = HomefunctionSystemBinding.inflate(getLayoutInflater());
        setContentView(R.layout.homefunction_system);

        binding.toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(door == false){
                    door = false;
                } else {
                    door = true;
                }
            }
        });
    }
}
