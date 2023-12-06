package com.example.hendrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSpeechText();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                openTextSpeech();
             }
        });
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                openSmartHomeFunctions();
            }
        });
 }
 public void openSmartHomeFunctions() {
     Intent intent = new Intent(this, smartHomeFunctions.class);
     startActivity(intent);
    }
 public void openTextSpeech() {
    Intent intent = new Intent(this, textSpeech.class);
    startActivity(intent);
    }
    public void openSpeechText() {
        Intent intent = new Intent(this, speechText.class);
        startActivity(intent);
    }
}
