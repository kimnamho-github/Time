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

public class ThirdActivity extends AppCompatActivity {

    TextView textView;
    RadioGroup rg13, rg14, rg15, rg16, rg17, rg18;
    RadioButton radio_13_1, radio_13_2, radio_13_3, radio_13_4, radio_14_1, radio_14_2, radio_14_3, radio_14_4,
            radio_15_1, radio_15_2, radio_15_3, radio_15_4, radio_16_1, radio_16_2, radio_16_3, radio_16_4,
            radio_17_1, radio_17_2, radio_17_3, radio_17_4, radio_18_1, radio_18_2, radio_18_3, radio_18_4;
    Button button;
    int temp, temp2, temp3, temp4, temp5, temp6,result3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        setContentView(R.layout.activity_third);
        textView = findViewById(R.id.textView);
        Intent intent = new Intent(this.getIntent());
        int result2 = intent.getIntExtra("result2",0);


        RadioGroup rg13 = findViewById(R.id.rg13);
        rg13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_13_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_13_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_13_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_13_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_13_1:
                        temp = 0;
                        break;
                    case R.id.radio_13_2:
                        temp = 1;
                        break;
                    case R.id.radio_13_3:
                        temp = 2;
                        break;
                    case R.id.radio_13_4:
                        temp = 3;
                        break;
                }
            }
        });
        RadioGroup rg14 = findViewById(R.id.rg14);
        rg14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_14_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_14_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_14_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_14_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_14_1:
                        temp2 = 0;
                        break;
                    case R.id.radio_14_2:
                        temp2 = 1;
                        break;
                    case R.id.radio_14_3:
                        temp2 = 2;
                        break;
                    case R.id.radio_14_4:
                        temp2 = 3;
                        break;
                }
            }
        });
        RadioGroup rg15 = findViewById(R.id.rg15);
        rg15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_15_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_15_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_15_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_15_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_15_1:
                        temp3 = 3;
                        break;
                    case R.id.radio_15_2:
                        temp3 = 2;
                        break;
                    case R.id.radio_15_3:
                        temp3 = 1;
                        break;
                    case R.id.radio_15_4:
                        temp3 = 0;
                        break;
                }
            }
        });
        RadioGroup rg16 = findViewById(R.id.rg16);
        rg16.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_16_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_16_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_16_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_16_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_16_1:
                        temp4 = 0;
                        break;
                    case R.id.radio_16_2:
                        temp4 = 1;
                        break;
                    case R.id.radio_16_3:
                        temp4 = 2;
                        break;
                    case R.id.radio_16_4:
                        temp4 = 3;
                        break;
                }

            }
        });
        RadioGroup rg17 = findViewById(R.id.rg17);
        rg17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_17_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_17_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_17_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_17_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_17_1:
                        temp5 = 0;
                        break;
                    case R.id.radio_17_2:
                        temp5 = 1;
                        break;
                    case R.id.radio_17_3:
                        temp5 = 2;
                        break;
                    case R.id.radio_17_4:
                        temp5 = 3;
                        break;
                }
            }
        });
        RadioGroup rg18 = findViewById(R.id.rg18);
        rg18.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_18_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_18_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_18_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_18_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_18_1:
                        temp6 = 0;
                        break;
                    case R.id.radio_18_2:
                        temp6 = 1;
                        break;
                    case R.id.radio_18_3:
                        temp6 = 2;
                        break;
                    case R.id.radio_18_4:
                        temp6 = 3;
                        break;
                }
            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            int result3;
            @Override
            public void onClick(View v) {
                result3 = result2 + temp + temp2+ temp3 + temp4 + temp5 + temp6;
                Toast.makeText(getApplicationContext(), "마지막장입니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ForthActivity.class);
                intent.putExtra("result3", result3);
                startActivity(intent);
            }

        });


    }
}