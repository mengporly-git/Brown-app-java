package com.example.browncoffee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.browncoffee.R;
import com.example.browncoffee.model.MenuModel;
import com.example.browncoffee.model.PromotionModel;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    private List<MenuModel> menus;

    public MenuAdapter(List<MenuModel> menus) {
        this.menus = menus;
    }

    @NonNull
    @Override
    public MenuAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_menu, parent, false);
        return new MyViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MyViewHolder holder, int position) {
        holder.bind(menus.get(position));
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        Context context;
        TextView textView, rPrice, lPrice, gPrice;
        ImageView imageView;

        private MyViewHolder(@NonNull View view, Context context) {
            super(view);
            this.context = context;
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);
            rPrice = view.findViewById(R.id.tv_r_price);
            lPrice = view.findViewById(R.id.tv_l_price);
            gPrice = view.findViewById(R.id.tv_g_price);
        }

        private void bind(final MenuModel menu) {
            imageView.setImageDrawable(context.getDrawable(menu.getImage()));
            textView.setText(menu.getName());
            rPrice.setText(menu.getrPrice());
            lPrice.setText(menu.getlPrice());
            gPrice.setText(menu.getgPrice());

        }
    }
}
