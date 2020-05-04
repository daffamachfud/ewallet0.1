package com.onoh.ewallet01.activity.transfer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.onoh.ewallet01.R;
import com.onoh.ewallet01.activity.PaymentDetailActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TransferActivity extends AppCompatActivity implements DecoratedBarcodeView.TorchListener {

    //inisiasi DecoratedBarcodeView
    private CaptureManager capture;
    private boolean isFlashLightOn = false;

    @BindView(R.id.zxing_barcode_scanner_transfer)
    DecoratedBarcodeView barcodeScannerTransferView;
    @BindView(R.id.switch_flashlight_transfer)
    ImageButton switchFlashlightButton;
    @BindView(R.id.btn_close_transfer)
    ImageButton btnCloseScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        ButterKnife.bind(this);
        doRequestCameras();

//        setSupportActionBar(toolbar);
        //set torch listener
        barcodeScannerTransferView.setTorchListener(this);

        //fungsi flashlight di hp, jika tidak ada flash maka button hilang
        if (!hasFlash()) {
            switchFlashlightButton.setVisibility(View.GONE);
        } else {
            switchFlashlightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switchFlashlight();
                }
            });
        }

        //start capture
        capture = new CaptureManager(this, barcodeScannerTransferView);
        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.decode();

        //close button scanner
        btnCloseScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    //cek kamera device punya flashlight
    private boolean hasFlash() {
        return getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    public void switchFlashlight() {
        if (isFlashLightOn) {
            barcodeScannerTransferView.setTorchOff();
            isFlashLightOn = false;
        } else {
            barcodeScannerTransferView.setTorchOn();
            isFlashLightOn = true;
        }

    }

    @Override
    public void onTorchOn() {
        Drawable gambarOn = getResources().getDrawable(R.drawable.ic_buttonflashlighton);
        switchFlashlightButton.setBackgroundDrawable(gambarOn);
    }

    @Override
    public void onTorchOff() {
        Drawable gambarOff = getResources().getDrawable(R.drawable.ic_buttonflashlightoff);
        switchFlashlightButton.setBackgroundDrawable(gambarOff);
    }

    @Override
    protected void onResume() {
        super.onResume();
        capture.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        capture.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        capture.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        capture.onSaveInstanceState(outState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return barcodeScannerTransferView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

    //request perrmission camera
    public void doRequestCameras(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{(Manifest.permission.CAMERA)}, 100);
            }
        }
    }







}
