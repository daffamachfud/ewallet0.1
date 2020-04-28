package com.onoh.ewallet01.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.onoh.ewallet01.R;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    private PinView pinView;
    private Button btn_next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        pinView = (PinView) findViewById(R.id.pinView);
        btn_next = (Button) findViewById(R.id.btn_next_otp);
        btn_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String otp = pinView.getText().toString();
        String valueyangbener = "1234";
        if(otp.equals(valueyangbener)){
            Toast.makeText(OtpActivity.this, "Bener OTP NYA", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(OtpActivity.this, "Salah BRO!", Toast.LENGTH_SHORT).show();
        }
    }
}
