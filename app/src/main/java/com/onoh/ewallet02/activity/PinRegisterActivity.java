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
            namaDaftar = extras.getString("namaDaftar");
            nomorTelepon = extras.getString("nomorTeleponDaftar");
            emailDaftar = extras.getString("emailDaftar");
        }
    }

    public void requestDaftar(){
        mApiService.postRegister(namaDaftar,emailDaftar,nomorTelepon,pin_daftar,pin_confirmation)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(@NotNull Call<ResponseBody> call, @NotNull Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            try {
                                assert response.body() != null;
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (!jsonRESULTS.getString("token").isEmpty()){
                                    Toast.makeText(mContext, "BERHASIL Registrasi", Toast.LENGTH_SHORT).show();
                                    String nama = jsonRESULTS.getJSONObject("user").getString("nama");
                                    Intent intent = new Intent(mContext, LoginActivity.class);
                                    intent.putExtra("result_nama", nama);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(mContext, "GAGAL", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException | IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                    }
                });
    }


}
