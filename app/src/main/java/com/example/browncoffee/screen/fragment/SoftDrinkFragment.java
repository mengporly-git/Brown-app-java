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
import com.example.browncoffee.model.MenuModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoftDrinkFragment extends Fragment {
    private List<MenuModel> list = new ArrayList<>(Arrays.asList(
            new MenuModel("ICED LEMONADE PASSION TEA", "$2.50", "$3.50", "$4.00", R.drawable.ice_lemonade_passion_tea),
            new MenuModel("ICED LEMON TEA", "$2.25", "$3.25", "$3.75", R.drawable.ice_lemon_tea),
            new MenuModel("CARROT", "$2.95", "$3.85", "", R.drawable.carrot),
            new MenuModel("APPLE CARROT", "$2.95", "$3.85", "", R.drawable.apple_carrot),
            new MenuModel("ORANGE", "$2.95", "$3.85", "", R.drawable.orange),
            new MenuModel("RED APPLE", "$2.95", "$3.85", "", R.drawable.red_apple)

    ));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_soft_drink, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuAdapter(list));
        return view;
    }

}
