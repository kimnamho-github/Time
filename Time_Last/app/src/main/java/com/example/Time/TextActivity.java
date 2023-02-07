package com.example.Time;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Time.R;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

public class TextActivity extends AppCompatActivity {

    TextView textView, textView2, textView3;
    android.widget.EditText EditText, EditText2, EditText3;
    int temp, temp2, temp3, score;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        setContentView(R.layout.activity_text);
        String text, text2, text3;
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        EditText = (EditText) findViewById(R.id.EditText);
        EditText2 = (EditText) findViewById(R.id.EditText2);
        EditText3 = (EditText) findViewById(R.id.EditText3);
        button = findViewById(R.id.button);
        Button btn_home = findViewById(R.id.btn_home);

        btn_home.setOnClickListener(view -> {
            Intent home = new Intent(TextActivity.this, HomeActivity.class);
            startActivity(home);
        });
        EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                final String case1 = "네";
                final String case2 = "아니오";
                String text = EditText.getText().toString();
                switch (text) {
                    case case1:
                        temp = 1;
                        break;
                    case case2:
                        temp = 2;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                final String case1 = "네";
                final String case2 = "아니오";
                String text = EditText.getText().toString();
                switch (text) {
                    case case1:
                        temp = 1;
                        break;
                    case case2:
                        temp = 2;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                final String case1 = "네";
                final String case2 = "아니오";
                String text = EditText.getText().toString();
                switch (text) {
                    case case1:
                        temp = 1;
                        break;
                    case case2:
                        temp = 2;
                }
            }
        });
        EditText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                final String case1 = "네";
                final String case2 = "아니오";
                String text2 = EditText2.getText().toString();
                switch (text2) {
                    case case1:
                        temp2 = 2;
                        break;
                    case case2:
                        temp2 = 1;
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                final String case1 = "네";
                final String case2 = "아니오";
                String text2 = EditText2.getText().toString();
                switch (text2) {
                    case case1:
                        temp2 = 2;
                        break;
                    case case2:
                        temp2 = 1;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                final String case1 = "네";
                final String case2 = "아니오";
                String text2 = EditText2.getText().toString();
                switch (text2) {
                    case case1:
                        temp2 = 2;
                        break;
                    case case2:
                        temp2 = 1;
                }
            }
        });
        EditText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                final String case1 = "네";
                final String case2 = "아니오";
                String text3 = EditText3.getText().toString();
                switch (text3) {
                    case case1:
                        temp3 = 1;
                        break;
                    case case2:
                        temp3 = 2;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                final String case1 = "네";
                final String case2 = "아니오";
                String text3 = EditText3.getText().toString();
                switch (text3) {
                    case case1:
                        temp3 = 1;
                        break;
                    case case2:
                        temp3 = 2;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                final String case1 = "네";
                final String case2 = "아니오";
                String text3 = EditText3.getText().toString();
                switch (text3) {
                    case case1:
                        temp3 = 1;
                        break;
                    case case2:
                        temp3 = 2;
                }
            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = temp + temp2 + temp3;

                ParseObject answer = new ParseObject("psychological_examination");
                answer.put("answer_grade", score);

                if (score == 0) {

                } else if (score <= 3){
                    answer.put("answer_result", "정상");
                } else if (score <= 5){
                    answer.put("answer_result", "보통");
                } else if (score <= 6){
                    answer.put("answer_result", "위험");
                }

                answer.saveInBackground();
                Toast.makeText(getApplicationContext(), "감사합니다." , Toast.LENGTH_SHORT).show();
            }
        });
    }

}