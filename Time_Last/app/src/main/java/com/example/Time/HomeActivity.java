package com.example.Time;

import com.example.home.Time.R;
import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telecom.Call;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int REQUEST_CALL = 1;

    GestureDetector gd;
    GestureDetector.OnDoubleTapListener listener;
    LinearLayout layout_home;
    private String mNum;
    final int CLICK_DELAY = 200;

    //????????? ??????
    int run = 0;
    int walk = 0;
    int sit = 0;
    int maxw = 0;
    int maxr = 0;
    int maxs = 0;

    //1?????? ??????
    int runh = 0;
    int walkh = 0;
    int sith = 0;
    int maxrh = 0;
    int maxwh = 0;
    int maxsh = 0;

    //1?????? ??????
    int runb = 0;
    int walkb = 0;
    int sitb = 0;
    int maxrb = 0;
    int maxwb = 0;
    int maxsb = 0;


    private SensorManager sm;
    private Sensor accelSensor;
    private Sensor gyroSensor;
    private SensorEventListener accelListener;
    private SensorEventListener gyroListener;

    float ax;
    float ay;
    float az;

    private int delay = SensorManager.SENSOR_DELAY_NORMAL;
    private LinkedList<Storage> xyz_list;
    private LinkedList<Store> accelList;
    private LinkedList<Store> gyroList;

    public class Storage {

        private Store accel;
        private Store gyro;

        Storage(Store accel, Store gyro) {
            this.accel = accel; // ????????? ?????? ???
            this.gyro = gyro; // ????????? ?????? ???
        }

        @Override
        public String toString() { // ?????? ?????? String ??? ?????? ??????
            return accel.toString() + "," + gyro.toString() + "\n"; // ?????????, ????????? ????????? ????????? ??? ??????
        }
    }

    class Store {
        public String x;
        public String y;
        public String z;
        public String ts;


        Store(float x, float y, float z, long ts) {
            this.x = String.valueOf(x); // x?????? ???
            this.y = String.valueOf(y); // y?????? ???
            this.z = String.valueOf(z); // z?????? ???
            this.ts = String.valueOf(ts); // ?????? ?????????
        }

        @Override
        public String toString() {
            return x + "," + y + "," + z + "," + ts; // x, y, z ?????? ????????? ?????? ??????, ????????? ?????? ???, ??????????????? ??????

        }
    }

    public class AccelListener implements SensorEventListener {
        @SuppressLint("SetTextI18n")
        @Override // ????????? ?????? ?????? ???????????? ??????
        public void onSensorChanged(SensorEvent event) {


            ax = event.values[0];
            ay = event.values[1];
            az = event.values[2];

            accelList.add(new Store(ax, ay, az, event.timestamp));
        }

        @Override // ????????? ?????? ???????????? ???????????? ??????
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }


    public class GyroListener extends AccelListener {

        @RequiresApi(api = Build.VERSION_CODES.O)
        @SuppressLint("SetTextI18n")
        @Override // ????????? ?????? ?????? ???????????? ??????
        public void onSensorChanged(SensorEvent event) {

            gyroList.add(new Store(event.values[0], event.values[1], event.values[2], event.timestamp));

            if(ay <= 0.033788) {
                if(ay <= -0.037392) {
                    if(ax <= 5.07554) {
                        if(ax <= -5.712936) {
                            if(ay <= -0.695654) {
                                run+=1;
                                runb+=1;
                                runh+=1;
                            } else if(ay > -0.685654) {
                                if(ax <= -8.078699) {
                                    run+=1;
                                    runb+=1;
                                    runh+=1;
                                } else if(ax > -8.078699) {
                                    if(event.values[2] <= 0.212813) {
                                        walk+=1;
                                        walkb+=1;
                                        walkh+=1;
                                    } else if(event.values[2] > 0.212813) {
                                        run+=1;
                                        runb+=1;
                                        runh+=1;
                                    }
                                }
                            }
                        } else if(ax > -5.712936) {
                            if(event.values[0] <= -0.801541) {
                                if(ay <= -1.594698) {
                                    run+=1;
                                    runb+=1;
                                    runh+=1;
                                } else if(ay > -1.594698) {
                                    if(event.values[1] <= -0.189362) {
                                        run+=1;
                                        runb+=1;
                                        runh+=1;
                                    } else if(event.values[1] > -0.189362) {
                                        run+=1;
                                        runb+=1;
                                        runh+=1;
                                    }
                                }
                            } else if(event.values[0] > -0.801541) {
                                if(event.values[0] <= 0.74517) {
                                    if(event.values[1] <= -0.769073) {
                                        if(ax <= -2.573093) {
                                            run+=1;
                                            runb+=1;
                                            runh+=1;
                                        } else if(ax > -2.573093) {
                                            if(ax <= 3.028117) {
                                                if(event.values[1] <= -1.087945) {
                                                    run+=1;
                                                    runb+=1;
                                                    runh+=1;
                                                } else if(event.values[1] > -1.087945) {
                                                    walk+=1;
                                                    walkb+=1;
                                                    walkh+=1;
                                                }
                                            } else if(ax > 3.028117) {
                                                run+=1;
                                                runb+=1;
                                                runh+=1;
                                            }
                                        }
                                    } else if(event.values[1] > -0.769073) {
                                        if(event.values[1] <= 0.589491) {
                                            if(event.values[0] <= 0.028014) {
                                                if(az <= -3.840269) {
                                                    if(event.values[0] <= -0.128367) {
                                                        run+=1;
                                                        runb+=1;
                                                        runh+=1;
                                                    } else if(event.values[0] > -0.128367) {
                                                        if(ax <= 3.153022) {
                                                            walk+=1;
                                                            walkb+=1;
                                                            walkh+=1;
                                                        } else if (ax > 3.153022) {
                                                            run+=1;
                                                            runb+=1;
                                                            runh+=1;
                                                        }
                                                    }
                                                } else if(az > -3.840269) {
                                                    if(event.values[2] <= 0.040549) {
                                                        if(ax <= -0.616435) {
                                                            if(ax <= -1.195738) {
                                                                walk+=1;
                                                                walkb+=1;
                                                                walkh+=1;
                                                            } else if(ax >-1.195738) {
                                                                run+=1;
                                                                runb+=1;
                                                                runh+=1;
                                                            }
                                                        } else if(ax > -0.616435) {
                                                            if(event.values[1] <= 0.340258) {
                                                                if(az <= -0.806128) {
                                                                    if(event.values[2] <= -0.170199) {
                                                                        walk+=1;
                                                                        walkb+=1;
                                                                        walkh+=1;
                                                                    } else if(event.values[2] > -0.170199) {
                                                                        if(ax <= 1.748029) {
                                                                            if(az <= -1.37339) {
                                                                                walk+=1;
                                                                                walkb+=1;
                                                                                walkh+=1;
                                                                            } else if(az > -1.37339) {
                                                                                run+=1;
                                                                                runb+=1;
                                                                                runh+=1;
                                                                            }
                                                                        } else if(ax > 1.748029) {
                                                                            run+=1;
                                                                            runb+=1;
                                                                            runh+=1;
                                                                        }
                                                                    }
                                                                } else if(az > -0.806128) {
                                                                    walk+=1;
                                                                    walkb+=1;
                                                                    walkh+=1;
                                                                }
                                                            } else if(event.values[1] > 0.340258) {
                                                                run+=1;
                                                                runb+=1;
                                                                runh+=1;
                                                            }
                                                        }
                                                    } else if(event.values[2] > 0.040549) {
                                                        if(ax <= -1.869319) {
                                                            if(az <= 2.364178) {
                                                                walk+=1;
                                                                walkb+=1;
                                                                walkh+=1;
                                                            } else if(az > 2.364178) {
                                                                if(ay <= -2.651226) {
                                                                    walk+=1;
                                                                    walkb+=1;
                                                                    walkh+=1;
                                                                } else if(ay > -2.651226) {
                                                                    run+=1;
                                                                    runb+=1;
                                                                    runh+=1;
                                                                }
                                                            }
                                                        } else if(ax > -1.869319) {
                                                            walk+=1;
                                                            walkb+=1;
                                                            walkh+=1;
                                                        }
                                                    }
                                                }
                                            } else if(event.values[0] > 0.028014) {
                                                if(ax <= -2.084503) {
                                                    if(event.values[1] <= -0.12461) {
                                                        if(event.values[2] <= 0.141953) {
                                                            run+=1;
                                                            runb+=1;
                                                            runh+=1;
                                                        } else if(event.values[2] > 0.141953) {
                                                            if(ay <= -1.174155) {
                                                                run+=1;
                                                                runb+=1;
                                                                runh+=1;
                                                            } else if(ay > -1.174155) {
                                                                walk+=1;
                                                                walkb+=1;
                                                                walkh+=1;
                                                            }
                                                        }
                                                    } else if(event.values[1] > -0.12461) {
                                                        walk+=1;
                                                        walkb+=1;
                                                        walkh+=1;
                                                    }
                                                } else if(ax > -2.084503) {
                                                    walk+=1;
                                                    walkb+=1;
                                                    walkh+=1;
                                                }
                                            }
                                        } else if(event.values[1] > 0.589491) {
                                            if(az <= -1.132436) {
                                                if(event.values[0] <= 0.344442) {
                                                    run+=1;
                                                    runb+=1;
                                                    runh+=1;
                                                } else if(event.values[0] > 0.344442) {
                                                    walk+=1;
                                                    walkb+=1;
                                                    walkh+=1;
                                                }
                                            } else if(az > -1.132436) {
                                                if(event.values[1] <= 1.205243) {
                                                    walk+=1;
                                                    walkb+=1;
                                                    walkh+=1;
                                                } else if(event.values[1] > 1.205243) {
                                                    run+=1;
                                                    runb+=1;
                                                    runh+=1;
                                                }
                                            }
                                        }
                                    }
                                } else if(event.values[0] > 0.74517) {
                                    if(event.values[2] <= -0.241671) {
                                        if(event.values[1] <= -0.42491) {
                                            run+=1;
                                            runb+=1;
                                            runh+=1;
                                        } else if(event.values[1] > -0.42491) {
                                            walk+=1;
                                            walkb+=1;
                                            walkh+=1;
                                        }
                                    } else if(event.values[2] > -0.241671) {
                                        run+=1;
                                        runb+=1;
                                        runh+=1;
                                    }
                                }
                            }
                        }
                    } else if(ax > 5.07554) {
                        run+=1;
                        runb+=1;
                        runh+=1;
                    }
                } else if(ay > -0.037392) {
                    if(az <= -0.038889) {
                        if(event.values[1] <= -0.469138) {
                            run+=1;
                            runb+=1;
                            runh+=1;
                        } else if(event.values[1] > -0.469138) {
                            if(event.values[0] <= 0.006023) {
                                walk+=1;
                                walkb+=1;
                                walkh+=1;
                            } else if(event.values[0] > 0.006023) {
                                if(ax <= 1.889138) {
                                    run+=1;
                                    runb+=1;
                                    runh+=1;
                                } else if(ax > 1.889138) {
                                    walk+=1;
                                    walkb+=1;
                                    walkh+=1;
                                }
                            }
                        }
                    } else if(az > -0.038889) {
                        if(az <= 0.083477) {
                            sit+=1;
                            sitb+=1;
                            sith+=1;
                        } else if(az > 0.083477) {
                            if(az <= 0.133154) {
                                sit+=1;
                                sitb+=1;
                                sith+=1;
                            } else if(az > 0.133154) {
                                walk+=1;
                                walkb+=1;
                                walkh+=1;
                            }
                        }
                    }
                }
            }
            else if(ay > 0.033788) {
                if(event.values[1] <= -1.038465) {
                    if(ax <= 1.073692) {
                        run+=1;
                        runb+=1;
                        runh+=1;
                    } else if(ax > 1.073692) {
                        if(ax <= 3.581941) {
                            if(event.values[1] <= -1.439803) {
                                run+=1;
                                runb+=1;
                                runh+=1;
                            } else if(event.values[1] > -1.439803) {
                                walk+=1;
                                walkb+=1;
                                walkh+=1;
                            }
                        } else if(ax > 3.581941) {
                            run+=1;
                            runb+=1;
                            runh+=1;
                        }
                    }
                }
                else if(event.values[1] > -1.038465) {
                    if(event.values[1] <= 1.029314) {
                        if(ax <= -8.56573) {
                            if(event.values[0] <= -0.279862) {
                                if(event.values[2] <= 0.195098) {
                                    walk+=1;
                                    walkb+=1;
                                    walkh+=1;
                                } else if(event.values[2] > 0.195098) {
                                    run+=1;
                                    runb+=1;
                                    runh+=1;
                                }
                            } else if(event.values[0] > -0.279862) {
                                run+=1;
                                runb+=1;
                                runh+=1;
                            }
                        } else if(ax > -8.56573) {
                            if(ay <= 4.294511) {
                                if(event.values[2] <= -0.559931) {
                                    if(az <= -0.3725995) {
                                        walk+=1;
                                        walkb+=1;
                                        walkh+=1;
                                    } else if(az > -0.372595) {
                                        if(ax <= 3.772116) {
                                            run+=1;
                                            runb+=1;
                                            runh+=1;
                                        } else if(ax > 3.772116) {
                                            walk+=1;
                                            walkb+=1;
                                            walkh+=1;
                                        }
                                    }
                                } else if(event.values[2] > -0.559931) {
                                    if(event.values[0] <= 0.622386) {
                                        if(event.values[2] <= 0.462657) {
                                            walk+=1;
                                            walkb+=1;
                                            walkh+=1;
                                        } else if(event.values[2] > 0.462657) {
                                            if(event.values[2] <= 0.583608) {
                                                if(event.values[0] <= -0.839414) {
                                                    run+=1;
                                                    runb+=1;
                                                    runh+=1;
                                                } else if(event.values[0] > -0.839414) {
                                                    if(ay <= 3.027811) {
                                                        walk+=1;
                                                        walkb+=1;
                                                        walkh+=1;
                                                    } else if(ay > 3.027811) {
                                                        run+=1;
                                                        runb+=1;
                                                        runh+=1;
                                                    }
                                                }
                                            } else if(event.values[2] > 0.583608) {
                                                run+=1;
                                                runb+=1;
                                                runh+=1;
                                            }
                                        }
                                    } else if(event.values[0] > 0.622386) {
                                        if(az <= -1.110328) {
                                            run+=1;
                                            runb+=1;
                                            runh+=1;
                                        } else if(az > -1.110328) {
                                            walk+=1;
                                            walkb+=1;
                                            walkh+=1;
                                        }
                                    }
                                }
                            } else if(ay > 4.294511) {
                                if(ay <= 4.779167) {
                                    if(ax <= 1.061059) {
                                        run+=1;
                                        runb+=1;
                                        runh+=1;
                                    } else if(ax > 1.061059) {
                                        walk+=1;
                                        walkb+=1;
                                        walkh+=1;
                                    }
                                } else if(ay > 4.779167) {
                                    run+=1;
                                    runb+=1;
                                    runh+=1;
                                }
                            }
                        }
                    } else if(event.values[1] > 1.029314) {
                        run+=1;
                        runb+=1;
                        runh+=1;
                    }
                }
            }

            maxr = run;
            maxs = sit;
            maxw = walk;

            maxrb = runb;
            maxsb = sitb;
            maxwb = walkb;

            maxrh = runh;
            maxsh = sith;
            maxwh = walkh;
        }

        @Override // ????????? ?????? ???????????? ???????????? ??????
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler(){
        @Override public void handleMessage(Message msg) { //???????????? ??????????????? ????????? String?????? ???????????????.
            String tab = msg.getData().getString("click"); //Textview??? ???????????? ???????????????.

        }
    };
    TextView tvName, tvEmail;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ParseUser currentUser = ParseUser.getCurrentUser();
        layout_home = (LinearLayout) findViewById(R.id.layout_home);

        this.loadStatistics();

        accelListener = new AccelListener(); // ????????? ?????? ?????? ??????
        gyroListener = new GyroListener(); // ????????? ?????? ?????? ??????

        xyz_list = new LinkedList<Storage>();
        accelList = new LinkedList<Store>();
        gyroList = new LinkedList<Store>();

        sm = (SensorManager) getSystemService(SENSOR_SERVICE); // SensorManager ??????????????? ?????????
        accelSensor = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION); // ????????? ?????? ??????????????? ?????????

        gyroSensor = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE); // ????????? ?????? ??????????????? ?????????

        sm.registerListener(accelListener, accelSensor, delay);
        sm.registerListener(gyroListener, gyroSensor, delay);

        Toast.makeText(HomeActivity.this, "?????? ?????? ??????", Toast.LENGTH_SHORT).show();

        gd = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {

                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return false;
            }
        }
        );
        listener = new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {

                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {

                String tel = "tel:119";

                ParseObject call = new ParseObject("CALL");
                call.put("call", "??????");
                call.saveInBackground();

                startActivity(new Intent("android.intent.action.DIAL", Uri.parse(tel)));
                return true;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                return false;
            }


        };
        gd.setOnDoubleTapListener(listener);
        layout_home.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(gd != null){ gd.onTouchEvent(event);
                    return true;
                }
                return false;
            }
        });
        tvName = (TextView) findViewById(R.id.tvName);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        if (currentUser != null) {
            tvName.setText(currentUser.getString("name"));
            tvEmail.setText(currentUser.getString("username"));
        }


        Button btn_record = findViewById(R.id.btn_record);
        Button btn_usage = findViewById(R.id.btn_usage);
        Button btn_now= findViewById(R.id.btn_now);
        Button btn_test = findViewById(R.id.btn_test);
        Button btn_sum_grade = findViewById(R.id.btn_sum_grade);

        btn_record.setOnClickListener(view -> {
            Intent record = new Intent(HomeActivity.this, Record_Activity.class);
            startActivity(record);
        });


        btn_usage.setOnClickListener(view -> {
            Intent usage = new Intent(HomeActivity.this, Usage_Activity.class);
            startActivity(usage);
        });


        btn_test.setOnClickListener(view -> {
            Intent test = new Intent(HomeActivity.this, FirstActivity.class);
            startActivity(test);
        });

        btn_now.setOnClickListener(view -> {
            Intent now = new Intent(HomeActivity.this, now_behavior.class);
            startActivity(now);
        });


        btn_sum_grade.setOnClickListener(view -> {
            Intent result = new Intent(HomeActivity.this, SumGradeActivity.class);
            startActivity(result);
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            ProgressDialog progress = new ProgressDialog(this);
            progress.setMessage("Loading ...");
            progress.show();
            ParseUser.logOut();
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            progress.dismiss();
        });

        final Handler handler = new Handler(Looper.getMainLooper());
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    handler.postDelayed(this, 1000*10); // 10?????????
                    ParseObject a = new ParseObject("act_compare_count");
                    a.getUpdatedAt();
                    a.put("walk", maxw);
                    a.put("sit", maxs);
                    a.put("run", maxr);
                    a.saveInBackground();
                    run = 0;
                    walk = 0;
                    sit = 0;
                    maxw = 0;
                    maxs = 0;
                    maxr = 0;
                }
            }, 0, 1000*10);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    handler.postDelayed(this, 1000*60*5); // 5?????????
                    ParseObject b = new ParseObject("behavior");
                    b.getUpdatedAt();
                    if(maxrb > maxsb && maxrb > maxwb) {
                        b.put("behavior", "Exercising");
                        if(maxsb > maxrb && maxsb > maxwb) {
                            b.put("behavior", "Rest");
                            if(maxwb > maxrb && maxwb > maxsb) {
                                b.put("behavior", "Take a walk");
                            }
                        }
                    } else if(maxsb > maxrb && maxsb > maxwb) {
                        b.put("behavior", "Rest");
                        if(maxwb > maxrb && maxwb > maxsb) {
                            b.put("behavior", "Take a walk");
                            if(maxrb > maxsb && maxrb > maxwb) {
                                b.put("behavior", "Exercising");
                            }
                        }
                    } else if(maxwb > maxrb && maxwb > maxsb) {
                        b.put("behavior", "Take a walk");
                        if(maxrb > maxsb && maxrb > maxwb) {
                            b.put("behavior", "Exercising");
                            if(maxsb > maxrb && maxsb > maxwb) {
                                b.put("behavior", "Rest");
                            }
                        }
                    }
                    b.saveInBackground();
                    maxrb = 0;
                    maxsb = 0;
                    maxwb = 0;
                }
            }, 0, 1000*60*5);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    handler.postDelayed(this, 1000 * 60 * 60 * 8); //8??????
                    ParseObject c = new ParseObject("eight_hour_act");
                    c.getUpdatedAt();
                    c.put("walk", maxwh);
                    c.put("sit", maxsh);
                    c.put("run", maxrh);
                    c.saveInBackground();

                    if(maxsh != 0 && maxwh == 0 && maxrh == 0) {
                        showDialog(1);
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                TimerTask task = new TimerTask() {
                                    @Override
                                    public void run() {
                                        CallButton();
                                        removeDialog(1);
                                    }
                                };
                                Timer timer = new Timer();
                                timer.schedule(task, 1000 * 30);
                            }
                        });
                        thread.start();
                    } else {
                        runh = 0;
                        walkh = 0;
                        sith = 0;
                        maxwh = 0;
                        maxsh = 0;
                        maxrh = 0;
                    }
                    runh = 0;
                    walkh = 0;
                    sith = 0;
                    maxwh = 0;
                    maxsh = 0;
                    maxrh = 0;
                }
            }, 0, 1000 * 60 * 60 * 8);
        }
    }

    @Override
    protected void onDestroy() { // ?????? ??????
        super.onDestroy();
        sm.unregisterListener(accelListener); // ????????? ?????? ??????
        sm.unregisterListener(gyroListener); // ????????? ?????? ??????
    }

    @Override
    protected void onPause() { //?????? ????????? ?????? ??????
        super.onPause();
        sm.registerListener(accelListener, accelSensor, delay);
        sm.registerListener(gyroListener, gyroSensor, delay);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(accelListener, accelSensor, delay);
        sm.registerListener(gyroListener, gyroSensor, delay);
    }

    public static class Usage_AppsAdapter extends ArrayAdapter<App> {

        public Usage_AppsAdapter(Context context, ArrayList<App> usageStatDTOArrayList) {
            super(context, 0, usageStatDTOArrayList);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // ??? ????????? ?????? ????????? ?????? ????????????
            App usageStats = getItem(position);

            // ?????? ????????? ?????????????????? ???????????????, ????????? ????????? ????????? ???????????????.
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_usage_apps_adapter, parent, false);
            }

            // ????????? ????????? ?????? ??????
            TextView app_name_tv = convertView.findViewById(R.id.app_name_tv);
            TextView usage_duration_tv =  convertView.findViewById(R.id.usage_duration_tv);
            TextView usage_perc_tv = convertView.findViewById(R.id.usage_perc_tv);
            ImageView icon_img =  convertView.findViewById(R.id.icon_img);
            ProgressBar progressBar = convertView.findViewById(R.id.progressBar);

            // ????????? ????????? ???????????? ????????? ????????? ????????? ?????????
            app_name_tv.setText(usageStats.appName);
            usage_duration_tv.setText(usageStats.usageDuration);
            usage_perc_tv.setText(usageStats.usagePercentage + "%");
            icon_img.setImageDrawable(usageStats.appIcon);
            progressBar.setProgress(usageStats.usagePercentage);

            // ????????? ???????????? ????????? ?????? ??????
            return convertView;
        }
    }

    /**
     * ?????? ????????? ????????? ?????? ????????? ???????????????.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void loadStatistics() {
        UsageStatsManager usm = (UsageStatsManager) this.getSystemService(USAGE_STATS_SERVICE);
        List<UsageStats> appList = usm.queryUsageStats(UsageStatsManager.INTERVAL_DAILY,  System.currentTimeMillis() - 1000*3600*24*7,  System.currentTimeMillis());
        appList = appList.stream().filter(app -> app.getTotalTimeInForeground() > 0).collect(Collectors.toList());

        // usageStats??? ???????????????????????? ??????????????? ?????????????????? ??? ???????????? ??????
        if (appList.size() > 0) {
            Map<String, UsageStats> mySortedMap = new TreeMap<>();
            for (UsageStats usageStats : appList) {
                mySortedMap.put(usageStats.getPackageName(), usageStats);
            }
            showAppsUsage(mySortedMap);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void showAppsUsage(Map<String, UsageStats> mySortedMap) {
        //public void showAppsUsage(List<UsageStats> usageStatsList) {
        ArrayList<App> appsList = new ArrayList<>();
        List<UsageStats> usageStatsList = new ArrayList<>(mySortedMap.values());

        // ?????? ??????????????? ????????????????????? ?????? ????????? ?????? ??????
        Collections.sort(usageStatsList, (z1, z2) -> Long.compare(z1.getTotalTimeInForeground(), z2.getTotalTimeInForeground()));

        // ??? ?????? usagePercentage??? ???????????? ?????? ??? ??? ?????? ?????? ????????????
        long totalTime = usageStatsList.stream().map(UsageStats::getTotalTimeInForeground).mapToLong(Long::longValue).sum();

        final Handler total_time_handler = new Handler(Looper.getMainLooper());
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            total_time_handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    total_time_handler.postDelayed(this, 1000*60*60*24*7); // ????????? ??????
                    ParseObject test2 = new ParseObject("phone_usage");
                    test2.put("phone_usage", totalTime / 1000 / 60 / 60);
                    test2.saveInBackground();

                    ParseObject total = new ParseObject("total");
                    total.put("phone_usage", totalTime / 1000 / 60 / 60); // ???????????? ??????
                    total.saveInBackground();
                }
            }, 0, 1000*60*60*24*7);
        }


        //fill the appsList
        for (UsageStats usageStats : usageStatsList) {
            try {
                String packageName = usageStats.getPackageName();
                @SuppressLint("UseCompatLoadingForDrawables") Drawable icon = getDrawable(R.drawable.ic_launcher_background);
                String[] packageNames = packageName.split("\\.");
                String appName = packageNames[packageNames.length-1].trim();

                if(isAppInfoAvailable(usageStats)){
                    ApplicationInfo ai = getApplicationContext().getPackageManager().getApplicationInfo(packageName, 0);
                    icon = getApplicationContext().getPackageManager().getApplicationIcon(ai);
                    appName = getApplicationContext().getPackageManager().getApplicationLabel(ai).toString();
                }

                String usageDuration = getDurationBreakdown(usageStats.getTotalTimeInForeground());
                int usagePercentage = (int) (usageStats.getTotalTimeInForeground() * 100 / totalTime);

                // ????????? ??????
                String Hour = Hour(usageStats.getTotalTimeInForeground());
                String Second = Second(usageStats.getTotalTimeInForeground());

                App usageStatDTO = new App(icon, appName, usagePercentage, usageDuration, Hour, Second);
                appsList.add(usageStatDTO);

                int hour = Integer.parseInt(usageStatDTO.Hour); // ?????????

                final Handler app_usage_handler = new Handler(Looper.getMainLooper());
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    app_usage_handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            app_usage_handler.postDelayed(this, 1000*60*60*24*7); // ????????? ??????
                            ParseObject test = new ParseObject("usage");
                            test.put("appName", usageStatDTO.appName);
                            test.put("time", usageStatDTO.usageDuration);
                            test.put("percentage",usageStatDTO.usagePercentage);
                            test.put("Hour", hour);
                            test.saveInBackground();
                        }
                    }, 0, 1000*60*60*24*7);
                }

            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }

        // ????????? ????????? ?????? ?????? ?????? ?????? ????????? ?????????
        Collections.reverse(appsList);
        // build the adapter
        HomeActivity.Usage_AppsAdapter adapter = new HomeActivity.Usage_AppsAdapter(this, appsList);

        // ???????????? ListView??? ??????
        ListView listView = findViewById(R.id.apps_list);

    }

    /**
     * ?????? ???????????? ????????? ?????? ????????? ????????? ??????????????? ????????? ????????? ?????? ???????????? ?????? ????????? ????????? ??? ????????????.
     * ?????????????????? ????????? ????????? ??? ?????? ?????? true??? ??????
     */
    private boolean isAppInfoAvailable(UsageStats usageStats) {
        try {
            getApplicationContext().getPackageManager().getApplicationInfo(usageStats.getPackageName(), 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }


    /**
     * hh:mm:ss ????????? ???????????? ??????????????? ???????????? ????????? ?????????
     *
     * @param millis (application time in foreground)
     * @return string in format hh:mm:ss from miliseconds
     */
    private String getDurationBreakdown(long millis) {
        if (millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        return (hours + " h " +  minutes + " m " + seconds + " s");
    }

    // ????????? ??????
    private String Hour(long millis){
        if (millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }

        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        return String.valueOf((hours));
    }

    private String Second(long millis){
        if (millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

        return String.valueOf((seconds));
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        ProgressDialog dialog = new ProgressDialog(this); // ??????????????? ????????? ????????????
        dialog.setTitle("???????????????");
        dialog.setMessage("????????? ????????????????????");
        dialog.setButton(ProgressDialog.BUTTON_POSITIVE, "??????",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }
        );
        dialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "????????????",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CallButton();
                    }
                }
        );
        return dialog;
    }

    private void CallButton() {
        String number= "119";//callText.getText().toString()
        if(number.trim().length() > 0) {
            if(ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(HomeActivity.this, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                CallButton();
            } else {
                Toast.makeText(this, "permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

}