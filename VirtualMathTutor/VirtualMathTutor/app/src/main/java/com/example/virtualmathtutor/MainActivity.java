package com.example.virtualmathtutor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView text;
    LinearLayout linearLayout;
    Interaction interaction;
    String question_str;
    WordsToNumber bot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        linearLayout = (LinearLayout) findViewById(R.id.MainLinearLayout);
        interaction = new Interaction(this, linearLayout, text);
    }

    public void clickSend(View view)
    {
        TextView tv = (TextView) findViewById(R.id.autoCompleteTextView2);
        question_str = tv.getText().toString();
//        Toast.makeText(this, question_str, Toast.LENGTH_SHORT).show();
        bot = new WordsToNumber();
        interaction.sendText(Interaction.IS_USER, question_str);
        bot.solveThis(question_str);
        interaction.sendText(Interaction.IS_BOT, " Your answer is " + bot.solution+"  :)");
        tv.setText("");
    }

    public void speechToText(View view) {
        Intent intent= new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Hi Speak Something");
        try {
            startActivityForResult(intent,
                    1);
        }
        catch(ActivityNotFoundException e){
            Toast.makeText(this,
                    e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView atv = (TextView) findViewById(R.id.autoCompleteTextView2);
        switch (requestCode){

            case 1:
                if(resultCode==RESULT_OK && null!=data){

                    ArrayList<String> result =
                            data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    atv.setText(result.get(0));
                }

                break;
        }
    }

}