package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityRandevularimBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Randevularim extends AppCompatActivity {


    ActivityRandevularimBinding binding;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_randevularim);


    binding = ActivityRandevularimBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    binding.randevuAraBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String tcNo = binding.tcKimlikNo.getText().toString();
            if(!tcNo.isEmpty()){
                readData(tcNo);
            }
            else{
                Toast.makeText(getApplicationContext(), "Tc Kimlik Numaranızı Girin", Toast.LENGTH_SHORT).show();
            }
        }
    });

    }

    private void readData(String tcNo) {
        reference = FirebaseDatabase.getInstance().getReference("users");
        reference.child(tcNo).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if(task.isSuccessful()){
                    if(task.getResult().exists()){

                        DataSnapshot dataSnapshot = task.getResult();
                        String ad = String.valueOf(dataSnapshot.child("ad").getValue());
                        String soyad = String.valueOf(dataSnapshot.child("soyad").getValue());
                        String sehir = String.valueOf(dataSnapshot.child("sehir").getValue());
                        String hastane = String.valueOf(dataSnapshot.child("hastane").getValue());
                        String gun = String.valueOf(dataSnapshot.child("gun").getValue());
                        String saat = String.valueOf(dataSnapshot.child("saat").getValue());
                        binding.dbAd.setText(ad);
                        binding.dbSoyad.setText(soyad);
                        binding.dbSehir.setText(sehir);
                        binding.dbHastane.setText(hastane);
                        binding.dbGun.setText(gun);
                        binding.dbSaat.setText(saat);

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Randevu Bulunamadı", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(getApplicationContext(), "İşlem Başarısız",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}