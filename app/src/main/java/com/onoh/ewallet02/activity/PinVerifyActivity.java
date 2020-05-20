package com.onoh.ewallet02.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.andrognito.pinlockview.IndicatorDots;
import com.andrognito.pinlockview.PinLockListener;
import com.andrognito.pinlockview.PinLockView;
import com.onoh.ewallet02.R;
import com.onoh.ewallet02.apihelper.BaseApiService;
import com.onoh.ewallet02.apihelper.UtilsApi;
import com.onoh.ewallet02.model.response.UserResponse;
import com.onoh.ewallet02.model.utils.SharedPrefManager;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PinVerifyActivity extends AppCompatActivity {

    private final static String TAG = PinVerifyActivity.class.getSimpleName();
    private final static String TRUE_CODE = "123456";

    @BindView(R.id.pin_lock_view)
    PinLockView mPinLockView;
    @BindView(R.id.indicator_dots)
    IndicatorDots mIndicatorDots;
    ProgressDialog loading;
    Context mContext;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;
    String destination,dataNomor,pin_confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        sharedPrefManager = new SharedPrefManager(this);
        //get data intent
        getData();
        //attach lockview dengan indicator
        mPinLockView.attachIndicatorDots(mIndicatorDots);
        //set max PIN
        mPinLockView.setPinLength(6);

        //set listener
        mPinLockView.setPinLockListener(new PinLockListener() {
            @Override
            public void onComplete(String pin) {
                    pin_confirm = pin;
                    if (destination.equals("login")) {
                        loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                        requestLogin();
                    }


            }

            @Override
            public void onEmpty() {
                Toast.makeText(PinVerifyActivity.this, "Kosong", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onPinChange(int pinLength, String intermediatePin) {
                Log.d(TAG, "Pin changed, new length " + pinLength + " with intermediate pin " + intermediatePin);
            }
        });

    }

    public void getData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            destination = extras.getString("destinationView");
            dataNomor = extras.getString("dataNomorTelepon");
        }
    }

    public void requestLogin(){
        Call<UserResponse> postLogin =mApiService.postLogin(dataNomor,pin_confirm);
        postLogin.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NotNull Call<UserResponse> call, @NotNull Response<UserResponse> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    try {
                        assert response.body() != null;
                        if (response.body().getStatus() == 201 && !(response.body().getData()==null)){
                            sharedPrefManager.saveSPInt(SharedPrefManager.SP_ID, response.body().getData().getUser().getId());
                            sharedPrefManager.saveSPString(SharedPrefManager.SP_TOKEN, response.body().getData().getToken().getToken());
                            sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);

                            String nama = response.body().getData().getUser().getNama();
                            String nomor_telepon = response.body().getData().getUser().getNomorTelepon();

                            Intent intent = new Intent(mContext, MainActivity.class);
                            intent.putExtra("result_nama", nama);
                            intent.putExtra("result_nomor_telepon", nomor_telepon);
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
