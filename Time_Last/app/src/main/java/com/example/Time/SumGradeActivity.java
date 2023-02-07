package com.example.Time;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Time.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class SumGradeActivity extends AppCompatActivity {

    private TextView behavior_grade;

    private TextView Inspection_grade;
    private TextView Answer_grade;
    private TextView Inspection_total_grade;

    private TextView Wake_Up_grade;
    private TextView Sleeping_Time_grade;
    private TextView Dietary_Life_grade;
    private TextView record_grade;

    private TextView Contact_grade;
    private TextView Youtube_grade;
    private TextView Usage_grade;

    private int behavior_count = 0;
    private int pattern_grade;

    private int Messaging_grade; // 카카오톡으로 변경
    private int Settings_grade; // 유튜브로 변경
    private int usage_total_grade;

    private int wake_up_grade;
    private int sleeping_time_grade;
    private int dietary_life_grade;
    private int record_total_grade;

    private int inspection_grade;
    private int answer_grade;
    private int inspection_total_grade;

    private double Sleeping_Time_sum = 0.0;
    private double Sleeping_Time_avr = 0.0;
    private double phone_usage_sum = 0.0;
    private double phone_usage_avr = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_grade);

        behavior_grade = (TextView)findViewById(R.id.behavior_grade); // 행동패턴 점수
        Inspection_grade = (TextView)findViewById(R.id.Inspection_grade); // 우울증 검사 점수
        Answer_grade = (TextView)findViewById(R.id.Answer_grade); // 우울증 검사 답변 점수
        Inspection_total_grade = (TextView)findViewById(R.id.Inspection_total_grade); // 우울증 검사 + 답변 점수
        Wake_Up_grade = (TextView)findViewById(R.id.Wake_Up_grade); // 기상시간 점수
        Sleeping_Time_grade = (TextView)findViewById(R.id.Sleeping_Time_grade); // 수면시간 점수
        Dietary_Life_grade = (TextView)findViewById(R.id.Dietary_Life_grade); // 식생활 점수
        record_grade = (TextView)findViewById(R.id.record_grade); // 생활점수
        Contact_grade = (TextView)findViewById(R.id.Contact_grade); // 연락시간 점수
        Youtube_grade = (TextView)findViewById(R.id.Youtube_grade); // 유튜브 사용시간점수
        Usage_grade = (TextView)findViewById(R.id.Usage_grade); // 어플 사용시간 점수

        Button btn_sum_total = findViewById(R.id.btn_sum_total);

        ParseQuery<ParseObject> behavior_query = ParseQuery.getQuery("behavior");
        behavior_query.findInBackground(new FindCallback<ParseObject>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if(e == null) {
                    for(int i = 0; i <list.size(); i++) {
                        pattern_grade = 4;
                        if (list.get(i).getString("behavior").equals("Take a walk")){
                            behavior_count += 1;

                            if (behavior_count <= 4*7){
                                pattern_grade = 5;
                            }
                            else if (list.get(i).getInt("Take_a_walk_count") <= 6*7){
                                pattern_grade = 4;
                            }
                            else if (list.get(i).getInt("Take_a_walk_count") <= 8*7){
                                pattern_grade = 3;
                            }
                            else if (list.get(i).getInt("Take_a_walk_count") <= 12*7){
                                pattern_grade = 2;
                            }
                            else if (list.get(i).getInt("Take_a_walk_count") < 24*7){
                                pattern_grade = 1;
                            }

                        }
                    }
                } else {
                    behavior_grade.setText("Error:" + e.getMessage());
                }

                behavior_grade.append("행동패턴 점수 : " + pattern_grade);

                ParseObject behavior_grade = new ParseObject("grade");
                behavior_grade.put("behavior_grade", pattern_grade);
                behavior_grade.saveInBackground();
            }
        });

        ParseQuery<ParseObject> inspection_query = ParseQuery.getQuery("psychological_examination");
        inspection_query.findInBackground(new FindCallback<ParseObject>() {
            @SuppressLint("SetTextI18n")
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    for (int i = 0; i < list.size(); i++) {
                        // 우울증 검사 점수
                        if (list.get(i).getInt("inspection_grade") == 0) {

                        }
                        else if (list.get(i).getInt("inspection_grade") <= 15) {
                            inspection_grade = list.get(i).getInt("inspection_grade");
                            Inspection_grade.setText("우울증 검사 점수 : " + inspection_grade + "\n");
                        }
                        else if (list.get(i).getInt("inspection_grade") <= 20) {
                            inspection_grade = list.get(i).getInt("inspection_grade");
                            Inspection_grade.setText("우울증 검사 점수 : " + inspection_grade + "\n");
                        }
                        else if (list.get(i).getInt("inspection_grade") <= 24) {
                            inspection_grade = list.get(i).getInt("inspection_grade");
                            Inspection_grade.setText("우울증 검사 점수 : " + inspection_grade + "\n");
                        }
                        else if (list.get(i).getInt("inspection_grade") <= 60) {
                            inspection_grade = list.get(i).getInt("inspection_grade");
                            Inspection_grade.setText("우울증 검사 점수 : " + inspection_grade + "\n");
                        }

                        // 답변 점수
                        if (list.get(i).getInt("answer_grade") == 0){

                        }
                        else if (list.get(i).getInt("answer_grade") <= 3){
                            answer_grade = list.get(i).getInt("answer_grade");
                            Answer_grade.setText("답변 점수 : " + answer_grade + "\n");
                        }
                        else if (list.get(i).getInt("answer_grade") <= 5){
                            answer_grade = list.get(i).getInt("answer_grade");
                            Answer_grade.setText("답변 점수 : " + answer_grade + "\n");
                        }
                        else if (list.get(i).getInt("answer_grade") <= 6){
                            answer_grade = list.get(i).getInt("answer_grade");
                            Answer_grade.setText("답변 점수 : " + answer_grade + "\n");
                        }
                    }

                } else {
                    Inspection_total_grade.setText("Error: " +e.getMessage());
                }

                inspection_total_grade = inspection_grade + answer_grade;
                Inspection_total_grade.append("우울증 진단테스트 점수 : " + inspection_total_grade);


                ParseObject inspection_sum = new ParseObject("grade");
                inspection_sum.put("inspection_total_grade", inspection_total_grade);
                inspection_sum.saveInBackground();

                ParseObject inspection_total = new ParseObject("inspection_total_grade");
                inspection_total.put("inspection_total_grade", inspection_total_grade);
                inspection_total.saveInBackground();
            }
        });

        ParseQuery<ParseObject> record_query = ParseQuery.getQuery("record");
        record_query.findInBackground(new FindCallback<ParseObject>() {
            @SuppressLint("SetTextI18n")
            public void done(List<ParseObject> list, ParseException e) {
                if(e == null) {
                    for(int i = 0; i < list.size(); i++) {

                        // 기상시간 점수
                        if (list.get(i).getInt("Wake_Up") == 0) {

                        }
                        else if (list.get(i).getInt("Wake_Up") <= 4){
                            wake_up_grade = 5;
                            Wake_Up_grade.setText("기상시간 점수 : " + wake_up_grade + "\n");
                        }
                        else if (list.get(i).getInt("Wake_Up") <= 8){
                            wake_up_grade = 1;
                            Wake_Up_grade.setText("기상시간 점수 : " + wake_up_grade + "\n");
                        }
                        else if (list.get(i).getInt("Wake_Up") <= 12){
                            wake_up_grade = 2;
                            Wake_Up_grade.setText("기상시간 점수 : " + wake_up_grade + "\n");
                        }
                        else if (list.get(i).getInt("Wake_Up") <= 16){
                            wake_up_grade = 3;
                            Wake_Up_grade.setText("기상시간 점수 : " + wake_up_grade + "\n");
                        }
                        else if (list.get(i).getInt("Wake_Up") <= 23){
                            wake_up_grade = 4;
                            Wake_Up_grade.setText("기상시간 점수 : " + wake_up_grade + "\n");
                        }

                        // 수면시간 점수
                        if (list.get(i).getInt("Sleeping_Time") == 0){

                        }
                        else if (list.get(i).getInt("Sleeping_Time") <= 3){
                            sleeping_time_grade = 5;
                            Sleeping_Time_grade.setText("수면시간 점수 : " + sleeping_time_grade + "\n");
                        }
                        else if (list.get(i).getInt("Sleeping_Time") <= 6){
                            sleeping_time_grade = 3;
                            Sleeping_Time_grade.setText("수면시간 점수 : " + sleeping_time_grade + "\n");
                        }
                        else if (list.get(i).getInt("Sleeping_Time") <= 9){
                            sleeping_time_grade = 1;
                            Sleeping_Time_grade.setText("수면시간 점수 : " + sleeping_time_grade + "\n");
                        }
                        else if (list.get(i).getInt("Sleeping_Time") <= 12){
                            sleeping_time_grade = 2;
                            Sleeping_Time_grade.setText("수면시간 점수 : " + sleeping_time_grade + "\n");
                        }
                        else if (list.get(i).getInt("Sleeping_Time") <= 24){
                            sleeping_time_grade = 4;
                            Sleeping_Time_grade.setText("수면시간 점수 : " + sleeping_time_grade + "\n");
                        }

                        // 식생활 점수
                        if (list.get(i).getInt("Dietary_Life") == 0){

                        }
                        else if (list.get(i).getInt("Dietary_Life") == 1){
                            dietary_life_grade = 3;
                            Dietary_Life_grade.setText("식생활 점수 : " + dietary_life_grade +"\n");
                        }
                        else if (list.get(i).getInt("Dietary_Life") == 2){
                            dietary_life_grade = 2;
                            Dietary_Life_grade.setText("식생활 점수 : " + dietary_life_grade + "\n");
                        }
                        else if (list.get(i).getInt("Dietary_Life") == 3){
                            dietary_life_grade = 1;
                            Dietary_Life_grade.setText("식생활 점수 : " + dietary_life_grade + "\n");
                        }
                        else if (list.get(i).getInt("Dietary_Life") == 4){
                            dietary_life_grade = 2;
                            Dietary_Life_grade.setText("식생활 점수 : " + dietary_life_grade + "\n");
                        }
                        else if (list.get(i).getInt("Dietary_Life") == 5){
                            dietary_life_grade = 3;
                            Dietary_Life_grade.setText("식생활 점수 : " + dietary_life_grade + "\n");
                        }

                    }
                } else {
                    record_grade.setText("Error: " +e.getMessage());
                }

                record_total_grade = wake_up_grade + sleeping_time_grade + dietary_life_grade;
                record_grade.append("기록점수 : " + record_total_grade);

                ParseObject record_total = new ParseObject("grade");
                record_total.put("wake_up_grade", wake_up_grade);
                record_total.put("sleeping_time_grade", sleeping_time_grade);
                record_total.put("dietary_life_grade", dietary_life_grade);
                record_total.saveInBackground();
            }
        });

        ParseQuery<ParseObject> usage_query = ParseQuery.getQuery("usage");
        usage_query.findInBackground(new FindCallback<ParseObject>() {
            @SuppressLint("SetTextI18n")
            public void done(List<ParseObject> list, ParseException e) {
                if(e == null) {
                    for(int i = 0; i < list.size(); i++) {
                        // 카카오톡 사용시간 점수 ("Messaging") 변경하기
                        if (list.get(i).getString("appName").equals("Messaging")) {
                            if (list.get(i).getInt("Hour") == 0) {
                                Messaging_grade = 5;
                                Contact_grade.setText("카카오톡 사용시간 점수 : " + Messaging_grade + "\n");
                            }
                            else if (list.get(i).getInt("Hour") == 1){
                                Messaging_grade = 4;
                                Contact_grade.setText("카카오톡 사용시간 점수 : " + Messaging_grade + "\n");
                            }
                            else if (list.get(i).getInt("Hour") == 2){
                                Messaging_grade = 3;
                                Contact_grade.setText("카카오톡 사용시간 점수 : " + Messaging_grade + "\n");
                            }
                            else if (list.get(i).getInt("Hour") == 3){
                                Messaging_grade = 2;
                                Contact_grade.setText("카카오톡 사용시간 점수 : " + Messaging_grade + "\n");
                            }
                            else if (list.get(i).getInt("Hour") == 4){
                                Messaging_grade = 1;
                                Contact_grade.setText("카카오톡 사용시간 점수 : " + Messaging_grade + "\n");
                            }

                        }

                        // 유튜브 사용시간 점수 ("Settings") 변경하기
                        else if (list.get(i).getString("appName").equals("Settings")){
                            if (list.get(i).getInt("Hour") <= 5) {
                                Settings_grade = 1;
                                Youtube_grade.setText("유튜브 사용시간 점수 : " + Settings_grade + "\n");
                            }
                            else if (list.get(i).getInt("Hour") <= 10){
                                Settings_grade = 2;
                                Youtube_grade.setText("유튜브 사용시간 점수 : " + Settings_grade + "\n");
                            }
                            else if (list.get(i).getInt("Hour") <= 15){
                                Settings_grade = 3;
                                Youtube_grade.setText("유튜브 사용시간 점수 : " + Settings_grade + "\n");
                            }
                            else if (list.get(i).getInt("Hour") <= 20){
                                Settings_grade = 4;
                                Youtube_grade.setText("유튜브 사용시간 점수 : " + Settings_grade + "\n");
                            }
                            else if (list.get(i).getInt("Hour") <= 168){
                                Settings_grade = 5;
                                Youtube_grade.setText("유튜브 사용시간 점수 : " + Settings_grade + "\n");
                            }

                        }
                    }
                } else {
                    Usage_grade.setText("Error: " +e.getMessage());
                }

                usage_total_grade = Messaging_grade + Settings_grade;
                Usage_grade.append("어플 사용시간 점수 : " + usage_total_grade);

                ParseObject usage_total = new ParseObject("grade");
                usage_total.put("usage_grade", usage_total_grade);
                usage_total.saveInBackground();

            }
        });

        btn_sum_total.setOnClickListener(view -> {
            Intent sum_total = new Intent(SumGradeActivity.this, ResultActivity.class);
            startActivity(sum_total);
        });

        ParseQuery<ParseObject> sleep_average_query = ParseQuery.getQuery("Sleeping_Time");
        sleep_average_query.findInBackground(new FindCallback<ParseObject>() {
            @SuppressLint("SetTextI18n")
            public void done(List<ParseObject> list, ParseException e) {
                if(e == null) {
                    for(int i = 0; i < list.size(); i++) {
                        ArrayList<Integer> sleep_list = new ArrayList<>();
                        sleep_list.add(list.get(i).getInt("Sleeping_Time"));

                        for(Integer sleep_time: sleep_list){
                            Sleeping_Time_sum += sleep_time;
                        }
                        Sleeping_Time_avr = Sleeping_Time_sum / list.size();
                    }

                } else {

                }

                ParseObject total = new ParseObject("total");
                total.put("sleep_average", Sleeping_Time_avr);
                total.saveInBackground();
            }
        });

        ParseQuery<ParseObject> usage_average_query = ParseQuery.getQuery("phone_usage");
        usage_average_query.findInBackground(new FindCallback<ParseObject>() {
            @SuppressLint("SetTextI18n")
            public void done(List<ParseObject> list, ParseException e) {
                if(e == null) {
                    for(int i = 0; i < list.size(); i++) {
                        ArrayList<Integer> usage_list = new ArrayList<>();
                        usage_list.add(list.get(i).getInt("phone_usage"));

                        for(Integer app_time: usage_list){
                            phone_usage_sum += app_time;
                        }
                        phone_usage_avr = phone_usage_sum / list.size();
                    }

                } else {

                }

                ParseObject total = new ParseObject("total");
                total.put("usage_average", phone_usage_avr);
                total.saveInBackground();
            }
        });

    }
}