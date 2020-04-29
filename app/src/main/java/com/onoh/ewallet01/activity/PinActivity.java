package com.onoh.ewallet01.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.andrognito.pinlockview.IndicatorDots;
import com.andrognito.pinlockview.PinLockListener;
import com.andrognito.pinlockview.PinLockView;
import com.onoh.ewallet01.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PinActivity extends AppCompatActivity {

    private final static String TAG = PinActivity.class.getSimpleName();
    private final static String TRUE_CODE = "123456";

    @BindView(R.id.pin_lock_view) PinLockView mPinLockView;
    @BindView(R.id.indicator_dots) IndicatorDots mIndicatorDots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        ButterKnife.bind(this);
        //attach lockview dengan indicator
        mPinLockView.attachIndicatorDots(mIndicatorDots);

        //set max PIN
        mPinLockView.setPinLength(6);

        //set listener
        mPinLockView.setPinLockListener(new PinLockListener() {
            @Override
            public void onComplete(String pin) {
                Toast.makeText(PinActivity.this,"Berhasil",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onEmpty() {
                Toast.makeText(PinActivity.this,"Kosong",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onPinChange(int pinLength, String intermediatePin) {
                Log.d(TAG, "Pin changed, new length " + pinLength + " with intermediate pin " + intermediatePin);
            }
        });

    }


}
