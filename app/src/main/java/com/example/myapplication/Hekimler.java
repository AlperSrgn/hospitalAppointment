package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Hekimler extends AppCompatActivity {


    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hekimler);

        listView = findViewById(R.id.hekimListesi);

        ArrayList<String> hekimler = new ArrayList<>();
        hekimler.add("Dr. Aydan Akpınar - Nöroloji");
        hekimler.add("Dr. Ali Ozan Pekgöz - Kardiyoloji");
        hekimler.add("Dr. Yener Ermenek - Ortopedi");
        hekimler.add("Dr. Bünyamin Elbüken - Psikiyatri");
        hekimler.add("Dr. Derviş Aktaş - Dermatoloji");
        hekimler.add("Dr. Mine Cansu Aldinç - Pediatri");
        hekimler.add("Dr. Fahri Tepedelenlioğlu - Kulak Burun Boğaz");
        hekimler.add("Dr. Bişar Azmaz - Göz Hastalıkları");
        hekimler.add("Dr. Fadime Sevgi Yardımcı - Aile Hekimliği");
        hekimler.add("Dr. Sevde Nur Kulalı - Kadın Hastalıkları ve Doğum");
        hekimler.add("Dr. Hamdi Demirer - Radyoloji");
        hekimler.add("Dr. Reşit Volkan Gündoğan - Üroloji");
        hekimler.add("Dr. Benan Aksöyek - Endokrinoloji");
        hekimler.add("Dr. Rifat Ashad - Enfeksiyon Hastalıkları");
        hekimler.add("Dr. Hüseyin Cahit Kemik - İç Hastalıkları");
        hekimler.add("Dr. Yüksel Uğur Demirelli - Klinik Psikoloji");
        hekimler.add("Dr. Abdulkadir Güre - Acil Tıp");
        hekimler.add("Dr. Müge Toptaş - Fizyoterapi ve Rehabilitasyon");
        hekimler.add("Dr. Meliha Değirmenci - Beslenme ve Diyetetik");
        hekimler.add("Dr. Sebiha İzci - Psikolojik Danışmanlık");
        hekimler.add("Dr. Musacide Zehra Bahar - Çocuk Ruh Sağlığı");
        hekimler.add("Dr. Ali Rıza Geçici - Genel Cerrahi");
        hekimler.add("Dr. Cuma Alğan - Ortopedik Cerrahi");
        hekimler.add("Dr. Rumeyssa Yavuzhan - Psikiyatrist");
        hekimler.add("Dr. Hasan Civan Konuk - Kardiyak Rehabilitasy;on");
        hekimler.add("Dr. Gökcen Polat Çiçek - Hematoloji");
        hekimler.add("Dr. Cahide Arlı - Nükleer Tıp");
        hekimler.add("Dr. Alaaddin Günal - Fiziksel Tıp ve Rehabilitasyon");
        hekimler.add("Dr. Duhan Levent - Psikoterapi");
        hekimler.add("Dr. Elzem Akol - Ruh Sağlığı ve Hastalıkları");
        hekimler.add("Dr. Ülkü Ünalan - Kadın Sağlığı Hemşiresi");
        hekimler.add("Dr. Hatice Nilden Göktepe - Aile Danışmanlığı");
        hekimler.add("Dr. Rezzan Battal - Radyoterapi");
        hekimler.add("Dr. Mürselin Molla - Aile Hekimliği");
        hekimler.add("Dr. İbrahim Fuat Saldıray - Pediatrik Kardiyoloji");
        hekimler.add("Dr. Birsen Ataç - Kulak Burun Boğaz");
        hekimler.add("Dr. Nazire Dündar - Onkoloji");
        hekimler.add("Dr. Gökbek Salman Sever - Psikososyal Rehabilitasyon");
        hekimler.add("Dr. Dila Kalender - Odyoloji");
        hekimler.add("Dr. Zeynep Ezgi Günaydın - Ruh Sağlığı Uzmanı");
        hekimler.add("Dr. Sevil Durgutlu - Nöropsikoloji");
        hekimler.add("Dr. Hayriye Gökçek - Jinekolojik Onkoloji");
        hekimler.add("Dr. Peyvent Çağlayan - Genetik Danışmanlık");
        hekimler.add("Dr. Lal Ateşli - Romatoloji");
        hekimler.add("Dr. Caner Serin - Klinik Farmakoloji");
        hekimler.add("Dr. Müjdat Aşan - Radyoloji");
        hekimler.add("Dr. Öznur Atçeken - Klinik Psikolog");
        hekimler.add("Dr. Baturay Kansu Şahbazoğlu - Gastroenteroloji");
        hekimler.add("Dr. Selim Yurdam - İç Hastalıkları");
        hekimler.add("Dr. Deniz Armağan Kabakuş - Üreme Endokrinolojisi");
        hekimler.add("Dr. Yaşar Barbaros Kızıltuğ - Kardiyak Cerrahi");
        hekimler.add("Dr. Leman Gökbayır - Tıbbi Mikrobiyoloji");
        hekimler.add("Dr. Hüseyin Kalkan Ilgaz - Göz Hastalıkları");
        hekimler.add("Dr. Eyyüp Sabri Kaskalan - Nefroloji");
        hekimler.add("Dr. Seher Özlem Hakyemez - Pediatrik Hematoloji");
        hekimler.add("Dr. Atahan Baysoy - Spor Hekimliği");
        hekimler.add("Dr. Ayşın Bekir - Aile Danışmanlığı");
        hekimler.add("Dr. Şuayip Yenin - Plastik Cerrahi");
        hekimler.add("Dr. Hamdiye Şener - Endokrinoloji");

        ArrayAdapter<String> hekimlerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, hekimler);

        listView.setAdapter(hekimlerAdapter);

    }
}