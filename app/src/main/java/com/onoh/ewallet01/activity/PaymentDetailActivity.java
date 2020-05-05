package com.onoh.ewallet01.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.onoh.ewallet01.R;
import com.onoh.ewallet01.model.MoneyTextWatcher;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentDetailActivity extends AppCompatActivity {


    @BindView(R.id.tv_nama_toko)
    TextView tv_nama_toko;
    @BindView(R.id.toolbar_payment_details)
    Toolbar toolbar_payment_details;
    @BindView(R.id.etMasukanNominal)
    TextInputEditText etMasukanNominal;
    @BindView(R.id.btn_batalkan_payment)
    Button btn_batal;
    @BindView(R.id.btn_bayar)
    Button btn_bayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar_payment_details);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        hasilScan();
        //format money currency
        etMasukanNominal.addTextChangedListener(new MoneyTextWatcher(etMasukanNominal));
        buttonPembayaran();

        //back button toolbar
        toolbar_payment_details.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    public void hasilScan(){
        String nama_toko;
        nama_toko = getIntent().getStringExtra("hasilscanpembayaran");
        tv_nama_toko.setText(nama_toko);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    //menekan tombol bayar
    public void buttonPembayaran(){
        //Menekan tombol bayar
        btn_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogConfirmBayar();
            }
        });

        //menekan tombol batalkan pemabyaran
        btn_batal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBatalPembayaran();
            }
        });
    }


    public void alertDialogConfirmBayar(){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_confirm_bayar,null);
        builder.setView(dialogView);

        Button btnLihatRiwayat = dialogView.findViewById(R.id.btn_lihat_riwayat);
        Button btnTutup = dialogView.findViewById(R.id.btn_tutup_dialog);

        // membuat alert dialog dari builder
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        btnLihatRiwayat.setEnabled(true);
        btnLihatRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.cancel();
            }
        });
        btnTutup.setEnabled(true);
        btnTutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                alertDialog.dismiss();
            }
        });
        // menampilkan alert dialog
    }

    public void alertDialogBatalPembayaran(){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_batal_bayar,null);
        builder.setView(dialogView);

        Button btnSetujuBatal = dialogView.findViewById(R.id.btn_setuju_batal);
        Button btnKembali = dialogView.findViewById(R.id.btn_kembali_bayar);

        // membuat alert dialog dari builder
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
        btnSetujuBatal.setEnabled(true);
        btnSetujuBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                alertDialog.dismiss();

            }
        });
        btnKembali.setEnabled(true);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.cancel();
            }
        });
        // menampilkan alert dialog
    }
}
