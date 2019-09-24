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


public class MerchandiseFragment extends Fragment {
    private List<MenuModel> list = new ArrayList<>(Arrays.asList(
            new MenuModel("KEEP CUP-MEDIUM BREW ROAST", "17.99 ", "", "", R.drawable.keep_cup_meduim_brew_roast),
            new MenuModel("KEEP CUP-MEDIUM BREW PRESS", "17.99", "", "", R.drawable.keep_cup_meduim_brew_press),
            new MenuModel("BROWN MIIR CAMP CUP", "21.95", "", "", R.drawable.brown_miir_camp_cup),
            new MenuModel("BROWN MIIR TUMBLER", "21.95", "", "", R.drawable.brown_miir_tumbler),
            new MenuModel("BROWN MIIR BOTTLE", "26.99", "", "", R.drawable.brown_miir_bottle),
            new MenuModel("BROWN MIIR GROWLER", "49.50", "", "", R.drawable.brown_miir_growler)

    ));

    public MerchandiseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_merchandise, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuAdapter(list));
        return view;
    }

}
