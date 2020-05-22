package com.onoh.ewallet02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
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

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.pinView) PinView pinview;
    @BindView(R.id.btn_next_otp) Button btn_next_otp;
    @BindView(R.id.tv_nomor_telepon_otp)
    TextView tv_nomor_telepon;

    String namaDaftar, nomorTelepon, emailDaftar,kodeOtp;
    ProgressDialog loading;
    Context mContext;
    BaseApiService mApiService;
    int idOtp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        btn_next_otp.setOnClickListener(this);
        getDataDaftar();
        tv_nomor_telepon.setText(nomorTelepon);
        kodeOtp = Objects.requireNonNull(pinview.getText()).toString();
    }

    @Override
    public void onClick(View view) {
        kodeOtp = Objects.requireNonNull(pinview.getText()).toString();
        //panggil fungsi validate
        loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
        validateOTP();
    }


    public void getDataDaftar(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            namaDaftar = extras.getString("namaDaftar");
            nomorTelepon = extras.getString("nomorTeleponDaftar");
            emailDaftar = extras.getString("emailDaftar");
            idOtp = extras.getInt("idOtp");
        }
    }

    public void validateOTP(){
        Call<UserResponse> validateOtp =mApiService.validateOtp(idOtp,kodeOtp);
        validateOtp.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NotNull Call<UserResponse> call, @NotNull Response<UserResponse> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    try {
                        assert response.body() != null;
                        if (response.body().getStatus() == 201 ){
                            Intent intent = new Intent(mContext, PinRegisterActivity.class);
                            intent.putExtra("result_nama", namaDaftar);
                            intent.putExtra("result_nomortelepon", nomorTelepon);
                            intent.putExtra("result_email", emailDaftar);
                            startActivity(intent);
                            finish();
                        } else if (response.body().getStatus() == 401){
                            Toast.makeText(mContext, "Nomor OTP yang anda masukan salah", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(mContext, "Gagal submit, silahkan coba lagi", Toast.LENGTH_SHORT).show();
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
