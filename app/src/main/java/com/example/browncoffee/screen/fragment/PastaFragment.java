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

public class PastaFragment extends Fragment {
    private List<MenuModel> list = new ArrayList<>(Arrays.asList(
            new MenuModel("SPICY TUNA PASTA", "$4.25", "", "", R.drawable.spicy_tuna_pasta),
            new MenuModel("BUCATINI ALL AMATRICIANA", "$3.75", "", "", R.drawable.bucatini_all_amatriciana),
            new MenuModel("BEEF STROGANOFF SPAGHETTI", "$4.25", "", "", R.drawable.beef_stroganoff_spaghetti),
            new MenuModel("PRAWN TOM YUM LINGUINE", "$4.25", "", "", R.drawable.prawn_tom_yum_linguine),
            new MenuModel("CARBONARA SPAGHETTI", "$4.25", "", "", R.drawable.carbonara_spaghetti),
            new MenuModel("CHICKEN PICCATA PASTA", "$4.25", "", "", R.drawable.chicken_piccata_pasta)

    ));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pasta, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MenuAdapter(list));
        return view;
    }
}
