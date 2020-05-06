package com.onoh.ewallet01.activity.BottomNavigationActivity.history;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.onoh.ewallet01.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_history)
    Toolbar toolbar_history;
    @BindView(R.id.tabBar)
    TabLayout tabLayout;
    @BindView(R.id.tab_history_pemabayaran)
    TabItem tabHistoryPembayaran;
    @BindView(R.id.tab_history_topup)
    TabItem tabHistoryTopup;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);
    }



}
