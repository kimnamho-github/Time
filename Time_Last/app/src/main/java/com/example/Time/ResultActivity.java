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

import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private TextView sum_total;
    private TextView result;

    private TextView phone;
    private TextView phone_avr;
    private TextView sleeping;
    private TextView sleeping_avr;
    private TextView sleep_usage_result;

    private int wake_up_grade;
    private int sleeping_time_grade;
    private int dietary_life_grade;

    private int inspection_total_grade;
    private int usage_total_grade;
    private int behavior_grade;

    private int total_grade;

    private int phone_usage = 0;
    private int usage_average = 0;
    private int sleep = 0;
    private int sleep_average = 0;
    private int phone_result = 0;
    private int sleep_result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        sum_total = (TextView)findViewById(R.id.sum_total);
        result = (TextView)findViewById(R.id.result);
        phone = (TextView)findViewById(R.id.phone);
        phone_avr = (TextView)findViewById(R.id.phone_avr);
        sleeping = (TextView)findViewById(R.id.sleeping);
        sleeping_avr = (TextView)findViewById(R.id.sleeping_avr);
        sleep_usage_result = (TextView)findViewById(R.id.sleep_usage_result);

        Button btn_inspection_grade_graph = findViewById(R.id.btn_inspection_grade_graph);
        Button btn_record_graph = findViewById(R.id.btn_record_graph);

        btn_inspection_grade_graph.setOnClickListener(view -> {
            Intent inspection_grade_graph = new Intent(ResultActivity.this, InspectionGradeGraphActivity.class);
            startActivity(inspection_grade_graph);
        });

        btn_record_graph.setOnClickListener(view -> {
            Intent record_graph = new Intent(ResultActivity.this, RecordGradeGraphActivity.class);
            startActivity(record_graph);
        });

        ParseQuery<ParseObject> total_query = ParseQuery.getQuery("grade");
        total_query.findInBackground(new FindCallback<ParseObject>() {
            @SuppressLint("SetTextI18n")
            public void done(List<ParseObject> list, ParseException e) {
                if(e == null) {
                    sum_total.append("결과" + "\n");
                    for(int i = 0; i < list.size(); i++) {
                        if (list.get(i).getInt("inspection_total_grade") == 0) {

                        } else if (list.get(i).getInt("inspection_total_grade") >= 1){
                            inspection_total_grade = list.get(i).getInt("inspection_total_grade");
                        }

                        if (list.get(i).getInt("wake_up_grade") == 0) {

                        } else if (list.get(i).getInt("wake_up_grade") >= 1) {
                            wake_up_grade = list.get(i).getInt("wake_up_grade");
                        }

                        if (list.get(i).getInt("sleeping_time_grade") == 0) {

                        } else if (list.get(i).getInt("sleeping_time_grade") >= 1) {
                            sleeping_time_grade = list.get(i).getInt("sleeping_time_grade");
                        }

                        if (list.get(i).getInt("dietary_life_grade") == 0) {

                        } else if (list.get(i).getInt("dietary_life_grade") >= 1) {
                            dietary_life_grade = list.get(i).getInt("dietary_life_grade");
                        }

                        if (list.get(i).getInt("usage_grade") == 0) {

                        } else if (list.get(i).getInt("usage_grade") >= 1) {
                            usage_total_grade = list.get(i).getInt("usage_grade");
                        }

                        if (list.get(i).getInt("behavior_grade") == 0){

                        } else if (list.get(i).getInt("behavior_grade") >= 1){
                            behavior_grade = list.get(i).getInt("behavior_grade");
                        }
                    }
                } else {
                    sum_total.setText("Error: " +e.getMessage());
                }

                total_grade = wake_up_grade + sleeping_time_grade + dietary_life_grade + usage_total_grade + behavior_grade;

                sum_total.append("우울증 진단 테스트 점수 : " + inspection_total_grade +"\n");
                sum_total.append("생활점수 : " + total_grade);

                ParseObject sum_total = new ParseObject("grade");
                sum_total.put("total_grade", total_grade);
                sum_total.saveInBackground();

                ParseObject grade_result = new ParseObject("result");

                if (inspection_total_grade <= 18){
                    if (total_grade <= 9){
                        result.append("지금처럼 꾸준한 자기관리 부탁드려요.");
                        grade_result.put("result", "정상");
                        grade_result.put("solution_1","매우 건강한 상태로 관리와 상담 필요 가능성 낮음");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 14){
                        result.append("시간 나실 때 산책 하시는 걸 추천 드려요.");
                        grade_result.put("result", "정상");
                        grade_result.put("solution_1","건강한 상태로 관리와 상담 필요 가능성 낮음");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 19){
                        result.append("시간 나실 때 운동을 해보시는 게 어떠신가요.");
                        grade_result.put("result", "정상");
                        grade_result.put("solution_1","건강관련 관리자 주의 필요");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 24){
                        result.append("규칙적인 생활과 운동이 필요해요.");
                        grade_result.put("result", "정상");
                        grade_result.put("solution_1","건강관련 관리자 관리감독 필수");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 28){
                        result.append("규칙적인 생활을 할 수 있도록 노력해주세요.");
                        grade_result.put("result", "정상");
                        grade_result.put("solution_1","건강관련 관리자 대면 관리 요청");
                        grade_result.saveInBackground();
                    }
                } else if (inspection_total_grade <= 23){
                    if (total_grade <= 9){
                        result.append("지금처럼 규칙적인 생활을 유지하신다면 우울한 감정 완화에 도움이 되실거예요.");
                        grade_result.put("result", "경미한 우울증");
                        grade_result.put("solution_1","우울증을 조금 보이나  매우 건강한 상태로 관리와 상담 필요가 낮음");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 14){
                        result.append("좋아하는 취미활동을 해보시는 게 어떠신가요.");
                        grade_result.put("result", "경미한 우울증");
                        grade_result.put("solution_1","우울증을 조금 보이나  건강한 상태로 관리와 상담 필요가 낮음");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 19){
                        result.append("친구들을 만나 좋은 시간을 보내시는 걸 추천 드려요.");
                        grade_result.put("result", "경미한 우울증");
                        grade_result.put("solution_1","우울증이 심해질 수 있으므로 건강관련 관리자 주의 필요");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 24){
                        result.append("친구를 만나서 대화를 나누거나 운동을 하거나 좋아하는 취미활동을 해보시는 게 어떠신가요.");
                        grade_result.put("result", "경미한 우울증");
                        grade_result.put("solution_1","우울증이 심해질 수 있으므로 건강관련 관리자 관리감독 필수");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 28){
                        result.append("우울한 감정이 심해졌다고 느껴 지신다면 상담 받으러 와주세요.");
                        grade_result.put("result", "경미한 우울증");
                        grade_result.put("solution_1","우울증이 심해질 수 있으므로 건강관련 관리자 대면 관리 요청");
                        grade_result.saveInBackground();
                    }
                } else if (inspection_total_grade <= 29){
                    if (total_grade <= 9){
                        result.append("마음이 힘들 때는 상담 받아 보시는 건 어떠신가요.");
                        grade_result.put("result", "중한 우울증");
                        grade_result.put("solution_1","규칙적인 생활 중이 우울증 상담치료 필수");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 14){
                        result.append("자주 외롭다고 느껴 지신다면 상담 받으러 오시는 건 어떠신가요.");
                        grade_result.put("result", "중한 우울증");
                        grade_result.put("solution_1","건강한 생활 중이나 우울증 상담치료 필수");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 19){
                        result.append("힘든 일이 있으시다면 속마음을 털어놓을 상담 받으러 와주세요.");
                        grade_result.put("result", "중한 우울증");
                        grade_result.put("solution_1","건강관련 관리자 주의 필요 우울증 상담치료 필수");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 24){
                        result.append("일상생활에서 어려움을 겪고 계시다면 도와 드릴 게요 상담 받으러 와주세요.");
                        grade_result.put("result", "중한 우울증");
                        grade_result.put("solution_1","건강관련 관리자 감독 필수 우울증 상담치료 필수");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 28){
                        result.append("일상생활이 힘들고 우울한 감정이 지속되신다면 도와 드릴 게요 상담 받으러 와주세요.");
                        grade_result.put("result", "중한 우울증");
                        grade_result.put("solution_1","건강관련 관리자 대면 관리 요청 우울증 상담치료 필수");
                        grade_result.saveInBackground();
                    }
                } else if (inspection_total_grade <= 66){
                    if (total_grade <= 9){
                        result.append("우울감이 오랜 시간동안 지속되신다면 상담 받아 보시는 건 어떠신가요.");
                        grade_result.put("result", "심각한 우울증");
                        grade_result.put("solution_1","규칙적인 생활 중이나 심각한 우울증 상태로 관리자 감독이 필요하고 상담치료 필수");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 14){
                        result.append("가족이나 친구들을 자주 만나도 외로움이 느껴 지신다면 상담 받으러 오시는 건 어떠신가요.");
                        grade_result.put("result", "심각한 우울증");
                        grade_result.put("solution_1","건강한 생활 중이나 심각한 우울증 상태로 관리자 감독이 필요하고 상담치료 필수");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 19){
                        result.append("혼자 있는 시간이 많고 힘드시다면 상담 받으러 오시는 건 어떠신가요.");
                        grade_result.put("result", "심각한 우울증");
                        grade_result.put("solution_1","건강관련 관리자 주의 필요 심각한 우울증 상태로 우울증 상담치료 필수");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 24){
                        result.append("무기력하고 쉽게 잠을 이루지 못하거나 과도하게 많이 자고 계시다면 도와드릴 게요 상담 받으러 와주세요.");
                        grade_result.put("result", "심각한 우울증");
                        grade_result.put("solution_1","건강관련 관리자 감독 필수 심각한 우울증 상태로 우울증 상담치료 필수");
                        grade_result.saveInBackground();
                    } else if (total_grade <= 28){
                        result.append("모든 게 힘드시죠 도움 드릴 수 있게 상담 받으러 와주세요.");
                        grade_result.put("result", "심각한 우울증");
                        grade_result.put("solution_1","건강관련 관리자 대면 관리 요청 심각한 우울증 상태로 우울증 상담치료 필수");
                        grade_result.saveInBackground();
                    }
                }
            }
        });

        ParseQuery<ParseObject> average_query = ParseQuery.getQuery("total");
        average_query.findInBackground(new FindCallback<ParseObject>() {
            @SuppressLint("SetTextI18n")
            public void done(List<ParseObject> list, ParseException e) {
                if(e == null) {
                    for (int i = 0; i < list.size(); i++) {

                        if (list.get(i).getInt("phone_usage") == 0) {

                        } else if (list.get(i).getInt("phone_usage") >= 1) {
                            phone_usage = list.get(i).getInt("phone_usage");
                            phone.setText("스마트폰 사용시간 : " + phone_usage);
                        }

                        if (list.get(i).getInt("usage_average") == 0) {

                        } else if (list.get(i).getInt("usage_average") >= 1) {
                            usage_average = list.get(i).getInt("usage_average");
                            phone_avr.setText("스마트폰 평균 사용시간 : " + usage_average );
                        }

                        if (list.get(i).getInt("Sleeping_Time") == 0) {

                        } else if (list.get(i).getInt("Sleeping_Time") >= 1) {
                            sleep = list.get(i).getInt("Sleeping_Time");
                            sleeping.setText("수면시간 : " + sleep);
                        }

                        if (list.get(i).getInt("sleep_average") == 0) {

                        } else if (list.get(i).getInt("sleep_average") >= 1) {
                            sleep_average = list.get(i).getInt("sleep_average");
                            sleeping_avr.setText("평균 수면시간 : " + sleep_average);
                        }
                    }
                } else {
                    sleep_usage_result.setText("Error: " + e.getMessage());
                }

                phone_result = (phone_usage - usage_average);
                sleep_result = (sleep - sleep_average);

                ParseObject time_result = new ParseObject("result");

                if (phone_result >= 2) { // 스마트폰 사용 증가
                    if (sleep_result >= 2) { // 수면시간 증가
                        sleep_usage_result.append("과도한 스마트폰 사용과 수면으로 일상생활에 문제가 있는걸로 의심됨");
                        time_result.put("solution_2", "과도한 스마트폰 사용과 수면으로 일상생활에 문제가 있는걸로 의심됨");
                        time_result.saveInBackground();
                    } else if (sleep_result <= -2) { // 수면 시간 감소
                        sleep_usage_result.append("스마트폰 중독이 의심됨(전문가와 상담필요)");
                        time_result.put("solution_2","스마트폰 중독이 의심됨(전문가와 상담필요)");
                        time_result.saveInBackground();
                    } else { // 수면시간 보통
                        sleep_usage_result.append("스마트폰 사용을 줄이고 일상생활에 집중해야 함");
                        time_result.put("solution_2","스마트폰 사용을 줄이고 일상생활에 집중해야 함");
                        time_result.saveInBackground();
                    }
                } else if (phone_result <= -2) { // 스마트폰 사용 감소
                    if (sleep_result >= 2) { // 수면시간 증가
                        sleep_usage_result.append("과도한 수면으로 우울한 상태일수도 있음");
                        time_result.put("solution_2","과도한 수면으로 우울한 상태일수도 있음");
                        time_result.saveInBackground();
                    } else if (sleep_result <= -2) { // 수면 시간 감소
                        sleep_usage_result.append("일상생활에 문제가 있는걸로 의심됨");
                        time_result.put("solution_2","일상생활에 문제가 있는걸로 의심됨");
                        time_result.saveInBackground();
                    } else { // 수면시간 보통
                        sleep_usage_result.append("긍정적인 생활을 하는 것으로 보임");
                        time_result.put("solution_2","긍정적인 생활을 하는 것으로 보임");
                        time_result.saveInBackground();
                    }
                } else { // 스마트폰 사용 보통
                    if (sleep_result >= 2) { // 수면시간 증가
                        sleep_usage_result.append("적절한 수면이 요구됨");
                        time_result.put("solution_2","적절한 수면이 요구됨");
                        time_result.saveInBackground();
                    } else if (sleep_result <= -2) { // 수면 시간 감소
                        sleep_usage_result.append("충분한 수면이 요구됨");
                        time_result.put("solution_2","충분한 수면이 요구됨");
                        time_result.saveInBackground();
                    } else { // 수면시간 보통
                        sleep_usage_result.append("긍정적인 생활을 하는것으로 보임");
                        time_result.put("solution_2","긍정적인 생활을 하는것으로 보임");
                        time_result.saveInBackground();
                    }
                }
            }
        });

    }
}
