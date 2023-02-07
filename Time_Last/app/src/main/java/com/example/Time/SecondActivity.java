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

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    RadioGroup rg7, rg8, rg9, rg10, rg11, rg12;
    RadioButton radio_7_1, radio_7_2, radio_7_3, radio_7_4, radio_8_1, radio_8_2, radio_8_3, radio_8_4,
            radio_9_1, radio_9_2, radio_9_3, radio_9_4, radio_10_1, radio_10_2, radio_10_3, radio_10_4,
            radio_11_1, radio_11_2, radio_11_3, radio_11_4, radio_12_1, radio_12_2, radio_12_3, radio_12_4;
    Button button;
    int temp, temp2, temp3, temp4, temp5, temp6,result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.textView);
        Intent intent = new Intent(this.getIntent());
        int result = intent.getIntExtra("result",0);


        RadioGroup rg7 = findViewById(R.id.rg7);
        rg7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_7_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_7_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_7_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_7_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_7_1:
                        temp = 0;
                        break;
                    case R.id.radio_7_2:
                        temp = 1;
                        break;
                    case R.id.radio_7_3:
                        temp = 2;
                        break;
                    case R.id.radio_7_4:
                        temp = 3;
                        break;
                }
            }
        });
        RadioGroup rg8 = findViewById(R.id.rg8);
        rg8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_8_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_8_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_8_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_8_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_8_1:
                        temp2 = 0;
                        break;
                    case R.id.radio_8_2:
                        temp2 = 1;
                        break;
                    case R.id.radio_8_3:
                        temp2 = 2;
                        break;
                    case R.id.radio_8_4:
                        temp2 = 3;
                        break;
                }
            }
        });
        RadioGroup rg9 = findViewById(R.id.rg9);
        rg9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_9_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_9_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_9_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_9_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_9_1:
                        temp3 = 0;
                        break;
                    case R.id.radio_9_2:
                        temp3 = 1;
                        break;
                    case R.id.radio_9_3:
                        temp3 = 2;
                        break;
                    case R.id.radio_9_4:
                        temp3 = 3;
                        break;
                }
            }
        });
        RadioGroup rg10 = findViewById(R.id.rg10);
        rg10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_10_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_10_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_10_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_10_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_10_1:
                        temp4 = 3;
                        break;
                    case R.id.radio_10_2:
                        temp4 = 2;
                        break;
                    case R.id.radio_10_3:
                        temp4 = 1;
                        break;
                    case R.id.radio_10_4:
                        temp4 = 0;
                        break;
                }

            }
        });
        RadioGroup rg11 = findViewById(R.id.rg11);
        rg11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_11_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_11_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_11_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_11_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_11_1:
                        temp5 = 0;
                        break;
                    case R.id.radio_11_2:
                        temp5 = 1;
                        break;
                    case R.id.radio_11_3:
                        temp5= 2;
                        break;
                    case R.id.radio_11_4:
                        temp5 = 3;
                        break;
                }
            }
        });
        RadioGroup rg12 = findViewById(R.id.rg12);
        rg12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_12_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_12_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_12_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_12_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_12_1:
                        temp6 = 0;
                        break;
                    case R.id.radio_12_2:
                        temp6 = 1;
                        break;
                    case R.id.radio_12_3:
                        temp6 = 2;
                        break;
                    case R.id.radio_12_4:
                        temp6 = 3;
                        break;
                }
            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            int result2;
            @Override
            public void onClick(View v) {
                result2 = result + temp + temp2+ temp3 + temp4 + temp5 + temp6;
                Toast.makeText(getApplicationContext(), "세번째장입니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                intent.putExtra("result2", result2);
                startActivity(intent);
            }

        });


    }
}