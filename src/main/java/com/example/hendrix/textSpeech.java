package com.example.hendrix;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class textSpeech extends AppCompatActivity {
    Button btnClick;
    EditText textEnter;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick = (Button)findViewById(R.id.button);
        textEnter = (EditText)findViewById(R.id.editText);

        textToSpeech = new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status == TextToSpeech.SUCCESS) {
                            int language = textToSpeech.setLanguage(Locale.ENGLISH);
                        }
                    }
                });
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = textEnter.getText().toString();
                int speech = textToSpeech.speak(s, textToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
}