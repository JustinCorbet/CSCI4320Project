package com.example.csci4320project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.csci4320project.databinding.LoginPageBinding;

public class Login extends AppCompatActivity{
    private String email;
    private String password;

    private LoginPageBinding binding;

    Intent loginToMain = new Intent(this, MainActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = LoginPageBinding.inflate(getLayoutInflater());
        setContentView(R.layout.login_page);

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.equals("Jin0") && password.equals("Jin0")) {
                    startActivity(loginToMain);
                }
            }
        });
    }
}