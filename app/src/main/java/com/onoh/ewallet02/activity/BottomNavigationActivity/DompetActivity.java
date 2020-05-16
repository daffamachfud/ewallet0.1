package com.onoh.ewallet02.activity.BottomNavigationActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.onoh.ewallet02.R;
import com.onoh.ewallet02.activity.limituang.LimituangActivity;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DompetActivity extends AppCompatActivity {


    @BindView(R.id.toolbar_dompet)
    Toolbar toolbar_dompet;
    @BindView(R.id.btn_limit_uang)
    ImageButton btn_limituang;
    @BindView(R.id.dompet_nama)
    TextView tvNamaDompet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dompet);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar_dompet);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        toolbar_dompet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_limituang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_limit = new Intent(DompetActivity.this, LimituangActivity.class);
                startActivity(intent_limit);
            }
        });
    }


}
