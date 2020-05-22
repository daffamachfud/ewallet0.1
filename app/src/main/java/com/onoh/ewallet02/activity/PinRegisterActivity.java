package com.onoh.ewallet02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.andrognito.pinlockview.IndicatorDots;
import com.andrognito.pinlockview.PinLockListener;
import com.andrognito.pinlockview.PinLockView;
import com.onoh.ewallet02.R;
import com.onoh.ewallet02.apihelper.BaseApiService;
import com.onoh.ewallet02.apihelper.UtilsApi;
import com.onoh.ewallet02.model.response.User;
import com.onoh.ewallet02.model.response.UserResponse;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PinRegisterActivity extends AppCompatActivity {

    private final static String TAG = PinRegisterActivity.class.getSimpleName();
    private final static String TRUE_CODE = "123456";

    @BindView(R.id.pin_lock_view) PinLockView mPinLockView;
    @BindView(R.id.indicator_dots) IndicatorDots mIndicatorDots;

    String namaDaftar,nomorTelepon,emailDaftar,pin_daftar,pin_confirmation;
    ProgressDialog loading;
    Context mContext;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();

        getDataDaftar();
        Toast.makeText(mContext, namaDaftar + nomorTelepon + emailDaftar, Toast.LENGTH_LONG).show();

        //attach lockview dengan indicator
        mPinLockView.attachIndicatorDots(mIndicatorDots);

        //set max PIN
        mPinLockView.setPinLength(6);

        //set listener
        mPinLockView.setPinLockListener(new PinLockListener() {
            @Override
            public void onComplete(String pin) {
                pin_daftar = pin;
                Toast.makeText(mContext, pin_daftar, Toast.LENGTH_SHORT).show();
                mPinLockView.setPinLockListener(new PinLockListener() {
                    @Override
                    public void onComplete(String pin2) {
                        if(pin2.equals(pin_daftar)){
                            pin_confirmation = pin2;
                            loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                            requestDaftar();
                        }else{
                            Toast.makeText(PinRegisterActivity.this,"PIN tidak cocok",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onEmpty() {

                    }

                    @Override
                    public void onPinChange(int pinLength, String intermediatePin) {

                    }
                });
                Toast.makeText(PinRegisterActivity.this,"Berhasil",Toast.LENGTH_LONG).show();
            }




            @Override
            public void onEmpty() {
                Toast.makeText(PinRegisterActivity.this,"Kosong",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onPinChange(int pinLength, String intermediatePin) {
                Log.d(TAG, "Pin changed, new length " + pinLength + " with intermediate pin " + intermediatePin);
            }
        });

    }

    public void getDataDaftar(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            namaDaftar = extras.getString("result_nama");
            nomorTelepon = extras.getString("result_nomortelepon");
            emailDaftar = extras.getString("result_email");
        }
    }

    public void requestDaftar(){
        Call<UserResponse> postRegister =mApiService.postRegister(namaDaftar,emailDaftar,nomorTelepon,pin_daftar,pin_confirmation);
                    postRegister.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(@NotNull Call<UserResponse> call, @NotNull Response<UserResponse> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            try {
                                assert response.body() != null;
                                if (response.body().getStatus() == 201 && !(response.body().getData()==null)){
                                    String nama = response.body().getData().getUser().getNama();
                                    String nomor_telepon = response.body().getData().getUser().getNomorTelepon();
                                    String token = response.body().getData().getToken().getToken();
                                    Intent intent = new Intent(mContext, MainActivity.class);
                                    intent.putExtra("result_nama", nama);
                                    intent.putExtra("result_nomortelepon", nomor_telepon);
                                    intent.putExtra("result_token", token);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(mContext, "GAGAL", Toast.LENGTH_SHORT).show();
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
