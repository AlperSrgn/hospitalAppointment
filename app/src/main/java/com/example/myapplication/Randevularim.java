package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Randevularim extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private FirebaseUser mUser;
    TextView textViewAd, textViewSoyad, textViewAlan, textViewHastane, textViewTarih, textViewSaat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randevularim);

        textViewAd = findViewById(R.id.dbAd);
        textViewSoyad = findViewById(R.id.dbSoyad);
        textViewAlan = findViewById(R.id.dbAlan);
        textViewHastane = findViewById(R.id.dbHastane);
        textViewTarih = findViewById(R.id.dbTarih);
        textViewSaat = findViewById(R.id.dbSaat);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        readData();

    }
    public void readData(){
        mUser = mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("users").child(mUser.getUid());

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                textViewAd.setText(snapshot.child("ad").getValue().toString());
                textViewSoyad.setText(snapshot.child("soyad").getValue().toString());
                textViewAlan.setText(snapshot.child("alan").getValue().toString());
                textViewHastane.setText(snapshot.child("hastane").getValue().toString());
                textViewTarih.setText(snapshot.child("tarih").getValue().toString());
                textViewSaat.setText(snapshot.child("saat").getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Randevularim.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}