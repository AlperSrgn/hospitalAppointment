package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    TextInputEditText textInputEditTextEmail;
    Button btnLogin, btnResetPassword;
    FirebaseAuth mAuth;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        textInputEditTextEmail = findViewById(R.id.forgotPassword_email);
        btnLogin = findViewById(R.id.loginNow);
        btnResetPassword = findViewById(R.id.resetPassword);

        mAuth = FirebaseAuth.getInstance();


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });


        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = textInputEditTextEmail.getText().toString().trim();
                if(!TextUtils.isEmpty(email)){
                    resetPassword();
                }
                else{
                    textInputEditTextEmail.setError("Bu alan boş bırakılamaz");
                }
            }
        });


    }

    private void resetPassword(){
        mAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(ForgotPassword.this, "Şifre sıfırlama bağlantınız E-posta adresinize gönderilmiştir", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ForgotPassword.this, Login.class);
                startActivity(intent);
                finish();
            }

        }) .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception error) {
                Toast.makeText(ForgotPassword.this, "Hata: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}