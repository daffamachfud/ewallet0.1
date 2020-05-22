package com.onoh.ewallet02.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.onoh.ewallet02.R;
import com.onoh.ewallet02.apihelper.BaseApiService;
import com.onoh.ewallet02.apihelper.UtilsApi;
import com.onoh.ewallet02.model.response.UserResponse;
import com.onoh.ewallet02.model.utils.SharedPrefManager;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    ProgressDialog loading;
    Context mContext;
    BaseApiService mApiService;

    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.tv_daftar_disini)
    TextView tvDaftarDisini;
    @BindView(R.id.et_nomor_telepon_login)
    TextInputEditText etNomorTelepon;

    String pageDestination = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        initComponent();


        tvDaftarDisini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_daftar = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent_daftar);
                finish();
            }
        });

    }

    private void initComponent() {

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                String get_data_nomor_telepon = Objects.requireNonNull(etNomorTelepon.getText()).toString();
                if(get_data_nomor_telepon.isEmpty()){
                    loading.dismiss();
                    Toast.makeText(mContext, "Isi nomor telepon anda", Toast.LENGTH_SHORT).show();
                }
               cek_nomor(get_data_nomor_telepon);
            }
        });

    }



    public void cek_nomor(String nomorTelepon){
        Call<UserResponse> post_cek_nomor =mApiService.post_check_mumber(nomorTelepon);
        post_cek_nomor.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NotNull Call<UserResponse> call, @NotNull Response<UserResponse> response) {
                if (response.isSuccessful()){
                    loading.dismiss();
                    try {
                        assert response.body() != null;
                        if (response.body().getStatus() == 201 ){
                            Intent intent = new Intent(mContext, PinVerifyActivity.class);
                            intent.putExtra("dataNomorTelepon",nomorTelepon);
                            intent.putExtra("destinationView",pageDestination);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_SHORT).show();
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

//
}
