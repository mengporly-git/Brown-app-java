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


public class ColdSandwichFragment extends Fragment {
    private List<MenuModel> list = new ArrayList<>(Arrays.asList(
            new MenuModel("TUNA EGG SANDWICH", "$1.75", "", "", R.drawable.tuna_egg_sandwich),
            new MenuModel("CHICKEN CHEESE SANDWICH", "$1.75", "", "", R.drawable.chicken_cheese_sandwich),
            new MenuModel("BACON HAM CHEESE SANDWICH", "$1.75", "", "", R.drawable.bacon_ham_cheese_sandwich),
            new MenuModel("BACON EGG SANDWICH", "$1.75", "", "", R.drawable.bacon_egg_sandwich)

    ));


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cold_sandwich, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuAdapter(list));
        return view;
    }


}
