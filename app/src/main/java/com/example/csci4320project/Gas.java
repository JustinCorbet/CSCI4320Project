package com.example.csci4320project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.csci4320project.databinding.AmiGasBinding;
import com.example.csci4320project.databinding.AmiWaterBinding;

public class Gas extends AppCompatActivity {

    private double gasUnit;

    private AmiGasBinding binding;

    Intent gasToVoltage = new Intent(this, Voltage.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = AmiGasBinding.inflate(getLayoutInflater());
        setContentView(R.layout.ami_gas);

        binding.previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(gasToVoltage);
            }
        });
    }
}