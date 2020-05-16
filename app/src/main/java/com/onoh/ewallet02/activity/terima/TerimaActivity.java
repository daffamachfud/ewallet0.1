package com.onoh.ewallet02.activity.terima;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.onoh.ewallet02.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TerimaActivity extends AppCompatActivity {

    @BindView(R.id.image_view_myqrcode)
    ImageView img_myqr;
    @BindView(R.id.tv_nama_myqr)
    TextView tv_namaUser;
    @BindView(R.id.tv_no_telepon_myqr)
    TextView tv_nomorTelepon;
    @BindView(R.id.toolbar_terima)
    Toolbar toolbar_terima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terima);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar_terima);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //back button toolbar
        toolbar_terima.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        String namaUser, nomortelp;
        Bitmap bitmap = getIntent().getParcelableExtra("myqr");
        namaUser = getIntent().getStringExtra("namaUser");
        nomortelp = getIntent().getStringExtra("nomorTelepon");

        img_myqr.setImageBitmap(bitmap);
        tv_namaUser.setText(namaUser);
        tv_nomorTelepon.setText(nomortelp);


    }
}
