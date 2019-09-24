package com.example.browncoffee.screen.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.browncoffee.R;
import com.example.browncoffee.adapter.StoreAdapter;
import com.example.browncoffee.model.StoreModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StoreFragment extends Fragment {


    public StoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new StoreAdapter(list));
        return view;
    }

    private List<StoreModel> list = new ArrayList<>(Arrays.asList(
            new StoreModel(R.drawable.brown1, R.string.fb_brown_coffee, "Brown 1 (Pencil)",
                    "#17 St. 214 (Near Pencil Supermarket and ICS), Boeng Raing, Khan Daun Penh", "(855) 69 697 079"),
            new StoreModel(R.drawable.brown2, R.string.fb_brown_coffee, "Brown 2 (51)",
                    "St. 51 Corner 302 Near British International School", "(855) 69 737 567"),
            new StoreModel(R.drawable.brown3, R.string.fb_brown_coffee, "Brown 3 (57)",
                    "#13 St. 57 Corner 294, Boengkengkang 1, Khan Boengkengkong", "(855) 70 257 474"),
            new StoreModel(R.drawable.brown4, R.string.fb_brown_coffee, "Brown 4 (Riverside)",
                    "#29 st. 98 corner 1 (Sisowath Quay), Wat Phnom", "(855) 10 917 907"),
            new StoreModel(R.drawable.brown5, R.string.fb_brown_coffee, "Brown 5 (IFL)",
                    "#114 Russian Blvd corner st.259, Tuk Laak 1, Khan Toulkok", "(855) 98 555 221"),
            new StoreModel(R.drawable.brown7, R.string.fb_brown_coffee, "Brown 7 (TK)",
                    "#80 (Lot No B-01) st.315, Boengkak 1, Khan Toulkok", "(855) 98 777 113"),
            new StoreModel(R.drawable.brown8, R.string.fb_brown_coffee, "Brown 8 (Roastery BKK)",
                    "#25 st. 57 Corner 294, Boengkengkang 1, Khan Boengkengkong,)", "(855) 98 888 331"),
            new StoreModel(R.drawable.brown9, R.string.fb_brown_coffee, "Brown 9 (AEON Sothearos)",
                    "Lot 038 AEON Mall, Tonle Basak, Khan Chamkarmorn", "(855) 98 888 692"),
            new StoreModel(R.drawable.brown10, R.string.fb_brown_coffee, "Brown 10 (Bokor)",
                    "#16 Mao Tse Tung corner 71, Tonle Basak, Khan Chamkarmorn", "(855) 98 888 527"),
            new StoreModel(R.drawable.brown11, R.string.fb_brown_coffee, "Brown 11 (Preah Norodom)",
                    "114c Norodom Blvd, Tonle Basak, Khan Chamkarmorn", "(855) 81 777 185"),
            new StoreModel(R.drawable.brown12, R.string.fb_brown_coffee, "Brown 12 (Raintree)",
                    "st 110 near Canadia Tower, Wat Phnom, Khan Daun Penh", "(855) 98 999 318"),
            new StoreModel(R.drawable.brown13, R.string.fb_brown_coffee, "Brown 13 (Roastery SR)",
                    "#260 Street 6, Aranh, Siem Reap", "(855) 98 999 818"),
            new StoreModel(R.drawable.brown14, R.string.fb_brown_coffee, "Brown 14 (Roastery TK)",
                    "#22-23 st. 315, Boengkak 1, Khan Toulkok", "(855) 81 777 318"),
            new StoreModel(R.drawable.brown15, R.string.fb_brown_coffee, "Brown 15 (TTP)",
                    "#175 street 155, Toul Tum Poung 1, Khan Chamkarmorn", "(855) 81 777 315"),
            new StoreModel(R.drawable.brown16, R.string.fb_brown_coffee, "Brown 16 (PPIA)",
                    "Area B-F1 of Departure Hall Russian Blvd, Chom Chao, Khan Dang Kor", "(855) 81 777 312"),
            new StoreModel(R.drawable.brown17, R.string.fb_brown_coffee, "Brown 17 (Parkmall)",
                    "The Park Community Mall #C01 St 1, Niroth, Khan Chba Ampoeu", "(855) 70 667 762"),
            new StoreModel(R.drawable.brown18, R.string.fb_brown_coffee, "Brown 18 (Treeline)",
                    "Street 23 corner Street Achar Sva, Sala Kamroek, Siem Reap", "(855) 70 556 651"),
            new StoreModel(R.drawable.brown19, R.string.fb_brown_coffee, "Brown 19 (AEON Sen Sok)",
                    "AEON Sen Sok City, Phnom Penh Thmei, Khan Sen Sok", "(855) 70 778 850"),
            new StoreModel(R.drawable.brown20, R.string.fb_brown_coffee, "Brown 20 (Midtown)",
                    "Midtown Mall, Teuk Thlar, Khan Sen Sok", "(855) 86 222 506"),
            new StoreModel(R.drawable.brown21, R.string.fb_brown_coffee, "Brown 21 (DTT)",
                    "Lot Number 11 (Diamond Twin Tower, Tonle Basak, Khan Chamkarmorn", "(855) 81 222 536"),
            new StoreModel(R.drawable.brown22, R.string.fb_brown_coffee, "Brown 22 (Roastery Sothearos)",
                    "#104 Sothearos Blvd, Chak Tomuk, Khan Daun Penh", "(855) 98 666 221")


    ));
}
