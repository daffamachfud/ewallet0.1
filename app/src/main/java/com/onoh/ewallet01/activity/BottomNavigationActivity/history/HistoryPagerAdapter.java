package com.onoh.ewallet01.activity.BottomNavigationActivity.history;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HistoryPagerAdapter extends FragmentPagerAdapter {

    public HistoryPagerAdapter(FragmentManager fm){
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
