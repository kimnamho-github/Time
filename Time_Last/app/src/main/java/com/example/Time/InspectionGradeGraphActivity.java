package com.example.Time;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Time.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InspectionGradeGraphActivity extends AppCompatActivity {

    BarChart barChart; //막대그래프
    private int inspection_total_grade;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection_grade_graph);

        ArrayList<BarEntry> entry_chart = new ArrayList<>(); //데이터를 담을 Arraylist

        barChart = (BarChart) findViewById(R.id.barchart);

        BarData barData = new BarData(); //차트에 담길 데이터

        ParseQuery<ParseObject> total = ParseQuery.getQuery("inspection_total_grade");
        total.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if(e == null) {
                    for(int i = 0; i < list.size(); i++) {
                        if(list.get(i).getInt("inspection_total_grade") == 0) {

                        } else {
                            inspection_total_grade = list.get(i).getInt("inspection_total_grade");
                            entry_chart.add(new BarEntry(i, inspection_total_grade));

                            barData.notifyDataChanged(); //데이터의 값 변동을 감지함
                            barChart.notifyDataSetChanged(); //차트의 값 변동을 감지함
                        }
                    }
                }
                BarDataSet barDataSet = new BarDataSet(entry_chart, "주간 변화 그래프"); //데이터가담긴 Arraylist를 BarDataSet으로 변환
                barDataSet.setColor(Color.BLUE);

                barData.addDataSet(barDataSet); //해당 BarDataSet을 적용될 차트에 들어갈 DataSet에 넣는다.
                barChart.setData(barData);//차트에 위의 DataSet을 넣는다.
                barChart.setVisibleXRangeMaximum(5); // 5개씩 보이게
                barChart.moveViewToX(barData.getEntryCount());
                barChart.invalidate(); //차트 업데이트
                barChart.setTouchEnabled(true); //차트 터치
            }
        });
    }
}