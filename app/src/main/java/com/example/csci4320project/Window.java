package com.example.csci4320project;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.csci4320project.databinding.HomefunctionSystemBinding;

public class Window extends AppCompatActivity {
    private boolean window;

    private HomefunctionSystemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = HomefunctionSystemBinding.inflate(getLayoutInflater());
        setContentView(R.layout.homefunction_system);

        binding.toggleButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(window == false){
                    window = false;
                } else {
                    window = true;
                }
            }
        });
    }
}
