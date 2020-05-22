package com.onoh.ewallet02.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.onoh.ewallet02.R;
import com.onoh.ewallet02.apihelper.BaseApiService;
import com.onoh.ewallet02.apihelper.UtilsApi;
import com.onoh.ewallet02.model.response.UserResponse;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                etEmail = Objects.requireNonNull(et_email.getText()).toString();
                etNomorTelepon = Objects.requireNonNull(et_nomor_telepon.getText()).toString();
                etNama = Objects.requireNonNull(et_nama.getText()).toString();
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                sendotp();
            }
        });

        tvMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_masuk = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent_masuk);
                finish();
            }
        });

    }


    public void sendotp(){
        Call<UserResponse> postOtp =mApiService.postOtp(etNomorTelepon);
        postOtp.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NotNull Call<UserResponse> call, @NotNull Response<UserResponse> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    try {
                        assert response.body() != null;
                        if (response.body().getData().getIdOtp() != 0 && !(response.body().getData()==null)){
                            int idOtp = response.body().getData().getIdOtp();
                            Intent intent_form_daftar = new Intent(RegisterActivity.this,OtpActivity.class);
                            intent_form_daftar.putExtra("namaDaftar",etNama);
                            intent_form_daftar.putExtra("nomorTeleponDaftar",etNomorTelepon);
                            intent_form_daftar.putExtra("emailDaftar",etEmail);
                            intent_form_daftar.putExtra("idOtp",idOtp);
                            startActivity(intent_form_daftar);
                        } else {
                            Toast.makeText(mContext, "OTP GAGAL DIKIRIM", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    loading.dismiss();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("debug", "onFailure: ERROR > " + t.toString());
                loading.dismiss();
            }
        });
    }


}
