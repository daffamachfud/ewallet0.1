package com.onoh.ewallet02.activity.topup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;


import com.onoh.ewallet02.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopupMerchantActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_topup_booth)
    Toolbar toolbar_topup_booth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup_merchant);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar_topup_booth);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar_topup_booth.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


}
