package com.onoh.ewallet02.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.onoh.ewallet02.R;
import com.onoh.ewallet02.activity.BottomNavigationActivity.DompetActivity;
import com.onoh.ewallet02.activity.BottomNavigationActivity.PaymentActivity;
import com.onoh.ewallet02.activity.BottomNavigationActivity.ProfileActivity;
import com.onoh.ewallet02.activity.BottomNavigationActivity.history.HistoryActivity;
import com.onoh.ewallet02.activity.terima.TerimaActivity;
import com.onoh.ewallet02.activity.topup.TopupActivity;
import com.onoh.ewallet02.activity.transfer.TransferActivity;
import com.onoh.ewallet02.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //inisiasi variabel dengan bindview
    @BindView(R.id.bottom_nav)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.shimmer_layout)
    ShimmerFrameLayout shimmerFrameLayout;
    //Button menu topbar
    @BindView(R.id.btn_topup)
    ImageView btn_topup;
    @BindView(R.id.btn_transfer)
    ImageView btn_transfer;
    @BindView(R.id.btn_terima)
    ImageView btn_terima;
    @BindView(R.id.btn_scan_qr)
    FloatingActionButton btn_scan_qr;

    boolean user_merchant = false;
    String dataNomorTelepon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getData();

        // kita set default nya Home Fragment
        loadFragment(new HomeFragment());
        // inisialisasi BottomNavigaionView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        // beri listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        shimmerFrameLayout.startShimmerAnimation();
        //set color button qr code
        btn_scan_qr.setColorFilter(Color.WHITE);


        //Intent menu topup,transfer,terima
        btn_topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_topup = new Intent(MainActivity.this, TopupActivity.class);
                startActivity(intent_topup);
            }
        });

        btn_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent_transfer = new Intent(MainActivity.this,TransferActivity.class);
               startActivity(intent_transfer);
            }
        });

        btn_terima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                    Intent intent_terima = new Intent(MainActivity.this, TerimaActivity.class);
                    intent_terima.putExtra("myqr",bitmap);
                    intent_terima.putExtra("namaUser",namaUser);
                    intent_terima.putExtra("nomorTelepon",nomorTelepon);
                    startActivity(intent_terima);
                }catch (WriterException e){
                    e.printStackTrace();
                }
            }
        });

        //intent scan qr code
        btn_scan_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new IntentIntegrator(MainActivity.this).setCaptureActivity(PaymentActivity.class).initiateScan();
//                IntentIntegrator integratorTransfer = new IntentIntegrator(MainActivity.this);
//                integratorTransfer.setCaptureActivity(PaymentActivity.class);
//                integratorTransfer.setRequestCode(1).initiateScan();
            }
        });



    }



    //Bottom navigasi
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.home:
                fragment = new HomeFragment();
                break;
            case R.id.dompet:
                Intent dompet_intent = new Intent(MainActivity.this,DompetActivity.class);
                startActivity(dompet_intent);
                break;

            case R.id.scanqrcode:
                Intent payment_intent = new Intent(MainActivity.this,PaymentActivity.class);
                startActivity(payment_intent);
                break;
            case R.id.history:
                Intent history_intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(history_intent);
                break;
            case R.id.profile:
                Intent profile_intent = new Intent(MainActivity.this, ProfileActivity.class);
                profile_intent.putExtra("tipeUserMerchant",user_merchant);
                profile_intent.putExtra("dataNomorTelepon",dataNomorTelepon);
                startActivity(profile_intent);
                break;
        }
        return loadFragment(fragment);
    }


    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container , fragment).commit();
            return true;
        }
        return false;
    }


    //Handle jika dua activity berbeda
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        //We will get scan results here
//        IntentResult result = IntentIntegrator.parseActivityResult(resultCode, data);
//        //check for null
//        if (result.getContents() == null) {
//            Toast.makeText(this, "Scan Cancelled", Toast.LENGTH_LONG).show();
//        } else if(requestCode == 2) {
//            showResultDialogueTransfer(result.getContents());
//        }else{
//            showResultDialoguePembayaran(result.getContents());
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //We will get scan results here
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        //check for null
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "Scan Cancelled", Toast.LENGTH_LONG).show();
            } else {
                //show dialogue with result
                showResultDialoguePembayaran(result.getContents());
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    //method to construct dialogue pemabayran
    public void showResultDialoguePembayaran(final String result) {

        //intent ke halaman detail payment
        Intent intent_detail_pembayaran = new Intent(this,PaymentDetailActivity.class);
        intent_detail_pembayaran.putExtra("hasilscanpembayaran",result);
        startActivity(intent_detail_pembayaran);

//
    }
    //end shoResultDialoguePemabayran


    //getData
    public void getData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            dataNomorTelepon = extras.getString("dataNomorTelepon");
            Toast.makeText(this, dataNomorTelepon, Toast.LENGTH_LONG).show();
        }

    }


}
