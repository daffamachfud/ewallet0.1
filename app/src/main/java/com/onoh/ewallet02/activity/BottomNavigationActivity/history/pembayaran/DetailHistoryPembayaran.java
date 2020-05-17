package com.onoh.ewallet02.activity.BottomNavigationActivity.history.pembayaran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.onoh.ewallet02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailHistoryPembayaran extends AppCompatActivity {

    String tvIdUser,tvTglTransaksi,tvWaktuTransaksi,imgStat,tvStat,tvTipe,tvTujuan,tvNominal,tvIdTransaksi;
    @BindView(R.id.id_user_detail_history_pembayaran)
    TextView tv_id_user;
    @BindView(R.id.tv_tgl_transaksi_historybayar_detail)
    TextView tv_tgl;
    @BindView(R.id.tv_waktu_historybayar_detail)
    TextView tv_waktu;
    @BindView(R.id.img_stat_detail_historybayar)
    ImageView img_stat;
    @BindView(R.id.tv_stat_detail_history_bayar)
    TextView tv_stat;
    @BindView(R.id.tv_tipe_detail_history_bayar)
    TextView tv_tipe;
    @BindView(R.id.tv_tujuan_detail_history_bayar)
    TextView tv_tujuan;
    @BindView(R.id.tv_nominal_detail_history_bayar)
    TextView tv_nominal;
    @BindView(R.id.tv_id_history_topup_bayar)
    TextView tv_id_history;
    @BindView(R.id.toolbar_detail_history_pembayaran)
    Toolbar toolbar_detail_history_pembayaran;

    String idUser = "089675762942";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history_pembayaran);
        ButterKnife.bind(this);
        getData();

        toolbar_detail_history_pembayaran.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    public void getData(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){

            tvTglTransaksi = extras.getString("tanggal");
            tvWaktuTransaksi = extras.getString("waktu");
            imgStat = extras.getString("status");
            tvStat = extras.getString("status");
            tvTipe = extras.getString("ketPembayaran");
            tvTujuan = extras.getString("tempat");
            tvNominal = extras.getString("nominal");
            tvIdTransaksi = extras.getString("idTransaksi");


            tv_id_user.setText(idUser);
            tv_tgl.setText(tvTglTransaksi);
            tv_waktu.setText(tvWaktuTransaksi);
            tv_stat.setText(tvStat);
            tv_tipe.setText(tvTipe);
            tv_tujuan.setText(tvTujuan);
            tv_nominal.setText(tvNominal);
            tv_id_history.setText(tvIdTransaksi);

            if(imgStat.equals("Berhasil")){
                img_stat.setImageResource(R.drawable.ic_check);
            }else{
                img_stat.setImageResource(R.drawable.ic_gagal);
            }
        }
    }



}
