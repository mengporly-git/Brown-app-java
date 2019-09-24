package com.example.browncoffee.screen.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.browncoffee.R;
import com.example.browncoffee.model.StoreModel;

public class StoreDetailActivity extends AppCompatActivity {
    private static String tag = "store";
    private StoreModel store;
    private ImageView imageView, imageViewBack;
    private TextView textViewStore, textViewAddress, textViewNumber, textViewFacebook;

    public static void start(Context context, StoreModel store) {
        Intent intent = new Intent(context, StoreDetailActivity.class);
        intent.putExtra(tag, store);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);
        store = (StoreModel) getIntent().getSerializableExtra(tag);
        imageView = findViewById(R.id.imageView);
        textViewStore = findViewById(R.id.tv_store);
        textViewAddress = findViewById(R.id.tv_address);
        textViewNumber = findViewById(R.id.tv_number);
        imageViewBack = findViewById(R.id.iv_back_store);

        imageView.setImageDrawable(getDrawable(store.getImage()));
        textViewStore.setText(store.getStore());
        textViewAddress.setText(store.getAddress());
        textViewNumber.setText(store.getNumber());

        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                overridePendingTransition(R.anim.fadeout, R.anim.fadein);

            }
        });
    }
}
