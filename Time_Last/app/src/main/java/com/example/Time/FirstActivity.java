package com.example.Time;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Time.R;
import com.parse.ParseInstallation;

public class FirstActivity extends AppCompatActivity {

    TextView textView;
    RadioGroup rg1, rg2, rg3, rg4, rg5, rg6;
    RadioButton radio_1_1, radio_1_2, radio_1_3, radio_1_4, radio_2_1, radio_2_2, radio_2_3, radio_2_4,
            radio_3_1, radio_3_2, radio_3_3, radio_3_4, radio_4_1, radio_4_2, radio_4_3, radio_4_4,
            radio_5_1, radio_5_2, radio_5_3, radio_5_4, radio_6_1, radio_6_2, radio_6_3, radio_6_4;
    Button button;
    int temp, temp2, temp3, temp4, temp5, temp6,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        setContentView(R.layout.activity_first);
        textView = findViewById(R.id.textView);


        RadioGroup rg1 = findViewById(R.id.rg1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_1_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_1_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_1_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_1_4 = (RadioButton) findViewById(checkedId);

                switch(checkedId){
                    case R.id.radio_1_1:
                        temp = 0;
                        break;
                    case R.id.radio_1_2:
                        temp = 1;
                        break;
                    case R.id.radio_1_3:
                        temp = 2;
                        break;
                    case R.id.radio_1_4:
                        temp = 3;
                        break;
                }


            }
        });
        RadioGroup rg2 = findViewById(R.id.rg2);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_2_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_2_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_2_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_2_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_2_1:
                        temp2 = 0;
                        break;
                    case R.id.radio_2_2:
                        temp2 = 1;
                        break;
                    case R.id.radio_2_3:
                        temp2 = 2;
                        break;
                    case R.id.radio_2_4:
                        temp2 = 3;
                        break;

                }

            }
        });
        RadioGroup rg3 = findViewById(R.id.rg3);
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_3_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_3_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_3_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_3_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_3_1:
                        temp3 = 0;
                        break;
                    case R.id.radio_3_2:
                        temp3 = 1;
                        break;
                    case R.id.radio_3_3:
                        temp3 = 2;
                        break;
                    case R.id.radio_3_4:
                        temp3 = 3;
                        break;
                }

            }
        });
        RadioGroup rg4 = findViewById(R.id.rg4);
        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_4_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_4_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_4_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_4_4 = (RadioButton) findViewById(checkedId);


                switch (checkedId) {
                    case R.id.radio_4_1:
                        temp4 = 0;
                        break;
                    case R.id.radio_4_2:
                        temp4 = 1;
                        break;
                    case R.id.radio_4_3:
                        temp4 = 2;
                        break;
                    case R.id.radio_4_4:
                        temp4 = 3;
                        break;

                }

            }
        });
        RadioGroup rg5 = findViewById(R.id.rg5);
        rg5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_5_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_5_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_5_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_5_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_5_1:
                        temp5 = 3;
                        break;
                    case R.id.radio_5_2:
                        temp5 = 2;
                        break;
                    case R.id.radio_5_3:
                        temp5 = 1;
                        break;
                    case R.id.radio_5_4:
                        temp5 = 0;
                        break;

                }
            }
        });
        RadioGroup rg6 = findViewById(R.id.rg6);
        rg6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_6_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_6_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_6_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_6_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_6_1:
                        temp6 = 0;
                        break;
                    case R.id.radio_6_2:
                        temp6 = 1;
                        break;
                    case R.id.radio_6_3:
                        temp6 = 2;
                        break;
                    case R.id.radio_6_4:
                        temp6 = 3;
                        break;

                }

            }
        });
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            int result;
            @Override
            public void onClick(View v) {
                result = temp + temp2+ temp3 + temp4 + temp5 + temp6;

                Toast.makeText(getApplicationContext(), "두번째장입니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("result", result);
                startActivity(intent);
            }

        });


    }
}