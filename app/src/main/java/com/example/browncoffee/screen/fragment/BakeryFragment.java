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


public class BakeryFragment extends Fragment {
    private List<MenuModel> list = new ArrayList<>(Arrays.asList(
            new MenuModel("BANANA DANISH", "$1.35", "", "", R.drawable.banana_danish),
            new MenuModel("BOSTOCK", "$1.25", "", "", R.drawable.bostock),
            new MenuModel("KOUIGN-AMANN", "$1.50", "", "", R.drawable.kouign_amann),
            new MenuModel("BLUEBERRY MUFFIN", "$1.25 ", "", "", R.drawable.blueberry_muffin),
            new MenuModel("EGG TART", "$0.50 ", "", "", R.drawable.egg_tart),
            new MenuModel("PAIN AU RAISIN", "$1.30", "", "", R.drawable.pain_au_raisin),
            new MenuModel("GALETTE BRETONNE/CHOCOLATE COOKIE", "$0.50 ", "", "", R.drawable.galette_bretonne_chocolate_cookie),
            new MenuModel("CROISSANT", "$1.25 ", "", "", R.drawable.croissant),
            new MenuModel("WHITE BREAD", "$1.35 ", "", "", R.drawable.white_bread),
            new MenuModel("RAISIN LOAF", "$1.85", "", "", R.drawable.raisin_loaf),
            new MenuModel("WHOLE WHEAT SESAME BREAD", "$1.35", "", "", R.drawable.whole_wheat_sesame_bread),
            new MenuModel("PUMPKIN MUFFIN", "$1.25", "", "", R.drawable.pumpkin_muffin),
            new MenuModel("BANANA CHOCO MUFFIN", "$1.35", "", "", R.drawable.banana_choco_muffin),
            new MenuModel("ALMOND CROISSANT", "$1.35", "", "", R.drawable.almond_croissant),
            new MenuModel("CHOCOLATE CROISSANT", "$1.30", "", "", R.drawable.chocolate_croissant),
            new MenuModel("DOUBLE CHOCO MUFFIN", "$1.35", "", "", R.drawable.double_choco_muffin),
            new MenuModel("PLAIN BAGEL", "$0.85", "", "", R.drawable.plain_bagel),
            new MenuModel("BANANA MUFFIN", "$1.25", "", "", R.drawable.banana_muffin),
            new MenuModel("WHOLE WHEAT BREAD", "$1.35", "", "", R.drawable.whole_wheat_bread),
            new MenuModel("CHOCOLATE MARBLE BREAD", "$1.25", "", "", R.drawable.chocolate_marble_bread)

    ));


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bakery, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuAdapter(list));
        return view;
    }

}
