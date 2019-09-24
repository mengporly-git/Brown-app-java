package com.example.browncoffee.screen.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.browncoffee.R;
import com.example.browncoffee.adapter.MenuAdapter;
import com.example.browncoffee.adapter.PromotionAdapter;
import com.example.browncoffee.model.MenuModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColdDrinkFragment extends Fragment {
    private List<MenuModel> list = new ArrayList<>(Arrays.asList(
            new MenuModel("ICED AMERICANO", "$2.40", "$3.35", "$3.75", R.drawable.iced_americano),
            new MenuModel("ICED CAFFE LATTE", "$2.65", "$3.65", "$4.00", R.drawable.iced_caffe_latte),
            new MenuModel("ICED GREEN TEA LATTE", "$2.85", "$3.85", "$4.25", R.drawable.iced_green_tea_latte),
            new MenuModel("ICED MOCHA", "$2.75", "$3.75", "$4.25", R.drawable.iced_mocha),
            new MenuModel("ICED CARAMEL MACCHIATO", "$2.75", "$3.65", "$4.25", R.drawable.iced_caramel_macchiato),
            new MenuModel("PALM DOLCE", "$2.85", "$3.65", "$4.00", R.drawable.palm_dolce),
            new MenuModel("BROWN ICED LATTE", "$2.70", "$3.65", "$4.00", R.drawable.brown_iced_latte),
            new MenuModel("ICED CAPPUCCINO", "$2.70", "$3.65", "$4.00", R.drawable.iced_cappuccino),
            new MenuModel("ICED CHOCOLATE", "$2.75", "$3.65", "$4.00", R.drawable.iced_chocolate),
            new MenuModel("ICED CONDENSED MILK COFFEE", "$2.35", "$3.25", "$3.90", R.drawable.iced_condensed_milk_coffee),
            new MenuModel("ICED CARAMEL LATTE", "$2.85", "$3.65", "$4.00", R.drawable.iced_caramel_latte),
            new MenuModel("ICED VANILLA LATTE", "$2.85", "$3.65", "$4.00", R.drawable.iced_vanilla_latte)

    ));


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cold_drink, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuAdapter(list));
        return view;
    }

}
