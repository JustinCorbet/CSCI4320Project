package com.example.hendrix;

import static com.example.hendrix.Functions.wishMe;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.DexterBuilder;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class speechText extends AppCompatActivity {
    private SpeechRecognizer recognizer;
    private TextView textView;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dexter.withContext(this)
                .withPermission(Manifest.permission.RECORD_AUDIO)
                .withListener(new PermissionListener() {
                    @Override public void onPermissionGranted(PermissionGrantedResponse response) {}
                    @Override public void onPermissionDenied(PermissionDeniedResponse response){
                        System.exit(0);
                    }
                    @Override public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token){
                        token.continuePermissionRequest();
                    }
                }).check();
        intitTextToSpeech();
        findbyid();
        result();
    }

    private void intitTextToSpeech() {
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(tts.getEngines().size()==0){
                    Toast.makeText(speechText.this, "Engine is not available", Toast.LENGTH_SHORT).show();
                }
                else {
                    String s =wishMe();
                    speak("Hello, I am Hendrix"+s);
                }
            }
        });

    }



    private void speak(String msg) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null, null);
        }
        else {
            tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    private void findbyid() {
        textView = (TextView)findViewById(R.id.textView);
    }

    private void result() {
        if(SpeechRecognizer.isRecognitionAvailable(this)){
            recognizer = SpeechRecognizer.createSpeechRecognizer(this);
            recognizer.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle bundle) {

                }

                @Override
                public void onBeginningOfSpeech() {

                }

                @Override
                public void onRmsChanged(float v) {

                }

                @Override
                public void onBufferReceived(byte[] bytes) {

                }

                @Override
                public void onEndOfSpeech() {

                }

                @Override
                public void onError(int i) {

                }

                @Override
                public void onResults(Bundle bundle) {
                    ArrayList<String> result = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                    Toast.makeText(speechText.this, ""+result.get(0), Toast.LENGTH_SHORT).show();
                    textView.setText(result.get(0));
                    response(result.get(0));

                }

                @Override
                public void onPartialResults(Bundle bundle) {

                }

                @Override
                public void onEvent(int i, Bundle bundle) {

                }
            });
        }
    }

    private void response(String msg) {
        String msgs = msg.toLowerCase(Locale.ROOT);
        if (msgs.indexOf("hi")!=-1) {
            speak("Hello, Hendrix at your service. Please tell me how I can help you?");
        }
        if (msgs.indexOf("time")!=-1) {
            Date date = new Date();
            String time = DateUtils.formatDateTime(this,date.getTime(),DateUtils.FORMAT_SHOW_TIME);
            speak(time);
        }
        if (msgs.indexOf("date")!=-1) {
            SimpleDateFormat dt = new SimpleDateFormat("dd mm yyyy");
            Calendar cal = Calendar.getInstance();
            String todays_Date = dt.format(cal.getTime());
            speak("Today's date is"+todays_Date);
        }
        if (msgs.indexOf("google")!=-1) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
            startActivity(intent);
        }
        if (msgs.indexOf("youtube")!=-1) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com"));
            startActivity(intent);
        }
        if (msgs.indexOf("search")!=-1) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q="+msgs.replace("search"," ")));
            startActivity(intent);
        }
        if (msgs.indexOf("remember")!=-1) {
            speak("Okay, i will remember that for you.");
            writeToFile(msgs.replace("Hendrix remember that", " "));

        }
        if (msgs.indexOf("know")!=-1) {
            String data = readFromFile();
            speak("Yes, you told me to remember that"+data);
        }
    }

    private String readFromFile() {
        String ret = "";
        try {
            InputStream inputStream = openFileInput("data.text");
            if (inputStream!= null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String Receivestr = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((Receivestr = bufferedReader.readLine())!=null) {
                    stringBuilder.append("\n").append(Receivestr);
                }
                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("Exception", "File not found"+e.toString());
        }
        catch (IOException e) {
            Log.e("Exception", "Cannot read file"+e.toString());
        }
        return ret;
    }

    private void writeToFile(String data) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("data.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch(IOException e) {
            Log.e("Exception", "File write failed" +e.toString());
        }
    }

    public void startRecording(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);

        recognizer.startListening(intent);
    }
}
