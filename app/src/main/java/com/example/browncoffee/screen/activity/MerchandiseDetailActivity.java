package com.example.browncoffee.screen.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.browncoffee.R;
import com.example.browncoffee.adapter.MerchandiseAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MerchandiseDetailActivity extends AppCompatActivity {
    TabLayout tabLayoutMerchandise;
    TabItem tabMerchandise;
    ViewPager viewPager;
    ImageView imageViewBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchandise_detail);
        tabLayoutMerchandise = findViewById(R.id.tabLayout_merchandise);
        tabMerchandise = findViewById(R.id.tab_merchandise);
        viewPager = findViewById(R.id.viewPager);
        imageViewBack = findViewById(R.id.iv_back_merchandise);


        MerchandiseAdapter merchandiseAdapter = new MerchandiseAdapter(getSupportFragmentManager(), tabLayoutMerchandise.getTabCount());
        viewPager.setAdapter(merchandiseAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutMerchandise));
        tabLayoutMerchandise.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
