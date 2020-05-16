package com.onoh.ewallet02.activity.BottomNavigationActivity.history;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;
import com.onoh.ewallet02.R;
import com.onoh.ewallet02.activity.BottomNavigationActivity.history.pembayaran.HistoryPembayaranFragment;
import com.onoh.ewallet02.activity.BottomNavigationActivity.history.topup.HistoryTopupFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HistoryActivity extends AppCompatActivity {


    private ViewPagerAdapter adapter;

    @BindView(R.id.tablayout_id)
    TabLayout tabLayout;
    @BindView(R.id.viewpager_id)
    ViewPager viewPager;
    @BindView(R.id.toolbar_history)
    Toolbar toolbar_history;

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

        toolbar_history.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}