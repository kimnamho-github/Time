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
import com.parse.ParseObject;

public class ForthActivity extends AppCompatActivity {

    TextView textView, score;
    RadioGroup rg19, rg20;
    RadioButton radio_19_1, radio_19_2, radio_19_3, radio_19_4, radio_20_1, radio_20_2, radio_20_3, radio_20_4;
    Button button;
    int temp, temp2, temp3, temp4, temp5, temp6,result4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParseInstallation.getCurrentInstallation().saveInBackground();
        setContentView(R.layout.activity_forth);
        textView = findViewById(R.id.textView);
        TextView score = (TextView) findViewById(R.id.score);
        Intent intent = new Intent(this.getIntent());
        int result3 = intent.getIntExtra("result3",0);
        Button btn_text = findViewById(R.id.btn_text);

        btn_text.setOnClickListener(view -> {
            Intent home = new Intent(ForthActivity.this, TextActivity.class);
            startActivity(home);
        });

        RadioGroup rg19 = findViewById(R.id.rg19);
        rg19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_19_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_19_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_19_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_19_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_19_1:
                        temp = 0;
                        break;
                    case R.id.radio_19_2:
                        temp = 1;
                        break;
                    case R.id.radio_19_3:
                        temp = 2;
                        break;
                    case R.id.radio_19_4:
                        temp = 3;
                        break;
                }
            }
        });
        RadioGroup rg20 = findViewById(R.id.rg20);
        rg20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radio_20_1 = (RadioButton) findViewById(checkedId);
                RadioButton radio_20_2 = (RadioButton) findViewById(checkedId);
                RadioButton radio_20_3 = (RadioButton) findViewById(checkedId);
                RadioButton radio_20_4 = (RadioButton) findViewById(checkedId);

                switch (checkedId) {
                    case R.id.radio_20_1:
                        temp2 = 0;
                        break;
                    case R.id.radio_20_2:
                        temp2 = 1;
                        break;
                    case R.id.radio_20_3:
                        temp2 = 2;
                        break;
                    case R.id.radio_20_4:
                        temp2 = 3;
                        break;
                }
            }
        });
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            int result4;
            @Override
            public void onClick(View v) {
                result4 = result3 + temp + temp2+ temp3 + temp4 + temp5 + temp6;
                ParseObject inspection = new ParseObject("psychological_examination");
                inspection.put("inspection_grade", result4);

                if (result4 <= 15) {
                    inspection.put("inspection_result", "위험");
                } else if (result4 <= 20){
                    inspection.put("inspection_result", "경미한 우울증");
                } else if (result4 <= 24){
                    inspection.put("inspection_result", "중한 우울증");
                } else if (result4 <= 60){
                    inspection.put("inspection_result", "심각한 우울증");
                }
                inspection.saveInBackground();
                score.setText(Integer.toString(result4));
                Toast.makeText(getApplicationContext(), "완료" , Toast.LENGTH_SHORT).show();
            }

        });

    }
}

