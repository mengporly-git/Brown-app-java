package com.example.browncoffee.screen.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.browncoffee.R;
import com.example.browncoffee.adapter.CoffeeBeanAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class CoffeeBeanDetailActivity extends AppCompatActivity {
    TabLayout tabLayoutCoffeeBean;
    TabItem tabCoffeeBean;
    ViewPager viewPager;
    ImageView imageViewBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_bean_detail);
        tabLayoutCoffeeBean = findViewById(R.id.tabLayout_coffee_bean);
        tabCoffeeBean = findViewById(R.id.tab_coffee_bean);
        viewPager = findViewById(R.id.viewPager);
        imageViewBack = findViewById(R.id.iv_back_merchandise);


        CoffeeBeanAdapter coffeeBeanAdapter = new CoffeeBeanAdapter(getSupportFragmentManager(), tabLayoutCoffeeBean.getTabCount());
        viewPager.setAdapter(coffeeBeanAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutCoffeeBean));
        tabLayoutCoffeeBean.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
