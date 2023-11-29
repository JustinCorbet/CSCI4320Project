package com.example.csci4320project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.csci4320project.databinding.LoginPageBinding;

public class Login extends AppCompatActivity {
    private String email;
    private String password;

    private LoginPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = LoginPageBinding.inflate(getLayoutInflater());
        setContentView(R.layout.login_page);

        Intent change = new Intent(this, MainActivity.class);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email == "Jin0" && password == "Jin0") {
                    startActivity(change);
                }
            }
        });
    }
}