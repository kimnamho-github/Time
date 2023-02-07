package com.example.Time;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home.Time.R;
import com.parse.ParseObject;

public class Record_Activity extends AppCompatActivity {

    EditText et_wakeup;
    EditText et_slp;
    EditText et_eat;
    Button btn_wakeup;
    Button btn_slp;
    Button btn_eat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        et_wakeup = findViewById(R.id.et_wakeup);
        et_slp = findViewById(R.id.et_slp);
        et_eat = findViewById(R.id.et_eat);
        btn_wakeup = findViewById(R.id.btn_wakeup);
        btn_slp = findViewById(R.id.btn_slp);
        btn_eat = findViewById(R.id.btn_eat);

        // 일어난 시간
        btn_wakeup.setOnClickListener(view -> {
            ParseObject Wake_Up = new ParseObject("record");
            int wakeup_record = Integer.parseInt(et_wakeup.getText().toString()); // String를 Int형으로 변환
            Wake_Up.put("Wake_Up", wakeup_record); // back4app 에 데이터 저장
            Wake_Up.saveInBackground();
            Toast.makeText(this, "일어난 시간이 저장되었습니다", Toast.LENGTH_SHORT).show();
        });

        // 수면 시간
        btn_slp.setOnClickListener(view -> {
            ParseObject Sleeping_Time1 = new ParseObject("record");
            int slp_record = Integer.parseInt(et_slp.getText().toString()); // String를 Int형으로 변환
            Sleeping_Time1.put("Sleeping_Time", slp_record); // back4app 에 데이터 저장
            Sleeping_Time1.saveInBackground();
            Toast.makeText(this, "수면시간이 저장되었습니다", Toast.LENGTH_SHORT).show();

            ParseObject Sleeping_Time2 = new ParseObject("Sleeping_Time");
            Sleeping_Time2.put("Sleeping_Time", slp_record); // back4app 에 데이터 저장
            Sleeping_Time2.saveInBackground();

            ParseObject total = new ParseObject("total");
            total.put("Sleeping_Time", slp_record); // back4app 에 데이터 저장
            total.saveInBackground();
        });

        // 식생활
        btn_eat.setOnClickListener(view -> {
            ParseObject Dietary_Life = new ParseObject("record");
            int eat_record = Integer.parseInt(et_eat.getText().toString()); // String를 Int형으로 변환
            Dietary_Life.put("Dietary_Life", eat_record); // back4app 에 데이터 저장
            Dietary_Life.saveInBackground();
            Toast.makeText(this, "식생활이 저장되었습니다", Toast.LENGTH_SHORT).show();
        });
    }
}