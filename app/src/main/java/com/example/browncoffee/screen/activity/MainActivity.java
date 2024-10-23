package com.example.browncoffee.screen.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.browncoffee.R;
import com.example.browncoffee.screen.fragment.HomeFragment;
import com.example.browncoffee.screen.fragment.ProfileFragment;
import com.example.browncoffee.screen.fragment.PromotionFragment;
import com.example.browncoffee.screen.fragment.StoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    final Fragment fragmentHome = new HomeFragment();
    final Fragment fragmentPromotion = new PromotionFragment();
    final Fragment fragmentStore = new StoreFragment();
    final Fragment fragmentProfile = new ProfileFragment();
    final FragmentManager fm = getSupportFragmentManager();
    private TextView textView;
    private RelativeLayout relativeLayout;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BottomNavigationView bnv = findViewById(R.id.bottom_navigation);
        textView = findViewById(R.id.action_bar_label);
        relativeLayout = findViewById(R.id.action_bar);
        fm.beginTransaction().add(R.id.content_main, fragmentHome, "1").commit();

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_home) {
                    fm.beginTransaction().replace(R.id.content_main, fragmentHome).commit();
                    relativeLayout.setVisibility(View.VISIBLE);
                    textView.setBackground(getDrawable(R.drawable.brown_logo));
                    textView.setText("");
                    return true;
                } else if (menuItem.getItemId() == R.id.action_promotion) {
                    fm.beginTransaction().replace(R.id.content_main, fragmentPromotion).commit();
                    relativeLayout.setVisibility(View.VISIBLE);
                    textView.setBackground(getDrawable(R.drawable.brown_logo));
                    textView.setText("");
                    return true;
                } else if (menuItem.getItemId() == R.id.action_store) {
                    fm.beginTransaction().replace(R.id.content_main, fragmentStore).commit();
                    relativeLayout.setVisibility(View.VISIBLE);
                    textView.setText("STORE LIST");
                    textView.setBackground(null);
                    return true;
                } else if (menuItem.getItemId() == R.id.action_profile) {
                    user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null) {
                        relativeLayout.setVisibility(View.VISIBLE);
                        textView.setBackground(getDrawable(R.drawable.brown_logo));
                        textView.setText("");
                        user = FirebaseAuth.getInstance().getCurrentUser();
                        Bundle bundle = new Bundle();
                        bundle.putString("email", user.getEmail());
                        fragmentProfile.setArguments(bundle);
                        fm.beginTransaction().replace(R.id.content_main, fragmentProfile).commit();
                    } else {
                        startActivityForResult(new Intent(getApplicationContext(), LoginActivity.class), 123);
                    }
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (requestCode == 123 && user != null) {
            relativeLayout.setVisibility(View.VISIBLE);
            textView.setBackground(getDrawable(R.drawable.brown_logo));
            textView.setText("");
            fm.beginTransaction().replace(R.id.content_main, fragmentProfile).commit();
        }
    }
}
