package com.onoh.ewallet02.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.onoh.ewallet02.R;
import com.onoh.ewallet02.model.utils.SharedPrefManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LandingPageActivity extends AppCompatActivity {

    @BindView(R.id.btn_masuk_landing)
    Button btnMasukLanding;
    @BindView(R.id.btn_daftar_landing)
    Button btnDaftarLanding;
    SharedPrefManager sharedPrefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        ButterKnife.bind(this);
        sharedPrefManager = new SharedPrefManager(this);

        if (sharedPrefManager.getSPSudahLogin()) {
            startActivity(new Intent(LandingPageActivity.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        btnMasukLanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_login = new Intent(LandingPageActivity.this,LoginActivity.class);
                startActivity(intent_login);

            }
        });

        btnDaftarLanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_daftar = new Intent(LandingPageActivity.this,RegisterActivity.class);
                startActivity(intent_daftar);

            }
        });

    }

    @Override
    protected void onResume() {
        sharedPrefManager = new SharedPrefManager(this);

        if (sharedPrefManager.getSPSudahLogin()) {
            finish();
        }
        super.onResume();
    }
}
