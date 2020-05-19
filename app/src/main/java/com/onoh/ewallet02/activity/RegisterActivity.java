package com.onoh.ewallet02.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.onoh.ewallet02.R;
import com.onoh.ewallet02.apihelper.BaseApiService;
import com.onoh.ewallet02.apihelper.UtilsApi;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {
    private String etEmail,etNomorTelepon,etNama;

    @BindView(R.id.et_nama_daftar)
    TextInputEditText et_nama;
    @BindView(R.id.et_nomor_telepon_daftar)
    TextInputEditText et_nomor_telepon;
    @BindView(R.id.et_email_daftar)
    TextInputEditText et_email;


    @BindView(R.id.btn_daftar)
    Button btn_daftar;
    @BindView(R.id.tv_masuk_disini)
    TextView tvMasuk;
    ProgressDialog loading;
    Context mContext;
    BaseApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        mContext = this;
        mApiService = UtilsApi.getAPIService();



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
        etNama = Objects.requireNonNull(et_nama.getText()).toString();

        Intent intent_form_daftar = new Intent(RegisterActivity.this,PinRegisterActivity.class);
        intent_form_daftar.putExtra("namaDaftar",etNama);
        intent_form_daftar.putExtra("nomorTeleponDaftar",etNomorTelepon);
        intent_form_daftar.putExtra("emailDaftar",etEmail);
        startActivity(intent_form_daftar);

    }


}
