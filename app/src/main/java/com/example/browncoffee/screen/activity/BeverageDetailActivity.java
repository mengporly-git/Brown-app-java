package com.example.browncoffee.screen.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.browncoffee.R;
import com.example.browncoffee.adapter.BeverageAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class BeverageDetailActivity extends AppCompatActivity {
    TabLayout tabLayoutBeverage;
    TabItem tabColdDrink, tabFrappe, tabHotDrink, tabHotTea, tabSmoothies, tabSoftDrink;
    ViewPager viewPager;
    ImageView imageViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage_detail);
        tabLayoutBeverage = findViewById(R.id.tabLayout_beverage);
        tabColdDrink = findViewById(R.id.tab_cold_drink);
        tabFrappe = findViewById(R.id.tab_frappe);
        tabHotDrink = findViewById(R.id.tab_hot_drink);
        tabHotTea = findViewById(R.id.tab_hot_tea);
        tabSmoothies = findViewById(R.id.tab_smoothies);
        tabSoftDrink = findViewById(R.id.tab_soft_drink);
        viewPager = findViewById(R.id.viewPager);
        imageViewBack = findViewById(R.id.iv_back_merchandise);

        BeverageAdapter beverageAdapter = new BeverageAdapter(getSupportFragmentManager(), tabLayoutBeverage.getTabCount());
        viewPager.setAdapter(beverageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutBeverage));
        tabLayoutBeverage.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}
