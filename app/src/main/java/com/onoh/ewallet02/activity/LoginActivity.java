package com.onoh.ewallet02.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.onoh.ewallet02.R;
import com.onoh.ewallet02.apihelper.BaseApiService;
import com.onoh.ewallet02.apihelper.UtilsApi;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

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
            }
        });

    }

    private void initComponent() {

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                String nomorTelepon = Objects.requireNonNull(etNomorTelepon.getText()).toString();
                Intent intent_login = new Intent(LoginActivity.this, PinVerifyActivity.class);
                intent_login.putExtra("dataNomorTelepon",nomorTelepon);
                intent_login.putExtra("destinationView",pageDestination);
                startActivity(intent_login);
            }
        });

    }

//    private void requestLogin(){
//        mApiService.loginRequest(etEmail.getText().toString(), etPass.getText().toString())
//                .enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        if (response.isSuccessful()){
//                            loading.dismiss();
//                            try {
//                                assert response.body() != null;
//                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
//                                if (jsonRESULTS.getString("error").equals("false")){
//                                    // Jika login berhasil maka data nama yang ada di response API
//                                    // akan diparsing ke activity selanjutnya.
//                                    Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
//                                    String name = jsonRESULTS.getJSONObject("user").getString("name");
//                                    Intent intent = new Intent(mContext, MainActivity.class);
//                                    intent.putExtra("result_nama", name);
//                                    startActivity(intent);
//                                } else {
//                                    // Jika login gagal
//                                    String error_message = jsonRESULTS.getString("error_msg");
//                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                        } else {
//                            loading.dismiss();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Log.e("debug", "onFailure: ERROR > " + t.toString());
//                        loading.dismiss();
//                    }
//                });
//    }

}
