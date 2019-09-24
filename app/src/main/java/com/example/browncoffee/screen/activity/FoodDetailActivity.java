package com.example.browncoffee.screen.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.browncoffee.R;
import com.example.browncoffee.adapter.FoodAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class FoodDetailActivity extends AppCompatActivity {
    TabLayout tabLayoutFood;
    TabItem tabSandwich, tabBreakfast, tabPasta, tabSalad, tabColdSandwich;
    ViewPager viewPager;
    ImageView imageViewBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        tabLayoutFood = findViewById(R.id.tabLayout_food);
        tabSandwich = findViewById(R.id.tab_sandwich);
        tabBreakfast = findViewById(R.id.tab_breakfast);
        tabPasta = findViewById(R.id.tab_pasta);
        tabSalad = findViewById(R.id.tab_salad);
        tabColdSandwich = findViewById(R.id.tab_cold_sandwich);
        viewPager = findViewById(R.id.viewPager);
        imageViewBack = findViewById(R.id.iv_back_merchandise);

        FoodAdapter foodAdapter = new FoodAdapter(getSupportFragmentManager(), tabLayoutFood.getTabCount());
        viewPager.setAdapter(foodAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutFood));
        tabLayoutFood.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
