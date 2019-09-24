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


public class SmoothiesFragment extends Fragment {
    private List<MenuModel> list = new ArrayList<>(Arrays.asList(
            new MenuModel("BANANA SMOOTHIES", "$2.85", "$3.75", "$4.25", R.drawable.banana_smoothies),
            new MenuModel("PASSION FRUIT SMOOTHIES", "$2.85", "$3.75", "$4.25", R.drawable.passion_fruit_smoothies),
            new MenuModel("MANGO SMOOTHIES", "$2.85", "$3.75", "$4.25", R.drawable.mango_smoothies),
            new MenuModel("MANGO PASSION SMOOTHIES", "$2.85", "$3.75", "$4.25", R.drawable.mango_passion_smoothies),
            new MenuModel("STRAWBERRY SMOOTHIES", "$2.95", "$3.75", "$4.25", R.drawable.strawberry_smoothies),
            new MenuModel("BLUEBERRY SMOOTHIES", "$2.85", "$3.75", "$4.25", R.drawable.blueberry_smoothies)

    ));


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_smoothies, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuAdapter(list));
        return view;
    }

}
