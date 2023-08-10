package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RandevuAl extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private EditText EditTextAd,EditTextSoyad,EditTextTcNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randevu_al);

        EditTextAd = findViewById(R.id.ad);
        EditTextSoyad = findViewById(R.id.soyad);
        EditTextTcNo = findViewById(R.id.tc_kimlik_no);

        mDatabase = FirebaseDatabase.getInstance().getReference();

    }


    public void writeNewUser() {
        User user = new User(EditTextAd.getText().toString(),
                EditTextSoyad.getText().toString(),
                EditTextTcNo.getText().toString());

        mDatabase.child("users").child(user.getAd()).setValue(user);
    }

    public void sendData(View view) {
        writeNewUser();
    }


}