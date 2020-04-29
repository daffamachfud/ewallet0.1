package com.onoh.ewallet01.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.onoh.ewallet01.R;
import com.onoh.ewallet01.activity.BottomNavigationActivity.DompetActivity;
import com.onoh.ewallet01.activity.BottomNavigationActivity.HistoryActivity;
import com.onoh.ewallet01.activity.BottomNavigationActivity.PaymentActivity;
import com.onoh.ewallet01.activity.BottomNavigationActivity.ProfileActivity;
import com.onoh.ewallet01.fragment.HomeFragment;
import com.onoh.ewallet01.fragment.ProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //inisiasi variabel dengan bindview
    @BindView(R.id.bottom_nav)
    BottomNavigationView bottomNavigationView;

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

    }
//          @Override
//          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//              switch (item.getItemId()){
//                  case R.id.home:
//                      bottomNavigationView.setSelectedItemId(R.id.home);
//                      return true;
//                  case R.id.dompet:
//                      startActivity(new Intent(getApplicationContext(), DompetActivity.class));
//                      overridePendingTransition(0,0);
//                      return true;
//                  case R.id.scanqrcode:
//                      startActivity(new Intent(getApplicationContext(), PaymentActivity.class));
//                      overridePendingTransition(0,0);
//                      return true;
//                  case R.id.history:
//                      startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
//                      overridePendingTransition(0,0);
//                      return true;
//                  case R.id.profile:
//                      startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
//                      overridePendingTransition(0,0);
//                      return true;
//              }
//              return false;
//          }
//      });

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
                fragment = new ProfileFragment();
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


    
}
