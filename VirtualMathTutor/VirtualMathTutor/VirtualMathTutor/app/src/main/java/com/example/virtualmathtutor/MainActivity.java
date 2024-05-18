package com.example.virtualmathtutor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        interaction.sendText(Interaction.IS_BOT, "your answer is " + bot.solution+" :)");
        tv.setText("");
    }
}