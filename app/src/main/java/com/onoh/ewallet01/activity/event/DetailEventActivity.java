package com.onoh.ewallet01.activity.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.onoh.ewallet01.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailEventActivity extends AppCompatActivity {

    @BindView(R.id.img_detail_event)
    ImageView img_detail_event;
    @BindView(R.id.tv_nama_event_detail)
    TextView tv_nama_event_detail;
    @BindView(R.id.tv_nama_tempat_event_detail)
    TextView tv_tempat_event_detail;
    @BindView(R.id.tv_tgl_event_detail)
    TextView tv_tgl_event_detail;
    @BindView(R.id.btn_beli_tiket)
    Button btnBeliTiket;

    String namaEvent, tempatEvent, tglEvent;
    int imgEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);
        ButterKnife.bind(this);
        getData();

        btnBeliTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyTicket();
            }
        });
    }


    public void getData(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            namaEvent = extras.getString("namaEvent");
            tempatEvent = extras.getString("tempatEvent");
            tglEvent = extras.getString("tanggalEvent");
            imgEvent = getIntent().getIntExtra("gambarEvent",0);

            tv_nama_event_detail.setText(namaEvent);
            tv_tempat_event_detail.setText(tempatEvent);
            tv_tgl_event_detail.setText(tglEvent);
            img_detail_event.setImageResource(imgEvent);

        }
    }

    public void buyTicket(){
        Intent intent_beli_tiket = new Intent(DetailEventActivity.this,BeliTiketActivity.class);
        intent_beli_tiket.putExtra("namaEvent",namaEvent);
        intent_beli_tiket.putExtra("tempatEvent",tempatEvent);
        intent_beli_tiket.putExtra("tanggalEvent",tglEvent);
        intent_beli_tiket.putExtra("gambarEvent",imgEvent);
        startActivity(intent_beli_tiket);
    }
}
