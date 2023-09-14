package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;
    Button buttonLogout,buttonRandevuAl, buttonRandevularim, buttonHekimler, buttonAlanlar;
    TextView textView;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        buttonLogout = findViewById(R.id.logout);
        buttonRandevuAl = findViewById(R.id.button_randevu_al);
        buttonRandevularim = findViewById(R.id.button_randevularim);
        buttonAlanlar = findViewById(R.id.alanlar);
        textView = findViewById(R.id.user_details);
        user = auth.getCurrentUser();

        if (user == null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);

        }

        else{
            textView.setText(user.getEmail());

        }

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

            }
        });
        buttonRandevuAl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RandevuAl.class);
                startActivity(intent);

            }
        });

        buttonRandevularim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), Randevularim.class);
               startActivity(intent);
            }
        });


        buttonAlanlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Alanlar.class);
                startActivity(intent);
            }
        });

    }
}