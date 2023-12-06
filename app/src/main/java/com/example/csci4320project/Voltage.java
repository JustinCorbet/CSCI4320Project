package com.example.csci4320project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.csci4320project.databinding.AmiVoltageBinding;

public class Voltage extends AppCompatActivity {

    private double voltageUnit;

    private AmiVoltageBinding binding;

    Intent voltageToTemperature = new Intent(this, Temperature.class);
    Intent voltageToGas = new Intent(this, Gas.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = AmiVoltageBinding.inflate(getLayoutInflater());
        setContentView(R.layout.ami_voltage);

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(voltageToGas);
            }
        });

        binding.previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(voltageToTemperature);
            }
        });
    }
}
