package com.onoh.ewallet02.activity.donasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.onoh.ewallet02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FormDonasiActivity extends AppCompatActivity {

    @BindView(R.id.tv_nama_donasi_sumbang)
    TextView tvNamaDonasi;
    @BindView(R.id.tv_nominal_donasi_sumbang)
    TextView tvDetailNominal;
    @BindView(R.id.tv_tgl_donasi_sumbang)
    TextView tvTglDetail;
    @BindView(R.id.toolbar_sumbang_donasi)
    Toolbar toolbar_form_donasi;

    String namaDonasi,nominalDetailDonasi, tglDetailDonasi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_donasi);
        ButterKnife.bind(this);
        getData();

        //backbutton
        toolbar_form_donasi.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    public void getData(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            namaDonasi = extras.getString("namaDonasi");
            nominalDetailDonasi = extras.getString("nominalDonasi");
            tglDetailDonasi = extras.getString("tanggalDonasi");

            tvNamaDonasi.setText(namaDonasi);
            tvDetailNominal.setText(nominalDetailDonasi);
            tvTglDetail.setText(tglDetailDonasi);


        }
    }
}
