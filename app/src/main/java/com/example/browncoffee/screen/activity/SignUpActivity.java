package com.example.browncoffee.screen.activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.browncoffee.R;
import com.example.browncoffee.util.DialogUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    FirebaseStorage storage;
    StorageReference storageReference;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Uri filePath;
    private ImageView imageView, imageViewBack;
    private EditText etName, etEmail, etPassword, etConfirmPass;
    private Button BtnSignUp;
    private FirebaseAuth mAuth;
    private String name, email;
    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        initializeUI();
        setupListener();
    }

    private void initializeUI() {
        mDialog = DialogUtil.progressDialog(this);
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etConfirmPass = findViewById(R.id.et_confirm_password);
        BtnSignUp = findViewById(R.id.btn_sign_up);
        imageView = findViewById(R.id.imageView);
        imageViewBack = findViewById(R.id.iv_back_sign_up);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void setupListener() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
            }
        });
        BtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerNewUser();

            }
        });
    }

    private void uploadImage() {
        if (filePath != null) {
            String imageName = "UserProfile/" + System.currentTimeMillis();
            final StorageReference ref = storageReference.child(imageName);
            ref.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            addUser(uri.toString());
                        }
                    });

                }
            });
            return;
        }
        addUser("");
    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 11);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode != 11) {
            return;
        }
        if (data != null && data.getData() != null) {
            filePath = data.getData();
            imageView.setImageURI(filePath);
        }
    }

    private void registerNewUser() {
        name = etName.getText().toString();
        email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String cPassword = etConfirmPass.getText().toString();

        if (TextUtils.isEmpty(name)) {
            etName.setError("Please enter your name!");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Please enter your email!");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Invalid email!");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Please enter your password!");
            return;
        } else if (password.length() < 6) {
            etPassword.setError("Your password must be at least 6 characters in length.");
            return;
        }

        if (TextUtils.isEmpty(cPassword)) {
            etConfirmPass.setError("Please enter your confirm password!");
            return;
        } else if (cPassword.length() < 6) {
            etPassword.setError("Your password must be at least 6 characters in length.");
            return;
        }
        if (!cPassword.equals(password)) {
            etPassword.setError("Your password doesn't match!");
            etConfirmPass.setError("Your password doesn't match!");
            return;
        }
        mDialog.show();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            uploadImage();
                            mDialog.dismiss();
                        }
                    }
                });
    }

    private void addUser(String imageUrl) {
        int randomPIN = (int) (Math.random() * 90000) + 1000;
        String val = "" + randomPIN;
        Map<String, Object> user = new HashMap<>();
        user.put("email", email);
        user.put("name", name);
        user.put("image", imageUrl);
        user.put("uid", val);

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

    }
}
