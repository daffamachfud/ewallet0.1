package com.onoh.ewallet01.activity.donasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.onoh.ewallet01.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FormDonasiActivity extends AppCompatActivity {

    @BindView(R.id.tv_nama_donasi_sumbang)
    TextView tvNamaDonasi;
    @BindView(R.id.tv_nominal_donasi_sumbang)
    TextView tvDetailNominal;
    @BindView(R.id.tv_tgl_donasi_sumbang)
    TextView tvTglDetail;

    String namaDonasi,nominalDetailDonasi, tglDetailDonasi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_donasi);
        ButterKnife.bind(this);
        getData();
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
