package com.onoh.ewallet02.activity.BottomNavigationActivity.history.topup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.onoh.ewallet02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailHistoryTopup extends AppCompatActivity {

    String tipeTopup,tglTopup,waktuTopup,idTransaksi,nominalTopup,status,imgStat;
    String idUser = "089675762942";

    @BindView(R.id.tv_id_user_history_topup)
    TextView tv_id;
    @BindView(R.id.tv_tgl_transaksi_historytopup_detail)
    TextView tv_tgl;
    @BindView(R.id.tv_waktu_topup_history_detail)
    TextView tv_waktu;
    @BindView(R.id.img_stat_detail_history_topup)
    ImageView img_stat;
    @BindView(R.id.tv_stat_detail_history_topup)
    TextView tv_stat;
    @BindView(R.id.tv_tipe_detail_history_topup)
    TextView tv_tipe;
    @BindView(R.id.tv_nominal_detail_history_topup)
    TextView tv_nominal;
    @BindView(R.id.tv_id_history_topup_detail)
    TextView tv_id_topup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history_topup);
        ButterKnife.bind(this);
        getData();
    }

    public void getData(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            tipeTopup = extras.getString("tipeTopup");
            tglTopup = extras.getString("tglTopup");
            waktuTopup = extras.getString("waktuTopup");
            idTransaksi = extras.getString("idTransaksi");
            nominalTopup = extras.getString("nominalTopup");
            status = extras.getString("status");
            imgStat = extras.getString("status");



            tv_id.setText(idUser);
            tv_tgl.setText(tglTopup);
            tv_waktu.setText(waktuTopup);
            tv_stat.setText(status);
            tv_tipe.setText(tipeTopup);
            tv_nominal.setText(nominalTopup);
            tv_id_topup.setText(idTransaksi);

            if(imgStat.equals("Berhasil")){
                img_stat.setImageResource(R.drawable.ic_check);
            }else{
                img_stat.setImageResource(R.drawable.ic_gagal);
            }
        }
    }



}
