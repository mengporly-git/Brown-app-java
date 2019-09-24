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
import com.example.browncoffee.model.PromotionModel;
import com.example.browncoffee.screen.activity.PromotionDetailActivity;

import java.util.List;

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.MyViewHolder> {

    private List<PromotionModel> promotions;

    public PromotionAdapter(List<PromotionModel> promotions) {
        this.promotions = promotions;
    }

    @NonNull
    @Override
    public PromotionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_promotion, parent, false);
        return new MyViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionAdapter.MyViewHolder holder, int position) {
        holder.bind(promotions.get(position));
    }

    @Override
    public int getItemCount() {
        return promotions.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        Context context;
        TextView textView;
        ImageView imageView;

        private MyViewHolder(@NonNull View view, Context context) {
            super(view);
            this.context = context;
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);
        }

        private void bind(final PromotionModel promotion) {
            imageView.setImageDrawable(context.getDrawable(promotion.getImage()));
            textView.setText(promotion.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PromotionDetailActivity.start(context, promotion);
                }
            });
        }
    }
}
