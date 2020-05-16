package com.onoh.ewallet02.activity.donasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.onoh.ewallet02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailDonasiActivity extends AppCompatActivity {

    @BindView(R.id.tv_nominal_detail_donasi)
    TextView tvNominalDonasi;
    @BindView(R.id.tv_nama_donasi_detail)
    TextView tvNamaDonasi;
    @BindView(R.id.tv_tgl_donasi_detail)
    TextView tvTglDonasi;
    @BindView(R.id.img_detail_event)
    ImageView imgDetailEvent;
    @BindView(R.id.btn_sumbang_donasi)
    Button btnDonasi;
    @BindView(R.id.toolbar_detaildonasi)
    Toolbar toolbar_detailDonasi;

    String nominalDonasi, namaDonasi, tglDonasi;
    int imgDonasi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_donasi);
        ButterKnife.bind(this);
        getData();

        btnDonasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                donate();
            }
        });

        //backbutton
        toolbar_detailDonasi.setNavigationOnClickListener(new View.OnClickListener() {
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
            tglDonasi = extras.getString("tanggalDonasi");
            nominalDonasi = extras.getString("nominalDonasi");
            imgDonasi = getIntent().getIntExtra("gambarDonasi",0);

            tvNamaDonasi.setText(namaDonasi);
            tvNominalDonasi.setText(nominalDonasi);
            tvTglDonasi.setText(tglDonasi);
            imgDetailEvent.setImageResource(imgDonasi);

        }
    }

    public void donate(){
        Intent intent_donasi = new Intent(DetailDonasiActivity.this, FormDonasiActivity.class);
        intent_donasi.putExtra("namaDonasi",namaDonasi);
        intent_donasi.putExtra("tanggalDonasi",tglDonasi);
        intent_donasi.putExtra("nominalDonasi",nominalDonasi);
        intent_donasi.putExtra("gambarDonasi",imgDonasi);
        startActivity(intent_donasi);
    }
}
