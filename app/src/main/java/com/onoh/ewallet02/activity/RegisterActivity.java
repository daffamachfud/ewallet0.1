package com.onoh.ewallet02.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.onoh.ewallet02.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {
    private String etEmail,etNomorTelepon;
    @BindView(R.id.et_email_daftar)
    TextInputEditText et_email;
    @BindView(R.id.et_nomor_telepon_daftar)
    TextInputEditText et_nomor_telepon;
    @BindView(R.id.btn_daftar)
    Button btn_daftar;
    @BindView(R.id.tv_masuk_disini)
    TextView tvMasuk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daftar();
            }
        });

        tvMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_masuk = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent_masuk);
            }
        });

    }

    //fungsi daftar email dan nomor telepon
    private void daftar(){
        etEmail = Objects.requireNonNull(et_email.getText()).toString();
        etNomorTelepon = Objects.requireNonNull(et_nomor_telepon.getText()).toString();

        //btn daftar
        Intent intentDaftar = new Intent(RegisterActivity.this, OtpActivity.class);
        intentDaftar.putExtra("dataEmail",etEmail);
        intentDaftar.putExtra("dataNomorTelepon",etNomorTelepon);
        startActivity(intentDaftar);
    }


}
