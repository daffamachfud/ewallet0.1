package com.onoh.ewallet01.activity.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.onoh.ewallet01.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeliTiketActivity extends AppCompatActivity {

    @BindView(R.id.tv_nama_event_beli_tiket)
    TextView tv_namaEvent;
    @BindView(R.id.tv_nama_tempat_beli_tiket)
    TextView tvTempat;
    @BindView(R.id.tv_tgl_event_beli_tiket)
    TextView tvTgl;

    String namaEvent,tempatEvent,tglEvent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_tiket);
        ButterKnife.bind(this);
        getData();
    }

    public void getData(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            namaEvent = extras.getString("namaEvent");
            tempatEvent = extras.getString("tempatEvent");
            tglEvent = extras.getString("tanggalEvent");

            tv_namaEvent.setText(namaEvent);
            tvTempat.setText(tempatEvent);
            tvTgl.setText(tglEvent);


        }
    }
}
