package com.example.browncoffee.screen.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.browncoffee.R;
import com.example.browncoffee.adapter.MenuAdapter;
import com.example.browncoffee.model.MenuModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SaladFragment extends Fragment {
    private List<MenuModel> list = new ArrayList<>(Arrays.asList(
            new MenuModel("CHICKEN SALSA SALAD", "$3.95", "", "", R.drawable.chicken_salad_salad),
            new MenuModel("AROMATIC SALAD", "$3.75", "", "", R.drawable.aromatic_salad),
            new MenuModel("POTTED BEEF SALAD", "$3.95", "", "", R.drawable.potted_beef_salad),
            new MenuModel("TUNA NICOISE SALAD", "$3.95", "", "", R.drawable.tuna_nicoise_salad)

    ));

    public SaladFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_salad, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuAdapter(list));
        return view;
    }

}
