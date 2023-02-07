package com.example.Time;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.example.home.Time.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class now_behavior extends HomeActivity{

    private TextView now;
    private int pattern_count;
    private String pattern;

    ImageView imageView;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) { // savedInstanceState 으로 변경된 값 유지
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now);
    }

    protected void onStart() {
        super.onStart();
        now = (TextView)findViewById(R.id.now_behavior);
        imageView = (ImageView)findViewById(R.id.imageview);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("act_compare_count");
        query.addAscendingOrder("updatedAt");
        query.findInBackground(new FindCallback<ParseObject>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void done(List<ParseObject> list, ParseException e) {

                if (list.isEmpty()) {
                    pattern_count = 0;
                    pattern = "unknown";
                }
                else if(e == null) {
                    for(int i = 0; i < list.size(); i++) {
                        if(list.get(i).getInt("sit") > list.get(i).getInt("walk") && list.get(i).getInt("sit") > list.get(i).getInt("run")) {
                            pattern_count = list.get(i).getInt("sit");
                            pattern = "sit";
                            Glide.with(imageView).load(R.drawable.siti).into(imageView);
                            if(list.get(i).getInt("walk") > list.get(i).getInt("run") && list.get(i).getInt("walk") > list.get(i).getInt("sit")) {
                                pattern_count = list.get(i).getInt("walk");
                                pattern = "walk";
                                Glide.with(imageView).load(R.drawable.walki).into(imageView);
                                    if (list.get(i).getInt("run") > list.get(i).getInt("sit") && list.get(i).getInt("run") > list.get(i).getInt("walk")) {
                                        pattern_count = list.get(i).getInt("run");
                                        pattern = "run";
                                        Glide.with(imageView).load(R.drawable.runi).into(imageView);
                                    }
                                }
                            }
                        else if(list.get(i).getInt("walk") > list.get(i).getInt("run") && list.get(i).getInt("walk") > list.get(i).getInt("sit")) {
                            pattern_count = list.get(i).getInt("walk");
                            pattern = "walk";
                            Glide.with(imageView).load(R.drawable.walki).into(imageView);
                            if (list.get(i).getInt("run") > list.get(i).getInt("walk") && list.get(i).getInt("run") > list.get(i).getInt("sit")) {
                                pattern_count = list.get(i).getInt("exercise");
                                pattern = "run";
                                Glide.with(imageView).load(R.drawable.runi).into(imageView);
                                if(list.get(i).getInt("sit") > list.get(i).getInt("run") && list.get(i).getInt("sit") > list.get(i).getInt("walk")) {
                                    pattern_count = list.get(i).getInt("sit");
                                    pattern = "sit";
                                    Glide.with(imageView).load(R.drawable.siti).into(imageView);
                                }
                            }
                        }
                        else if(list.get(i).getInt("run") > list.get(i).getInt("sit") && list.get(i).getInt("run") > list.get(i).getInt("walk")) {
                            pattern_count = list.get(i).getInt("run");
                            pattern = "run";
                            Glide.with(imageView).load(R.drawable.runi).into(imageView);
                            if(list.get(i).getInt("sit") > list.get(i).getInt("run") && list.get(i).getInt("sit") > list.get(i).getInt("walk")) {
                                pattern_count = list.get(i).getInt("sit");
                                pattern = "sit";
                                Glide.with(imageView).load(R.drawable.siti).into(imageView);
                                if (list.get(i).getInt("walk") > list.get(i).getInt("run") && list.get(i).getInt("walk") > list.get(i).getInt("sit")) {
                                    pattern_count = list.get(i).getInt("walk");
                                    pattern = "walk";
                                    Glide.with(imageView).load(R.drawable.walki).into(imageView);
                                }
                            }
                        }
                    }
                } else {
                    now.append("Error: " + e.getMessage());
                }

            }
        });
    }
}
