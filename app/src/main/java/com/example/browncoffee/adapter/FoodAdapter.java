package com.example.browncoffee.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.browncoffee.screen.fragment.BreakfastFragment;
import com.example.browncoffee.screen.fragment.ColdSandwichFragment;
import com.example.browncoffee.screen.fragment.PastaFragment;
import com.example.browncoffee.screen.fragment.SaladFragment;
import com.example.browncoffee.screen.fragment.SandwichFragment;

public class FoodAdapter extends FragmentPagerAdapter {
    private int tabNum;

    public FoodAdapter(FragmentManager fm, int tabnum) {
        super(fm);
        this.tabNum = tabnum;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SandwichFragment();
            case 1:
                return new BreakfastFragment();
            case 2:
                return new PastaFragment();
            case 3:
                return new SaladFragment();
            case 4:
                return new ColdSandwichFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabNum;
    }
}
