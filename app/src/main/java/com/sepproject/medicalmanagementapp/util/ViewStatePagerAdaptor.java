package com.sepproject.medicalmanagementapp.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewStatePagerAdaptor extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewStatePagerAdaptor(FragmentManager fm) {
        super(fm);

    }

    public void addFragement(Fragment fragement, String title){
        mFragmentList.add(fragement);
        mFragmentTitleList.add(title);
    }
    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
