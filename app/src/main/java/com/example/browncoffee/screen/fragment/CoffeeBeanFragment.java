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


public class CoffeeBeanFragment extends Fragment {
    private List<MenuModel> list = new ArrayList<>(Arrays.asList(
            new MenuModel("SUMATRA MADHELING (200G)", "$7.00", "", "", R.drawable.sumatra_madheling),
            new MenuModel("ISOURSDEY BLEND (200G)", "$7.00", "", "", R.drawable.soursdey_blend),
            new MenuModel("BROWN BEAN (200G)", "$7.00", "", "", R.drawable.brown_bean),
            new MenuModel("COLUMBIA SUPREMO (200G)", "$12.00", "", "", R.drawable.columbia_supremo)

    ));


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coffee_bean, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuAdapter(list));
        return view;
    }

}
