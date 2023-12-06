package com.example.csci4320project;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.csci4320project.databinding.AmiWaterBinding;

public class Water extends AppCompatActivity {

    private double waterUnit;

    private AmiWaterBinding binding;

    Intent waterToTemperature = new Intent(this, Temperature.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = AmiWaterBinding.inflate(getLayoutInflater());
        setContentView(R.layout.ami_water);

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(waterToTemperature);
            }
        });
    }
}