package com.example.browncoffee.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.browncoffee.screen.fragment.CoffeeBeanFragment;

public class CoffeeBeanAdapter extends FragmentPagerAdapter {
    private int tabNum;

    public CoffeeBeanAdapter(FragmentManager fm, int tabnum) {
        super(fm);
        this.tabNum = tabnum;
    }

    @Override
    public Fragment getItem(int position) {
        return new CoffeeBeanFragment();

    }

    @Override
    public int getCount() {
        return tabNum;
    }
}
