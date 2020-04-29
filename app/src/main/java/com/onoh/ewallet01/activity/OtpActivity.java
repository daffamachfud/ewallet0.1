package com.onoh.ewallet01.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.onoh.ewallet01.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.pinView) PinView pinview;
    @BindView(R.id.btn_next_otp) Button btn_next_otp;
    private String data_et_email, data_et_nomor_telepon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        ButterKnife.bind(this);
        btn_next_otp.setOnClickListener(this);

        //menerima data dari intent register activity
        if(getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            data_et_email = bundle.getString("dataEmail");
            data_et_nomor_telepon = bundle.getString("dataNomorTelepon");
        }else{
            data_et_email = getIntent().getStringExtra("dataEmail");
            data_et_nomor_telepon = getIntent().getStringExtra("dataNomorTelepon");
        }
    }

    @Override
    public void onClick(View view) {
        String otp = Objects.requireNonNull(pinview.getText()).toString();
        String valueyangbener = "1234";
        if(otp.equals(valueyangbener)){
            Toast.makeText(OtpActivity.this, data_et_email + data_et_nomor_telepon, Toast.LENGTH_LONG).show();
            Toast.makeText(OtpActivity.this, "Bener OTP NYA", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(OtpActivity.this, "Salah BRO!", Toast.LENGTH_SHORT).show();
        }

        Intent intentOtpBerhasil = new Intent(OtpActivity.this,PinActivity.class);
        startActivity(intentOtpBerhasil);


    }



}
