package com.onoh.ewallet02.activity.ukt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.onoh.ewallet02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KonfirmUktActivity extends AppCompatActivity {

    @BindView(R.id.logo_univ_konfirm_ukt)
    ImageView imgLogoUniv;
    @BindView(R.id.namaUnivKonfirmUkt)
    TextView tvNamaUniv;
    @BindView(R.id.nim_ukt_konfirm)
    TextView tvNim;
    @BindView(R.id.btnKonfirmUkt)
    Button btnKonfirm;
    @BindView(R.id.toolbar_konfirm_ukt)
    Toolbar toolbar_konfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirm_ukt);
        ButterKnife.bind(this);
        getData();
        submitdata();

        //backpressed
        toolbar_konfirm.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    public void getData(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String namaUniv,nim;
            int gambar;

            nim = extras.getString("nim");
            namaUniv = extras.getString("namaUniv");
            gambar = getIntent().getIntExtra("gambarUniv",0);

            imgLogoUniv.setImageResource(gambar);
            tvNamaUniv.setText(namaUniv);
            tvNim.setText(nim);

        }
    }


    public void submitdata(){
        btnKonfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogConfirmBayar();
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


}
