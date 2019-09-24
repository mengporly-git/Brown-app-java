package com.example.browncoffee.screen.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.browncoffee.R;
import com.example.browncoffee.adapter.DessertAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class DessertDetailActivity extends AppCompatActivity {
    TabLayout tabLayoutDessert;
    TabItem tabCake, tabBakery;
    ViewPager viewPager;
    ImageView imageViewBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert_detail);
        tabLayoutDessert = findViewById(R.id.tabLayout_dessert);
        tabCake = findViewById(R.id.tab_cake);
        tabBakery = findViewById(R.id.tab_bakery);

        viewPager = findViewById(R.id.viewPager);
        imageViewBack = findViewById(R.id.iv_back_merchandise);

        DessertAdapter dessertAdapter = new DessertAdapter(getSupportFragmentManager(), tabLayoutDessert.getTabCount());
        viewPager.setAdapter(dessertAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutDessert));
        tabLayoutDessert.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
