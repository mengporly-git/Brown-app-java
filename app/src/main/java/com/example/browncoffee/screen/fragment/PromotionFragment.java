package com.example.browncoffee.screen.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.browncoffee.R;
import com.example.browncoffee.adapter.PromotionAdapter;
import com.example.browncoffee.model.PromotionModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PromotionFragment extends Fragment {

    private List<PromotionModel> list = new ArrayList<>(Arrays.asList(
            new PromotionModel("BROWN Delivery Service", R.drawable.promotion1, R.string.promotion_content1),
            new PromotionModel("The Drizzling Rain", R.drawable.promotion2, R.string.promotion_content2),
            new PromotionModel("Free Delivery Service", R.drawable.promotion3, R.string.promotion_content3)
    ));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_promotion, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new PromotionAdapter(list));
        return view;
    }

}
