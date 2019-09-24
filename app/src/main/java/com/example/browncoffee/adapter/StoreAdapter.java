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
import com.example.browncoffee.screen.activity.StoreDetailActivity;
import com.example.browncoffee.model.StoreModel;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {

    private List<StoreModel> stores;

    public StoreAdapter(List<StoreModel> stores) {
        this.stores = stores;

    }

    @NonNull
    @Override
    public StoreAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_store, parent, false);
        return new MyViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.MyViewHolder holder, int position) {
        holder.bind(stores.get(position));
    }

    @Override
    public int getItemCount() { return stores.size(); }

    class MyViewHolder extends RecyclerView.ViewHolder {
        Context context;
        TextView textViewStore,textViewAddress,textViewNumber,textViewFacebook;
        ImageView imageView;

        private MyViewHolder(@NonNull View view, Context context) {
            super(view);
            this.context = context;
            imageView = view.findViewById(R.id.imageView);
            textViewStore = view.findViewById(R.id.tv_store);
            textViewAddress = view.findViewById(R.id.tv_address);
            textViewNumber = view.findViewById(R.id.tv_number);
            textViewFacebook = view.findViewById(R.id.tv_facebook);
        }

        private void bind(final StoreModel store) {
            imageView.setImageDrawable(context.getDrawable(store.getImage()));
            textViewStore.setText(store.getStore());
            textViewAddress.setText(store.getAddress());
            textViewNumber.setText(store.getNumber());
            textViewFacebook.setText(context.getString(store.getFacebook()));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    StoreDetailActivity.start(context, store);
                }
            });
        }
    }
}
