package com.onoh.ewallet01.activity.BottomNavigationActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.onoh.ewallet01.R;
import com.onoh.ewallet01.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DompetActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dompet);
        ButterKnife.bind(this);



    }


}
