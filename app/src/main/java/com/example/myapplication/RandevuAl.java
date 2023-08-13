package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RandevuAl extends AppCompatActivity {


    private DatabaseReference mDatabase;
    private TextInputEditText TextInputEditTextAd,TextInputEditTextSoyad,TextInputEditTextTcNo,TextInputEditTextTelefon;
    Spinner SpinnerSehirler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randevu_al);

        TextInputEditTextAd = findViewById(R.id.ad);
        TextInputEditTextSoyad = findViewById(R.id.soyad);
        TextInputEditTextTcNo = findViewById(R.id.tc_kimlik_no);
        TextInputEditTextTelefon = findViewById(R.id.telefon);
        SpinnerSehirler = findViewById(R.id.sehir);

        mDatabase = FirebaseDatabase.getInstance().getReference();

    }


    public void writeNewUser() {
        User user = new User(TextInputEditTextAd.getText().toString(),
                TextInputEditTextSoyad.getText().toString(),
                TextInputEditTextTcNo.getText().toString(),
                TextInputEditTextTelefon.getText().toString(),
                SpinnerSehirler.getSelectedItem().toString());

        mDatabase.child("users").child("Kimlik No:" + user.getKimlikNo()).setValue(user);
    }

    public void sendData(View view) {
        writeNewUser();
    }


}