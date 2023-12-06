package com.example.csci4320project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.csci4320project.databinding.AmiTemperatureBinding;

public class Temperature extends AppCompatActivity {

    private double temperatureUnit;

    private AmiTemperatureBinding binding;

    Intent temperatureToWater = new Intent(this, Water.class);
    Intent temperatureToVoltage = new Intent(this, Voltage.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = AmiTemperatureBinding.inflate(getLayoutInflater());
        setContentView(R.layout.ami_temperature);

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(temperatureToVoltage);
            }
        });

        binding.previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(temperatureToWater);
            }
        });
    }
}