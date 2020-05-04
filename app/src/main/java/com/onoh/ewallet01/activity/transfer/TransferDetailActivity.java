package com.onoh.ewallet01.activity.transfer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.onoh.ewallet01.R;
import com.onoh.ewallet01.model.MoneyTextWatcher;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TransferDetailActivity extends AppCompatActivity {

    @BindView(R.id.tv_nama_user_transfer)
    TextView tv_tujuan_trasnfer;
    @BindView(R.id.etMasukanNominalTrasnfer)
    TextInputEditText etNominalTransfer;
    @BindView(R.id.btn_acc_transfer)
    Button btnTransfer;
    @BindView(R.id.btn_batalkan_transfer)
    Button btnBatalTransfer;
    @BindView(R.id.toolbar_transfer_details)
    Toolbar toolbar_transfer_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trasnfer_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar_transfer_detail);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //back button toolbar
        toolbar_transfer_detail.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        hasilScan();
        etNominalTransfer.addTextChangedListener(new MoneyTextWatcher(etNominalTransfer));
    }



    public void hasilScan(){
        String nama_tujuan;
        nama_tujuan = getIntent().getStringExtra("hasilscantransfer");
        tv_tujuan_trasnfer.setText(nama_tujuan);
    }
}
