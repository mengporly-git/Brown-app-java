package com.example.browncoffee.screen.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.browncoffee.R;
import com.example.browncoffee.screen.activity.BeverageDetailActivity;
import com.example.browncoffee.screen.activity.CoffeeBeanDetailActivity;
import com.example.browncoffee.screen.activity.DessertDetailActivity;
import com.example.browncoffee.screen.activity.FoodDetailActivity;
import com.example.browncoffee.screen.activity.MerchandiseDetailActivity;


public class HomeFragment extends Fragment {
    private LinearLayout layoutBeverage, layoutDessert, layoutFood, layoutCoffeeBean, layoutMerchandise;
    private View view;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initializeUI();
        setupListener();
        return view;
    }

    private void initializeUI() {
        layoutBeverage = view.findViewById(R.id.layout_beverage);
        layoutDessert = view.findViewById(R.id.layout_dessert);
        layoutFood = view.findViewById(R.id.layout_food);
        layoutCoffeeBean = view.findViewById(R.id.layout_coffee_bean);
        layoutMerchandise = view.findViewById(R.id.layout_merchandise);
    }

    private void setupListener() {
        layoutBeverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), BeverageDetailActivity.class));
            }
        });
        layoutDessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DessertDetailActivity.class));
            }
        });
        layoutFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FoodDetailActivity.class));
            }
        });
        layoutCoffeeBean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), CoffeeBeanDetailActivity.class));
            }
        });
        layoutMerchandise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MerchandiseDetailActivity.class));
            }
        });
    }
}
