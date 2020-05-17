package com.onoh.ewallet02.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.andrognito.pinlockview.IndicatorDots;
import com.andrognito.pinlockview.PinLockListener;
import com.andrognito.pinlockview.PinLockView;
import com.onoh.ewallet02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PinVerifyActivity extends AppCompatActivity {

    private final static String TAG = PinVerifyActivity.class.getSimpleName();
    private final static String TRUE_CODE = "123456";

    @BindView(R.id.pin_lock_view)
    PinLockView mPinLockView;
    @BindView(R.id.indicator_dots)
    IndicatorDots mIndicatorDots;

    String destination,dataNomor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        ButterKnife.bind(this);
        getData();
        //attach lockview dengan indicator
        mPinLockView.attachIndicatorDots(mIndicatorDots);
        //set max PIN
        mPinLockView.setPinLength(6);

        //set listener
        mPinLockView.setPinLockListener(new PinLockListener() {
            @Override
            public void onComplete(String pin) {
                if (pin.equals(TRUE_CODE)) {
                    if (destination.equals("login")) {
                        Intent intent_mainactivity = new Intent(PinVerifyActivity.this, MainActivity.class);
                        intent_mainactivity.putExtra("dataNomorTelepon",dataNomor);
                        startActivity(intent_mainactivity);
                    }
                }


            }

            @Override
            public void onEmpty() {
                Toast.makeText(PinVerifyActivity.this, "Kosong", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onPinChange(int pinLength, String intermediatePin) {
                Log.d(TAG, "Pin changed, new length " + pinLength + " with intermediate pin " + intermediatePin);
            }
        });

    }

    public void getData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            destination = extras.getString("destinationView");
            dataNomor = extras.getString("dataNomorTelepon");
        }

    }
}
