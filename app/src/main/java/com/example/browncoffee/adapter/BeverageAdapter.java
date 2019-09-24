package com.example.browncoffee.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.browncoffee.screen.fragment.ColdDrinkFragment;
import com.example.browncoffee.screen.fragment.FrappeFragment;
import com.example.browncoffee.screen.fragment.HotDrinkFragment;
import com.example.browncoffee.screen.fragment.HotTeaFragment;
import com.example.browncoffee.screen.fragment.SmoothiesFragment;
import com.example.browncoffee.screen.fragment.SoftDrinkFragment;

public class BeverageAdapter extends FragmentPagerAdapter {
    private int tabNum;

    public BeverageAdapter(FragmentManager fm, int tabnum) {
        super(fm);
        this.tabNum = tabnum;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ColdDrinkFragment();
            case 1:
                return new FrappeFragment();
            case 2:
                return new HotDrinkFragment();
            case 3:
                return new HotTeaFragment();
            case 4:
                return new SmoothiesFragment();
            case 5:
                return new SoftDrinkFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabNum;
    }
}
