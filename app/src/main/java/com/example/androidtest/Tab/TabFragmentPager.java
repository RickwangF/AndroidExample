package com.example.androidtest.Tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabFragmentPager extends FragmentPagerAdapter {

    List<Fragment> mfragments;

    public TabFragmentPager(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mfragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return mfragments.get(i);
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }
}
