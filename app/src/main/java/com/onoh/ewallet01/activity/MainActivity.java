package com.onoh.ewallet01.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.onoh.ewallet01.R;
import com.onoh.ewallet01.activity.BottomNavigationActivity.DompetActivity;
import com.onoh.ewallet01.activity.BottomNavigationActivity.HistoryActivity;
import com.onoh.ewallet01.activity.BottomNavigationActivity.PaymentActivity;
import com.onoh.ewallet01.activity.BottomNavigationActivity.ProfileActivity;
import com.onoh.ewallet01.adapter.SliderAdapterExample;
import com.onoh.ewallet01.fragment.HomeFragment;
import com.onoh.ewallet01.model.SliderItem;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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
                Toast.makeText(MainActivity.this, "HALAMAN TOPUP", Toast.LENGTH_SHORT).show();
            }
        });

        btn_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "HALAMAN TRANSFER", Toast.LENGTH_SHORT).show();
            }
        });

        btn_terima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "HALAMAN TERIMA", Toast.LENGTH_SHORT).show();
            }
        });

        //intent scan qr code
        btn_scan_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new IntentIntegrator(MainActivity.this).setCaptureActivity(PaymentActivity.class).initiateScan();

//                Intent payment_intent = new Intent(MainActivity.this,PaymentActivity.class);
//                startActivity(payment_intent);
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
                Intent history_intent = new Intent(MainActivity.this,HistoryActivity.class);
                startActivity(history_intent);
                break;
            case R.id.profile:
                Intent profile_intent = new Intent(MainActivity.this, ProfileActivity.class);
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


    //Handle hasil scanner pembayaran
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
                showResultDialogue(result.getContents());
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    //method to construct dialogue with scan results
    public void showResultDialogue(final String result) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Scan Result")
                .setMessage("Scanned result is " + result)
                .setPositiveButton("Copy result", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Scan Result", result);
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(MainActivity.this, "Result copied to clipboard", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        dialog.dismiss();
                    }
                })
                .show();
    }

}
