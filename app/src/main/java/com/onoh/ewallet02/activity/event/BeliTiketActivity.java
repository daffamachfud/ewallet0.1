package com.onoh.ewallet02.activity.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.onoh.ewallet02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeliTiketActivity extends AppCompatActivity {

    @BindView(R.id.tv_nama_event_beli_tiket)
    TextView tv_namaEvent;
    @BindView(R.id.tv_nama_tempat_beli_tiket)
    TextView tvTempat;
    @BindView(R.id.tv_tgl_event_beli_tiket)
    TextView tvTgl;
    @BindView(R.id.toolbar_belitiket)
    Toolbar toolbar_belitiket;

    String namaEvent,tempatEvent,tglEvent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_tiket);
        ButterKnife.bind(this);
        getData();

        //backbutton
        toolbar_belitiket.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
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
