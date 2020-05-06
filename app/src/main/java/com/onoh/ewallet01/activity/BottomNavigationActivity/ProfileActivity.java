package com.onoh.ewallet01.activity.BottomNavigationActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.onoh.ewallet01.R;
import com.onoh.ewallet01.activity.MainActivity;
import com.onoh.ewallet01.activity.terima.TerimaActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.btn_myqrcode)
    ImageButton btn_myqr;
    @BindView(R.id.toolbar_profile)
    Toolbar toolbar_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        toolbar_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_myqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               myqrcode();
            }
        });




    }




    public void myqrcode(){
        //String valueQR = ngambil dari id si pengguna
        //Tes value QR sementara menggunakan nilai berikut
        String valueQR = "Daffa";
        String namaUser = "Daffa";
        String nomorTelepon = "089675762942";

        MultiFormatWriter multiformatwritter = new MultiFormatWriter();
        //kirim nilai value qr dengan intent
        try {
            BitMatrix bitMatrix = multiformatwritter.encode(valueQR, BarcodeFormat.QR_CODE,250,250);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            Intent intent_terima = new Intent(ProfileActivity.this, TerimaActivity.class);
            intent_terima.putExtra("myqr",bitmap);
            intent_terima.putExtra("namaUser",namaUser);
            intent_terima.putExtra("nomorTelepon",nomorTelepon);
            startActivity(intent_terima);
        }catch (WriterException e){
            e.printStackTrace();
        }
    }


}
