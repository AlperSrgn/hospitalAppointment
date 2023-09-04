package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Hekimler extends AppCompatActivity {


    private ListView listView;
    private Button btnMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hekimler);

        listView = findViewById(R.id.hekimListesi);
        btnMenu = findViewById(R.id.anaMenu);

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
        hekimler.add("Dr. Mustafa Cihad Çipe - Aile Hekimliği");
        hekimler.add("Dr. Emine Dilek Başman - Dermatoloji");
        hekimler.add("Dr. Gökçen Karahan - Kadın Hastalıkları ve Doğum");
        hekimler.add("Dr. Bülent Tokar - Ortopedi");
        hekimler.add("Dr. Erhan Çay - Kardiyoloji");
        hekimler.add("Dr. Şadi Dalgıç - Plastik Cerrahi");
        hekimler.add("Dr. Beliz Uyğun - Nefroloji");
        hekimler.add("Dr. Boğaçhan Çoban - Göz Hastalıkları");
        hekimler.add("Dr. Nalan Bağçaaltı - Kulak Burun Boğaz");
        hekimler.add("Dr. Esra Nur Danç - Psikoloji");
        hekimler.add("Dr. Nisa Egin - Pediatri");
        hekimler.add("Dr. Jülide Zehra Muslu - Radyoloji");
        hekimler.add("Dr. Caner Hakyemez - Acil Tıp");
        hekimler.add("Dr. Ayhan Topak - Genel Cerrahi");
        hekimler.add("Dr. Mücadİye Şekerli - İç Hastalıkları");
        hekimler.add("Dr. Teslime Nazlı Cirit Koçer - Aile Danışmanlığı");
        hekimler.add("Dr. Hatike Alıcı - Psikiyatri");
        hekimler.add("Dr. Yakup Alkaç - Klinik Psikoloji");
        hekimler.add("Dr. Petek Can Boran - Fizyoterapi ve Rehabilitasyon");
        hekimler.add("Dr. Göksu Küçükbeyazıt - Beslenme ve Diyetetik");
        hekimler.add("Dr. Efkam Demirtaştan - Klinik Farmakoloji");
        hekimler.add("Dr. Sena Şahingöz - Enfeksiyon Hastalıkları");
        hekimler.add("Dr. Yıldız Açıl - Gastroenteroloji");
        hekimler.add("Dr. Burcu Zobu - Nöroloji");
        hekimler.add("Dr. Kemal Kürşat Horasan - Pediatrik Kardiyoloji");
        hekimler.add("Dr. Nevriye Yüngül - Hematoloji");
        hekimler.add("Dr. Bercis Kılduk - Onkoloji");
        hekimler.add("Dr. Sudem Biçkes - Ortopedik Cerrahi");
        hekimler.add("Dr. Hanife Tuğçe Kurtoğlu - Ruh Sağlığı ve Hastalıkları");
        hekimler.add("Dr. Berkan Güre - Kadın Sağlığı Hemşiresi");
        hekimler.add("Dr. Itır Özbeyler - Aile Danışmanlığı");
        hekimler.add("Dr. Yaser Kılıç - Nükleer Tıp");
        hekimler.add("Dr. Ahmet Melih Kılbacak - Fiziksel Tıp ve Rehabilitasyon");
        hekimler.add("Dr. Doğaç Subaşı - Psikoterapi");
        hekimler.add("Dr. Aleyna Düzgün - Romatoloji");
        hekimler.add("Dr. Halil Yarar - Kardiyak Rehabilitasyon");
        hekimler.add("Dr. Miray Özan Sanhal - İç Hastalıkları");
        hekimler.add("Dr. İlknur Karasu - Klinik Mikrobiyoloji");
        hekimler.add("Dr. Fatih Rifat Nizam - Radyoterapi");
        hekimler.add("Dr. Zühal Olgen - Fizyoterapi ve Rehabilitasyon");
        hekimler.add("Dr. Arife Esra Bekar - Nefroloji");
        hekimler.add("Dr. Şahabettin Mirza - Genel Cerrahi");
        hekimler.add("Dr. Mehmet Koray Gökce - Ruh Sağlığı ve Hastalıkları");
        hekimler.add("Dr. Betül Emine Bolkan - Psikolojik Danışmanlık");
        hekimler.add("Dr. Ertunç Onur İzci - Çocuk Ruh Sağlığı");
        hekimler.add("Dr. Burkay Akçay - Dermatoloji");
        hekimler.add("Dr. Cömert Ordulu Şahin - Kardiyoloji");
        hekimler.add("Dr. Ali Peynirci - Kulak Burun Boğaz");
        hekimler.add("Dr. Nazife Oyanık - Göz Hastalıkları");
        hekimler.add("Dr. Sirri Çanka - Aile Hekimliği");
        hekimler.add("Dr. Selma Tokat - Onkoloji");
        hekimler.add("Dr. Muttakİ Özüak - Hematoloji");
        hekimler.add("Dr. Deram Evran - Acil Tıp");
        hekimler.add("Dr. Sevgül Karapinar - Fiziksel Tıp ve Rehabilitasyon");
        hekimler.add("Dr. Hanim Pekel - Beslenme ve Diyetetik");
        hekimler.add("Dr. Hasan Yavuzhan Karabulut - Nükleer Tıp");
        hekimler.add("Dr. Ökkeş Kurşun - Psikiyatri");
        hekimler.add("Dr. Sultan Kanburoğlu - Pediatrik Kardiyoloji");
        hekimler.add("Dr. Emine Ayça Ekiz - Psikoloji");
        hekimler.add("Dr. Mhaidi Kamacı - Nefroloji");
        hekimler.add("Dr. Ufukcan Koçkar - Kadın Hastalıkları ve Doğum");
        hekimler.add("Dr. Gözde Kübra Şerbetçi - Ortopedi");
        hekimler.add("Dr. Feyza Bıyık - Dermatoloji");
        hekimler.add("Dr. Cenk Dağtekin - Acil Tıp");


        ArrayAdapter<String> hekimlerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, hekimler);

        listView.setAdapter(hekimlerAdapter);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}