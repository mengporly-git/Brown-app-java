package com.example.browncoffee.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.browncoffee.screen.fragment.MerchandiseFragment;

public class MerchandiseAdapter extends FragmentPagerAdapter {
    private int tabNum;

    public MerchandiseAdapter(FragmentManager fm, int tabnum) {
        super(fm);
        this.tabNum = tabnum;
    }

    @Override
    public Fragment getItem(int position) {
        return new MerchandiseFragment();
    }

    @Override
    public int getCount() {
        return tabNum;
    }
}
