package com.onoh.ewallet01.activity.topup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.onoh.ewallet01.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopupActivity extends AppCompatActivity {

    @BindView(R.id.btn_back_topup)
    ImageButton btn_back;
    @BindView(R.id.btn_merchant_topup)
    Button btn_merchant_topup;
    @BindView(R.id.btn_bri_topup)
    Button btn_bri_top_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);
        ButterKnife.bind(this);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_merchant_topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_merchant_topup = new Intent(TopupActivity.this,TopupMerchantActivity.class);
                startActivity(intent_merchant_topup);
            }
        });


    }
}
