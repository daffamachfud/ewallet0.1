package com.onoh.ewallet01.activity.BottomNavigationActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.zxing.Result;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.onoh.ewallet01.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class PaymentActivity extends AppCompatActivity implements DecoratedBarcodeView.TorchListener {

    //inisiasi zxing
    ZXingScannerView mScannerView;

//    //Binding Framelayout
//    @BindView(R.id.frame_layout_camera)
//    FrameLayout fr_camera;

    //inisiasi DecoratedBarcodeView
    private CaptureManager capture;
    private boolean isFlashLightOn = false;

    //bikin toolbar
//    @BindView(R.id.toolbar)
//    Toolbar toolbar;

    @BindView(R.id.zxing_barcode_scanner)
    DecoratedBarcodeView barcodeScannerView;
    @BindView(R.id.switch_flashlight)
    Button switchFlashlightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);
        doRequestCamera();

//        setSupportActionBar(toolbar);
        //set torch listener
        barcodeScannerView.setTorchListener(this);

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
        capture = new CaptureManager(this, barcodeScannerView);
        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.decode();

    }
    //end of oncreate

    //cek kamera device punya flashlight
    private boolean hasFlash() {
        return getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    public void switchFlashlight() {
        if (isFlashLightOn) {
            barcodeScannerView.setTorchOff();
            isFlashLightOn = false;
        } else {
            barcodeScannerView.setTorchOn();
            isFlashLightOn = true;
        }

    }

    @Override
    public void onTorchOn() {
        switchFlashlightButton.setText(R.string.turn_off_flashlight);
    }

    @Override
    public void onTorchOff() {
        switchFlashlightButton.setText(R.string.turn_on_flashlight);
    }

    @Override
    protected void onResume() {
        super.onResume();
        capture.onResume();
//        mScannerView.setResultHandler(this);
//        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        capture.onPause();
//        mScannerView.stopCamera();
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
        return barcodeScannerView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

    //request perrmission camera
    public void doRequestCamera(){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{(Manifest.permission.CAMERA)}, 100);
            }
        }
    }




}
