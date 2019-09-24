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


public class SandwichFragment extends Fragment {
    private List<MenuModel> list = new ArrayList<>(Arrays.asList(
            new MenuModel("CHICKEN TONKATSU", "$3.95", "", "", R.drawable.chicken_tonkatsu),
            new MenuModel("BEEF MUSHROOM PANINI", "$4.25", "", "", R.drawable.beef_mushroom_panini),
            new MenuModel("CRISPY PARMESAN CHICKEN", "$4.15", "", "", R.drawable.crispy_parmesan_chicken),
            new MenuModel("ROASTED BEEF SANDWICH", "$4.25", "", "", R.drawable.roasted_beef_sandwich),
            new MenuModel("CARAMELIZED TUNA", "$3.95", "", "", R.drawable.caramelized_tuna),
            new MenuModel("NACHOS BEEF", "$4.15", "", "", R.drawable.nachos_beef),
            new MenuModel("CUBAN SANDWICH", "$3.95", "", "", R.drawable.cuban_sandwich),
            new MenuModel("CHICKEN CORDON BLEU", "$4.15", "", "", R.drawable.chicken_cordon_bleu)

    ));


    public SandwichFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sandwich, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuAdapter(list));
        return view;
    }
}
