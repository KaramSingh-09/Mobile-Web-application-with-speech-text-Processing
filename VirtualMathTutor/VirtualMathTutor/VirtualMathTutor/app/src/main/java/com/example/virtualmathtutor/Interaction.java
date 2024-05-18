package com.example.virtualmathtutor;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Interaction {
    public static int IS_USER = 80;
    public static int IS_BOT = 443;
    private TextView text;
    private LinearLayout linearLayout;
    private Context contex;
//    WordsToNumber bot;
    Interaction(Context contex,LinearLayout linearLayout, TextView textView)
    {
        this.linearLayout = linearLayout;
        this.text = textView;
        this.contex = contex;
    }

    void sendText(int whois, String str)
    {
        switch (whois)
        {
            case 80: //IS_USER
                sendTextAsUser(str);
//                bot = new WordsToNumber();
                break;

            case 443:  //IS_BOT
                sendTextAsBot(str);
                break;
            default:{
                Toast.makeText(contex, "Send by unknown user..", Toast.LENGTH_SHORT).show();
            }

        }

    }
    private void sendTextAsBot(String botstr) {
        text = new TextView(contex);
        text.setText(botstr);
        text.setTextSize(20);
//        text.setBackgroundColor(Color.parseColor("#FF8010"));
//        lp.setMargins(20,20,20,20);

        text.setBackgroundResource(R.drawable.text_background);
        text.setMaxWidth(2);
        text.setPadding(30,30,30,30);
        text.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        linearLayout.addView(text);
        text.setTextColor(Color.parseColor("#FFFFFF"));
    }

    private void sendTextAsUser(String userstr) {
        text = new TextView(contex);
        text.setText(userstr);
        text.setTextSize(20);
//        text.setBackgroundColor();
        text.setBackgroundResource(R.drawable.user_text_bckgrnd);
        text.setPadding(30,30,30,30);
        text.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        linearLayout.addView(text);
        text.setTextColor(Color.parseColor("#FFFFFF"));
//        bot.solveThis(userstr);
//        sendTextAsBot("Your Answer is "+ bot.solution+" :)");
    }
}
