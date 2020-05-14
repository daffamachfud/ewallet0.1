package com.onoh.ewallet01.activity.BottomNavigationActivity.history;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;
import com.onoh.ewallet01.R;
import com.onoh.ewallet01.activity.BottomNavigationActivity.history.pembayaran.HistoryPembayaranFragment;
import com.onoh.ewallet01.activity.BottomNavigationActivity.history.topup.HistoryTopupFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HistoryActivity extends AppCompatActivity {


    private ViewPagerAdapter adapter;

    @BindView(R.id.tablayout_id)
    TabLayout tabLayout;
    @BindView(R.id.viewpager_id)
    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new HistoryPembayaranFragment(),"Pembayaran");
        adapter.AddFragment(new HistoryTopupFragment(),"Topup");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




    }
}