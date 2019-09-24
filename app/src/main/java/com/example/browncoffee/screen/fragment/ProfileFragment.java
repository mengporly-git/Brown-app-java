package com.example.browncoffee.screen.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.browncoffee.R;
import com.example.browncoffee.screen.activity.LoginActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Objects;


public class ProfileFragment extends Fragment {
    final Fragment fragment = new HomeFragment();
    private TextView tvUserName, tvUserID;
    private ImageView imageView;

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        LinearLayout layoutSignOut = view.findViewById(R.id.layout_sign_out);
        tvUserName = view.findViewById(R.id.tv_user_name);
        imageView = view.findViewById(R.id.imageView);
        tvUserID = view.findViewById(R.id.tv_user_id);
        layoutSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivityForResult(new Intent(getContext(), LoginActivity.class), 124);
            }
        });
        fetchData();
        return view;
    }

    private void fetchData() {
        assert getArguments() != null;
        String email = getArguments().getString("email");
        FirebaseFirestore.getInstance().collection("users").whereEqualTo("email", email)
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (queryDocumentSnapshots.getDocuments().size() < 1) return;
                String id = queryDocumentSnapshots.getDocuments().get(0).getData().get("uid").toString();
                String name = queryDocumentSnapshots.getDocuments().get(0).getData().get("name").toString();
                String image = queryDocumentSnapshots.getDocuments().get(0).getData().get("image").toString();
                RequestOptions options = new RequestOptions().placeholder(R.drawable.ic_user);
                Glide.with(getContext()).load(image).apply(options).into(imageView);
                tvUserName.setText(name);
                tvUserID.setText("User ID: " + id);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 124) {
            FragmentManager fm = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }
    }

}
