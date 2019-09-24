package com.example.browncoffee.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.browncoffee.screen.fragment.BakeryFragment;
import com.example.browncoffee.screen.fragment.CakeFragment;

public class DessertAdapter extends FragmentPagerAdapter {
    private int tabNum;

    public DessertAdapter(FragmentManager fm, int tabnum) {
        super(fm);
        this.tabNum = tabnum;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CakeFragment();
            case 1:
                return new BakeryFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabNum;
    }
}
