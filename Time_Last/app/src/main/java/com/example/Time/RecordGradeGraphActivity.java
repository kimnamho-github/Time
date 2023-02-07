package com.example.Time;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import com.example.home.Time.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class RecordGradeGraphActivity extends AppCompatActivity {

    private PieChart pieChart;
    private int wake_up_grade, sleeping_time_grade, dietary_life_grade, behavior_grade, usage_grade;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_grade_graph);

        pieChart = (PieChart)findViewById(R.id.piechart);

        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.BLACK);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> entry_chart = new ArrayList<>();

        ParseQuery<ParseObject> grade = ParseQuery.getQuery("grade");
        grade.findInBackground(new FindCallback<ParseObject>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void done(List<ParseObject> list, ParseException e) {
//                entry_chart.remove(wake_up_grade);
                if (e == null) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getInt("wake_up_grade") == 0){

                        }
                        else if (list.get(i).getInt("wake_up_grade") >= 1) {
                            wake_up_grade = list.get(i).getInt("wake_up_grade");
                        }
                        if (list.get(i).getInt("sleeping_time_grade") == 0){

                        }
                        else if (list.get(i).getInt("sleeping_time_grade") >= 1) {
                            sleeping_time_grade = list.get(i).getInt("sleeping_time_grade");
                        }
                        if (list.get(i).getInt("dietary_life_grade") == 0){

                        }
                        else if (list.get(i).getInt("dietary_life_grade") >= 1) {
                            dietary_life_grade = list.get(i).getInt("dietary_life_grade");
                        }
                        if (list.get(i).getInt("behavior_grade") == 0){

                        }
                        else if (list.get(i).getInt("behavior_grade") >= 1) {
                            behavior_grade = list.get(i).getInt("behavior_grade");
                        }
                        if (list.get(i).getInt("usage_grade") == 0){

                        }
                        else if (list.get(i).getInt("usage_grade") >= 1) {
                            usage_grade = list.get(i).getInt("usage_grade");
                        }
                    }
                }

                entry_chart.add(new PieEntry(wake_up_grade, "기상점수"));
                entry_chart.add(new PieEntry(sleeping_time_grade, "수면점수"));
                entry_chart.add(new PieEntry(dietary_life_grade, "생활점수"));
                entry_chart.add(new PieEntry(behavior_grade, "행동점수"));
                entry_chart.add(new PieEntry(usage_grade, "앱사용점수"));

                Description description = new Description();
                description.setText("생활점수");
                description.setTextSize(15);
                pieChart.setDescription(description);

                PieDataSet dataSet = new PieDataSet(entry_chart, "");
                dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

                PieData data = new PieData((dataSet));
                pieChart.setData(data);
                pieChart.animate();
                data.setValueTextSize(16);
                data.setValueTextColor(Color.BLACK);

            }
        });
    }

}