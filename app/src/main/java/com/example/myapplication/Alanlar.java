package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Alanlar extends AppCompatActivity {

    private ListView listView;
    private Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alanlar);

        listView = findViewById(R.id.alanListesi);
        btnMenu = findViewById(R.id.anaMenu);

        ArrayList<String> alanlar = new ArrayList<>();


        alanlar.add("Acil Tıp");
        alanlar.add("Adli Tıp");
        alanlar.add("Aile Hekimliği");
        alanlar.add("Anatomi");
        alanlar.add("Anesteziyoloji ve Reanimasyon");
        alanlar.add("Askeri Sağlık Hizmetleri");
        alanlar.add("Beyin ve Sinir Cerrahisi");
        alanlar.add("Çocuk Cerrahisi");
        alanlar.add("Çocuk Sağlığı ve Hastalıkları");
        alanlar.add("Çocuk ve Ergen Ruh Sağlığı ve Hastalıkları");
        alanlar.add("Deri ve Zührevi Hastalıkları");
        alanlar.add("Enfeksiyon Hastalıkları ve Klinik Mikrobiyoloji");
        alanlar.add("Fiziksel Tıp ve Rehabilitasyon");
        alanlar.add("Fizyoloji");
        alanlar.add("Genel Cerrahi");
        alanlar.add("Göğüs Cerrahisi");
        alanlar.add("Göğüs Hastalıkları");
        alanlar.add("Göz Hastalıkları");
        alanlar.add("Halk Sağlığı");
        alanlar.add("Hava ve Uzay Hekimliği");
        alanlar.add("Histoloji ve Embriyoloji");
        alanlar.add("İç Hastalıkları");
        alanlar.add("Kadın Hastalıkları ve Doğum");
        alanlar.add("Kalp ve Damar Cerrahisi");
        alanlar.add("Kardiyoloji");
        alanlar.add("Kulak Burun Boğaz Hastalıkları");
        alanlar.add("Nöroloji");
        alanlar.add("Nükleer Tıp");
        alanlar.add("Ortopedi ve Travmatoloji");
        alanlar.add("Plastik, Rekonstrüktif ve Estetik Cerrahi");
        alanlar.add("Radyasyon Onkolojisi");
        alanlar.add("Radyoloji");
        alanlar.add("Ruh Sağlığı ve Hastalıkları");
        alanlar.add("Spor Hekimliği");
        alanlar.add("Sualtı Hekimliği ve Hiperbarik Tıp");
        alanlar.add("Tıbbi Biyokimya");
        alanlar.add("Tıbbi Ekoloji ve Hidroklimatoloji");
        alanlar.add("Tıbbi Farmakoloji");
        alanlar.add("Tıbbi Genetik");
        alanlar.add("Tıbbi Mikrobiyoloji");
        alanlar.add("Tıbbi Patoloji");
        alanlar.add("Üroloji");


        ArrayAdapter<String> alanAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alanlar);

        listView.setAdapter(alanAdapter);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


    }
}