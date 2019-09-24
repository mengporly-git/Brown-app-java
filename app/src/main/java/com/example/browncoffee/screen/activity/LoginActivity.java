package com.example.browncoffee.screen.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.browncoffee.R;
import com.example.browncoffee.util.DialogUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvSignUp, tvForgotPass;
    private ImageView imageViewClose;
    private FirebaseAuth mAuth;
    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeUI();
        mAuth = FirebaseAuth.getInstance();
        setupListener();
    }

    private void initializeUI() {
        mDialog = DialogUtil.progressDialog(this);
        tvSignUp = findViewById(R.id.tv_sign_up);
        imageViewClose = findViewById(R.id.iv_close);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        tvForgotPass = findViewById(R.id.tv_forgot_pass);
    }

    private void setupListener() {
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
        tvForgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                final View itemView = getLayoutInflater().inflate(R.layout.dialog_reset_password, null);
                builder.setTitle("Forgot Password");
                builder.setView(itemView);
                Button button = itemView.findViewById(R.id.btn_send);
                final EditText editText = itemView.findViewById(R.id.et_send_email);
                final AlertDialog dialog = builder.create();
                dialog.show();
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (editText.getText().toString().isEmpty()) {
                            editText.setError("Please enter your Email!");
                            editText.requestFocus();
                            return;
                        }
                        if (!Patterns.EMAIL_ADDRESS.matcher(editText.getText()).matches()) {
                            editText.setError("Invalid Email!");
                            editText.requestFocus();
                            return;
                        }
                        mAuth.sendPasswordResetEmail(editText.getText().toString());
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    private void loginUser() {
        String email, password;
        email = etEmail.getText().toString();
        password = etPassword.getText().toString();

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Please enter your Email!");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Invalid email!");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Please enter your Password!");
            return;
        }
        mDialog.show();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            finish();
                            mDialog.dismiss();
                            return;
                        }
                        mDialog.dismiss();
                        new AlertDialog.Builder(LoginActivity.this)
                                .setTitle("Error")
                                .setMessage(task.getException().getMessage())
                                .setIcon(R.drawable.ic_error)
                                .setPositiveButton("OK", null)
                                .show();
                    }
                });
    }
}
