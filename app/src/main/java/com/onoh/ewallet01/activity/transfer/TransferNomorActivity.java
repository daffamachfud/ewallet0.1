package com.onoh.ewallet01.activity.transfer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.onoh.ewallet01.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TransferNomorActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_noTelpn)
    Toolbar toolbar_notelpn;
    @BindView(R.id.btn_lanjut_transfer_notelepon)
    Button btnNext;
    @BindView(R.id.etMasukanNomorTujuanTransfer)
    TextInputEditText etNomortelepon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_nomor);
        ButterKnife.bind(this);
        //back button toolbar
        toolbar_notelpn.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomortelepon;
                nomortelepon = Objects.requireNonNull(etNomortelepon.getText()).toString();
                Intent intent_transfer = new Intent(TransferNomorActivity.this,TransferDetailActivity.class);
                intent_transfer.putExtra("nomorTujuan",nomortelepon);
                startActivity(intent_transfer);
            }
        });
    }
}
