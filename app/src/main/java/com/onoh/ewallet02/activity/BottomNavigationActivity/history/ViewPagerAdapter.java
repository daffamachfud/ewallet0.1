package com.onoh.ewallet02.activity.BottomNavigationActivity.history;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> pertamaFragment = new ArrayList<>();
    private final List<String> pertamaTitle =  new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return pertamaFragment.get(position);
    }

    @Override
    public int getCount() {

        return pertamaTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pertamaTitle.get(position);
    }
    public void AddFragment (Fragment fragment,String title){
        pertamaFragment.add(fragment);
        pertamaTitle.add(title);
    }
}
