package com.example.browncoffee.screen.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.browncoffee.R;
import com.example.browncoffee.model.PromotionModel;

public class PromotionDetailActivity extends AppCompatActivity {
    private static String tag = "promotion";
    private PromotionModel promotion;
    private TextView textView, textViewDetail;
    private ImageView imageView, imageViewBack;

    public static void start(Context context, PromotionModel promotion) {
        Intent intent = new Intent(context, PromotionDetailActivity.class);
        intent.putExtra(tag, promotion);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion_detail);
        promotion = (PromotionModel) getIntent().getSerializableExtra(tag);
        textView = findViewById(R.id.textView);
        textViewDetail = findViewById(R.id.textView_detail);
        imageView = findViewById(R.id.imageView);
        imageViewBack = findViewById(R.id.iv_back_promotion);

        imageView.setImageDrawable(getDrawable(promotion.getImage()));
        textView.setText(promotion.getTitle());
        textViewDetail.setText(getText(promotion.getDetail()));

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                overridePendingTransition(R.anim.fadeout, R.anim.fadein);
            }
        });

    }

}
