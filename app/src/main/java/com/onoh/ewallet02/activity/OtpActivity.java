package com.onoh.ewallet02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.onoh.ewallet02.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.pinView) PinView pinview;
    @BindView(R.id.btn_next_otp) Button btn_next_otp;
    private String data_nama, data_nomor_telepon,token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        ButterKnife.bind(this);
        btn_next_otp.setOnClickListener(this);


        //menerima data dari intent register activity
        if(getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            data_nama = bundle.getString("result_nama");
            data_nomor_telepon = bundle.getString("result_nomortelepon");
            token = bundle.getString("token");
        }else{
            data_nama = getIntent().getStringExtra("dataEmail");
            data_nomor_telepon = getIntent().getStringExtra("dataNomorTelepon");
            token = getIntent().getStringExtra("result_token");
        }

        Toast.makeText(this, token, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        String otp = Objects.requireNonNull(pinview.getText()).toString();
        String valueyangbener = "1234";
        if(otp.equals(valueyangbener)){
            Toast.makeText(OtpActivity.this, data_nama + data_nomor_telepon+token, Toast.LENGTH_LONG).show();
            Toast.makeText(OtpActivity.this, "Bener OTP NYA", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(OtpActivity.this, "Salah BRO!", Toast.LENGTH_SHORT).show();
        }

//        Intent intentOtpBerhasil = new Intent(OtpActivity.this, PinRegisterActivity.class);
//        startActivity(intentOtpBerhasil);


    }



}
