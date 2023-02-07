package com.example.Time;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Time.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    EditText edName, edNumber, edBirth, edAddress,edAddress2;
    private Handler handler;
    private static final int SEARCH_ADDRESS_ACTIVITY = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edNumber = findViewById(R.id.edNumber);
        edName = findViewById(R.id.edName);
        edBirth = findViewById(R.id.edBirth);
        edAddress = findViewById(R.id.edAddress);
        edAddress2 = findViewById(R.id.edAddress2);

    // 주소입력창 클릭
    edAddress = findViewById(R.id.edAddress);
        edAddress.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i("주소설정페이지", "주소입력창 클릭");
            int status = NetworkStatus.getConnectivityStatus(getApplicationContext());
            if (status == NetworkStatus.TYPE_MOBILE || status == NetworkStatus.TYPE_WIFI) {

                Log.i("주소설정페이지", "주소입력창 클릭");
                Intent i = new Intent(getApplicationContext(), AddressApiActivity.class);
                // 화면전환 애니메이션 없애기
                overridePendingTransition(0, 0);
                // 주소결과
                startActivityForResult(i, SEARCH_ADDRESS_ACTIVITY);

            } else {
                Toast.makeText(getApplicationContext(), "인터넷 연결을 확인해주세요.", Toast.LENGTH_SHORT).show();
            }


        }
    });

}

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Log.i("test", "onActivityResult");

        switch (requestCode) {
            case SEARCH_ADDRESS_ACTIVITY:
                if (resultCode == RESULT_OK) {
                    String data = intent.getExtras().getString("data");
                    if (data != null) {
                        Log.i("test", "data:" + data);
                        edAddress.setText(data);
                    }
                }
                break;
        }
    }
    public void signup(View view) {


        if( TextUtils.isEmpty(edNumber.getText())){
            edNumber.setError( "전화번호를 작성해주세요."  );
        }else if( TextUtils.isEmpty(edBirth.getText())) {
            edBirth.setError("생년월일을 작성해주세요.");
        }else if( TextUtils.isEmpty(edName.getText())) {
            edName.setError("이름을 작성해주세요.");
        }else if( TextUtils.isEmpty(edAddress.getText())) {
                edAddress.setError("주소를 작성해주세요.");
        }else{

            final ProgressDialog progress = new ProgressDialog(this);
            progress.setMessage("Loading ...");
            progress.show();
            ParseUser user = new ParseUser();
            user.setUsername(edNumber.getText().toString());
            user.setPassword(edBirth.getText().toString());
            user.put("name",edName.getText().toString());
            user.put("address",edAddress.getText().toString());
            user.put("address2",edAddress2.getText().toString());
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    progress.dismiss();
                    if (e == null) {
                        Toast.makeText(SignupActivity.this, "안녕하세요!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        ParseUser.logOut();
                        Toast.makeText(SignupActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
