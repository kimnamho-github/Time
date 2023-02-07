package com.example.Time;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.home.Time.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

public class ResetPasswordActivity extends AppCompatActivity {

    EditText edNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        edNumber = (EditText) findViewById(R.id.edNumber);
    }

    public void resetPassword(View view) {
        if( TextUtils.isEmpty(edNumber.getText())){
            edNumber.setError( "Number is required!" );
        }else {
            ParseUser.requestPasswordResetInBackground(edNumber.getText().toString(), new RequestPasswordResetCallback() {
                public void done(ParseException e) {
                    if (e == null) {
                        // An Number was successfully sent with reset instructions.
                        Toast.makeText(ResetPasswordActivity.this, "An Number was successfully sent with reset instructions.", Toast.LENGTH_LONG).show();
                    } else {
                        // Something went wrong. Look at the ParseException to see what's up.
                        Toast.makeText(ResetPasswordActivity.this, "Something went wrong. Look at the ParseException to see what's up.", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
