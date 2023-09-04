package com.example.myapplication;



import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class RandevuAl extends AppCompatActivity {

    FirebaseAuth mAuth;
    private Button BtnTarih;
    private DatePickerDialog datePickerDialog;
    private TextView DateTxt;
    private Calendar calendar;
    private int year, month, dayOfMonth;
    private DatabaseReference mDatabase;
    private TextInputEditText TextInputEditTextAd,TextInputEditTextSoyad,TextInputEditTextTcNo,TextInputEditTextTelefon;
    private Spinner SpinnerSehirler, SpinnerHastaneler, SpinnerSaatler;


    Map<String, ArrayList<String>> HastanelerMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randevu_al);

        mAuth = FirebaseAuth.getInstance();
        TextInputEditTextAd = findViewById(R.id.ad);
        TextInputEditTextSoyad = findViewById(R.id.soyad);
        TextInputEditTextTcNo = findViewById(R.id.tc_kimlik_no);
        TextInputEditTextTelefon = findViewById(R.id.telefon);
        BtnTarih = findViewById(R.id.Btntarih);
        DateTxt = findViewById(R.id.dateTxt);
        SpinnerSehirler = findViewById(R.id.sehir);
        SpinnerHastaneler = findViewById(R.id.hastaneler);
        SpinnerSaatler = findViewById(R.id.saat);


        initializeHastaneler();
        setupSehirlerSpinner();

        mDatabase = FirebaseDatabase.getInstance().getReference();


        BtnTarih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(RandevuAl.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                DateTxt.setText(day + "/" + (month+1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });

    }



    public void writeNewUser() {
        User user = new User(TextInputEditTextAd.getText().toString(),
                TextInputEditTextSoyad.getText().toString(),
                TextInputEditTextTcNo.getText().toString(),
                TextInputEditTextTelefon.getText().toString(),
                DateTxt.getText().toString(),
                SpinnerSehirler.getSelectedItem().toString(),
                SpinnerHastaneler.getSelectedItem().toString(),
                SpinnerSaatler.getSelectedItem().toString());

        FirebaseUser currentUser = mAuth.getCurrentUser();
        mDatabase.child("users").child(currentUser.getUid()).setValue(user);
    }



    public void sendData(View view) {
        writeNewUser();
    }

    private void initializeHastaneler(){
    HastanelerMap = new HashMap<>();


        ArrayList<String> adana = new ArrayList<>();
        adana.add("Adana Şehir Hastanesi");
        adana.add("Adana Numune Eğitim ve Araştırma Hastanesi");
        adana.add("Seyhan Devlet Hastanesi");
        adana.add("Adana Kadın Doğum ve Çocuk Hastalıkları Hastanesi");
        adana.add("Adana Dr. Ekrem Tok Ruh Sağlığı ve Hastalıkları Hastanesi");
        adana.add("Ceyhan Devlet Hastanesi");
        adana.add("Karaisalı Devlet Hastanesi");
        adana.add("Kozan Devlet Hastanesi");
        adana.add("İmamoğlu Devlet Hastanesi");
        adana.add("Pozantı Devlet Hastanesi");
        adana.add("Tufanbeyli Devlet Hastanesi");
        HastanelerMap.put("Adana", adana);


        ArrayList<String> aksaray = new ArrayList<>();
        aksaray.add("Ortaköy Devlet Hastanesi");
        aksaray.add("Eskil Devlet Hastanesi");
        aksaray.add("Gülağaç İlçe Devlet Hastanesi");
        aksaray.add("Güzelyurt Devlet Hastanesi");
        aksaray.add("Ağaçören Devlet Hastanesi");
        aksaray.add("Sarıyahşi Devlet Hastanesi");
        aksaray.add("Aksaray Ağız ve Diş Sağlığı Merkezi");
        HastanelerMap.put("Aksaray", aksaray);


        ArrayList<String> ankara = new ArrayList<>();
        ankara.add("Akyurt Devlet Hastanesi");
        ankara.add("Ayaş Şehit Mehmet Çifci Devlet Hastanesi");
        ankara.add("Bala Devlet Hastanesi");
        ankara.add("Beypazarı Devlet Hastanesi");
        ankara.add("Çubuk Halil Şıvgın Devlet Hastanesi");
        ankara.add("Dr. Nafiz Körez Sincan Devlet Hastanesi");
        ankara.add("Elmadağ Dr. Hulusi Alataş Devlet Hastanesi");
        ankara.add("Etimesgut Şehit Sait Ertürk Devlet Hastanesi");
        ankara.add("Gölbaşı Şehit Ahmet Özsoy Devlet Hastanesi");
        ankara.add("Güdül İlçe Entegre Devlet Hastanesi");
        ankara.add("Haymana Devlet Hastanesi");
        ankara.add("Kahramankazan Devlet Hastanesi");
        ankara.add("Kalecik İlçe Entegre Devlet Hastanesi");
        ankara.add("Kızılcahamam Devlet Hastanesi");
        ankara.add("Mamak Devlet Hastanesi");
        ankara.add("Nallıhan Devlet Hastanesi");
        ankara.add("Polatlı Duatepe Devlet Hastanesi");
        ankara.add("Pursaklar Devlet Hastanesi");
        ankara.add("Şereflikoçhisar Devlet Hastanesi");
        ankara.add("Ankara Beştepe Devlet Hastanesi");
        ankara.add("Beytepe Şehit Murat Erdi Eker Devlet Hastanesi");
        ankara.add("Gazi Mustafa Kemal Mesleki ve Çevresel Hastalıklar Hastanesi");
        ankara.add("29 Mayıs Devlet Hastanesi");
        HastanelerMap.put("Ankara", ankara);


        ArrayList<String> antalya = new ArrayList<>();
        antalya.add("Antalya Atatürk Devlet Hastanesi");
        antalya.add("Antalya Eğitim ve Araştırma Hastanesi");
        antalya.add("Kumluca Devlet Hastanesi");
        HastanelerMap.put("Antalya", antalya);


        ArrayList<String> artvin = new ArrayList<>();
        artvin.add("Artvin Devlet Hastenesi");
        HastanelerMap.put("Artvin", artvin);


        ArrayList<String> aydın = new ArrayList<>();
        aydın.add("Aydın Atatürk Devlet Hastanesi");
        aydın.add("Aydın Devlet Hastanesi");
        HastanelerMap.put("Aydın", aydın);


        ArrayList<String> balıkesir = new ArrayList<>();
        balıkesir.add("Atatürk Devlet Hastanesi");
        balıkesir.add("Balıkesir Devlet Hastanesi");
        balıkesir.add("Balıkesir Göğüs Hastalıkları Hastanesi");
        balıkesir.add("Ayvalık Devlet Hastanesi");
        balıkesir.add("Bandırma Kapıdağ Devlet Hastanesi");
        balıkesir.add("Bigadiç Devlet Hastanesi");
        balıkesir.add("Burhaniye Devlet Hastanesi");
        balıkesir.add("Bandırma Dr. M. Güven Karahan Devlet Hastanesi");
        balıkesir.add("Dursunbey Devlet Hastanesi");
        balıkesir.add("Edremit Devlet Hastanesi");
        balıkesir.add("Erdek Neyyire Sıtkı Devlet Hastanesi");
        balıkesir.add("Gönen Devlet Hastanesi");
        balıkesir.add("Manyas Devlet Hastanesi");
        HastanelerMap.put("Balıkesir", balıkesir);


        ArrayList<String> bursa = new ArrayList<>();
        bursa.add("Bursa Şehir Hastanesi");
        bursa.add("Çekirge Devlet Hastanesi");
        bursa.add("Şevket Yılmaz Eğitim Araştırma Hastanesi");
        bursa.add("Türkan Akyol Göğüs Hastalıkları Hastanesi");
        bursa.add("Yüksek İhtisas Eğitim Araştırma Hastanesi");
        bursa.add("Dörtçelik Çocuk Hastalıkları Hastanesi");
        bursa.add("Zübeyde Hanım Doğumevi");
        bursa.add("Bursa Devlet Hastanesi");
        HastanelerMap.put("Bursa", bursa);


        ArrayList<String> çanakkale = new ArrayList<>();
        çanakkale.add("Çanakkale Mehmet Akif Ersoy Devlet Hastanesi");
        çanakkale.add("Gelibolu Şehit Koray ONAY Devlet Hastanesi");
        çanakkale.add("Lapseki Devlet Hastanesi");
        çanakkale.add("Ayvacık Devlet Hastanesi");
        çanakkale.add("Ezine Devlet Hastanesi");
        çanakkale.add("Bayramiç Devlet Hastanesi");
        çanakkale.add("Çan Devlet Hastanesi");
        çanakkale.add("Yenice Devlet Hastanesi");
        çanakkale.add("Biga Devlet Hastanesi");
        çanakkale.add("Gökçeada Devlet Hastanesi");
        HastanelerMap.put("Çanakkale", çanakkale);


        ArrayList<String> denizli = new ArrayList<>();
        denizli.add("Denizli Devlet Hastanesi");
        denizli.add("Servergazi Devlet Hastanesi");
        HastanelerMap.put("Denizli", denizli);


        ArrayList<String> diyarbakır = new ArrayList<>();
        diyarbakır.add("Diyarbakır Selahaddin Eyyubi Devlet Hastanesi");
        diyarbakır.add("Diyarbakır Çocuk Hastalıkları Hastanesi");
        diyarbakır.add("Diyarbakır Gazi Yaşargil Eğitim ve Araştırma Hastanesi");
        diyarbakır.add("Diyarbakır Kadın ve Doğum Hastanesi");
        diyarbakır.add("Diyarbakır Asker Hastanesi");
        HastanelerMap.put("Diyarbakır", diyarbakır);


        ArrayList<String> edirne = new ArrayList<>();
        edirne.add("Edirne Devlet Hastanesi");
        edirne.add("Keşan Devlet Hastanesi");
        edirne.add("Uzunköprü Devlet Hastanesi");
        edirne.add("İpsala Devlet Hastanesi");
        edirne.add("Havsa İlçe Hastanesi");
        edirne.add("Enez İlçe Hastanesi");
        HastanelerMap.put("Edirne", edirne);


        ArrayList<String> elazığ = new ArrayList<>();
        elazığ.add("Elazığ Eğitim ve Araştırma Hastanesi");
        elazığ.add("Elazığ Kovancılar Devlet Hastanesi");
        elazığ.add("Elazığ Karakoçan Devlet Hastanesi");
        elazığ.add("Fırat Üniversitesi Hastanesi");
        HastanelerMap.put("Elazığ", elazığ);


        ArrayList<String> eskişehir = new ArrayList<>();
        eskişehir.add("Eskişehir Şehir Hastanesi");
        eskişehir.add("Eskişehir Yunusemre Devlet Hastanesi");
        eskişehir.add("Eskişehir Yunusemre Ek Bina (Eski Hava Hastanesi)");
        eskişehir.add("Çifteler İlçe Devlat Hastanesi");
        eskişehir.add("Sivrihisar İlçe Devlet Hastanesi");
        eskişehir.add("Alpu İlçe Devlet Hastanesi");
        eskişehir.add("Mihallıççık İlçe Devlet Hastanesi");
        HastanelerMap.put("Eskişehir", eskişehir);


        ArrayList<String> gaziantep = new ArrayList<>();
        gaziantep.add("Gaziantep Dr. Ersin Aslan Devlet Hastanesi");
        gaziantep.add("Gaziantep 25 Aralık Devlet Hastanesi");
        gaziantep.add("Şehitkamil Devlet Hastanesi");
        gaziantep.add("Çocuk Hastanesi");
        gaziantep.add("75. Yıl Doğum Hastanesi");
        HastanelerMap.put("Gaziantep", gaziantep);


        ArrayList<String> hatay = new ArrayList<>();
        hatay.add("Samandağ Deniz Hastanesi");
        hatay.add("Samandağ Güneypark Hastanesi");
        hatay.add("İskenderun Palmiye Hastanesi");
        hatay.add("İskenderun Gelişim Hastanesi");
        hatay.add("Antakya Defne Hastanesi");
        hatay.add("Kırıkhan Bilim Hastanesi");
        hatay.add("Kırıkhan Can Hastanesi");
        hatay.add("Antakya Akademi Hastanesi");
        hatay.add("Antakya Mozaik Hastanesi");
        hatay.add("Reyhanlı Sevgi Hastanesi");
        HastanelerMap.put("Hatay", hatay);


        ArrayList<String> istanbul = new ArrayList<>();
        istanbul.add("Arnavutköy Devlet Hastanesi");
        istanbul.add("Başakşehir Devlet Hastanesi");
        istanbul.add("Bahçelievler Devlet Hastanesi");
        istanbul.add("Bayrampaşa Devlet Hastanesi");
        istanbul.add("Beşiktaş Sait Çiftçi Devlet Hastanesi");
        istanbul.add("Beykoz Devlet Hastanesi");
        istanbul.add("Büyükçekmece Mimar Sinan Devlet Hastanesi");
        istanbul.add("Çatalca İlyas Çokay Devlet Hastanesi");
        istanbul.add("Esenyurt Necmi Kadıoğlu Devlet Hastanesi");
        istanbul.add("Eyüpsultan Devlet Hastanesi");
        istanbul.add("İstinye Devlet Hastanesi");
        istanbul.add("Kağıthane Devlet Hastanesi");
        istanbul.add("Maltepe Devlet Hastanesi");
        istanbul.add("Pendik Devlet Hastanesi");
        istanbul.add("Tuzla Devlet Hastanesi");
        istanbul.add("Silivri Devlet Hastanesi");
        istanbul.add("Esenler Kadın Doğum ve Çocuk Hastalıkları Hastanesi");
        istanbul.add("Sultanbeyli Devlet Hastanesi");
        istanbul.add("Şile Devlet Hastanesi");
        istanbul.add("Üsküdar Devlet Hastanesi");
        HastanelerMap.put("İstanbul", istanbul);


        ArrayList<String> izmir = new ArrayList<>();
        izmir.add("Aliağa Devlet Hastanesi");
        izmir.add("Alsancak Nevvar Salih İşgören Devlet Hastanesi");
        izmir.add("Bayındır Devlet Hastanesi");
        izmir.add("Bozyaka Eğitim ve Araştırma Hastanesi");
        izmir.add("Buca Seyfi Demirsoy Devlet Hastanesi");
        izmir.add("Çeşme Alper Çizgenakat Devlet Hastanesi");
        izmir.add("Çiğli Devlet Hastanesi");
        izmir.add("Dikili Devlet Hastanesi");
        izmir.add("Dr. Behçet Uz Çocuk Hastanesi");
        izmir.add("Dr. Faruk İlker Bergama Devlet Hastanesi");
        izmir.add("Dr. Suat Seren Göğüs Hastalıkları ve Cerrahisi Eğitim ve Araştırma Hastanesi");
        izmir.add("Eşrefpaşa Hastanesi");
        izmir.add("Foça Devlet Hastanesi");
        izmir.add("Karşıyaka Devlet Hastanesi");
        izmir.add("Kemalpaşa Devlet Hastanesi");
        izmir.add("Menemen Devlet Hastanesi");
        izmir.add("M.Enver Şenerdem Torbalı Devlet Hastanesi");
        izmir.add("Ödemiş Devlet Hastanesi");
        izmir.add("Seferihisar Necat Hepkon Devlet Hastanesi");
        izmir.add("Selçuk Devlet Hastanesi");
        izmir.add("Tepecik Eğitim ve Araştırma Hastanesi");
        izmir.add("Tire Devlet Hastanesi");
        izmir.add("Türkan Özilhan Devlet Hastanesi");
        izmir.add("Urla Devlet Hastanesi");
        HastanelerMap.put("İzmir", izmir);


        ArrayList<String> kayseri = new ArrayList<>();
        kayseri.add("Kayseri Şehir Hastanesi");
        kayseri.add("Kayseri Devlet Hastanesi");
        kayseri.add("Nimet Bayraktar Ağız Ve Diş Sağlığı Hastanesi");
        kayseri.add("İncesu İlçe Devlet Hastanesi");
        kayseri.add("Yahyalı Devlet Hastanesi");
        kayseri.add("Develi Hatice-Muammer Kocatürk Devlet Hastanesi");
        kayseri.add("Bünyan Devlet Hastanesi");
        kayseri.add("Pınarbaşı Devlet Hastanesi");
        kayseri.add("Tomarza Yaşar Karayel İlçe Devlet Hastanesi");
        kayseri.add("Yeşilhisar İlçe Devlet Hastanesi");
        kayseri.add("Sarız İlçe Entegre Devlet Hastanesi");
        kayseri.add("Felahiye İlçe Entegre Devlet Hastanesi");
        kayseri.add("Özvatan İlçe Entegre Devlet Hastanesi");
        kayseri.add("Sarıoğlan İlçe Entegre Devlet Hastanesi");
        kayseri.add("Akkışla İlçe Entegre Devlet Hastanesi");
        HastanelerMap.put("Kayseri", kayseri);


        ArrayList<String> kocaeli = new ArrayList<>();
        kocaeli.add("Kocaeli Devlet Hastanesi");
        kocaeli.add("İzmit Seka Devlet Hastanesi");
        kocaeli.add("Gölcük Deniz Hastanesi");
        kocaeli.add("Gölcük Necati Çelik Devlet Hastanesi");
        kocaeli.add("Gebze Fatih Devlet Hastanesi");
        kocaeli.add("Darıca Farabi Eğitim Araştırma Hastanesi");
        kocaeli.add("Dilovası Devlet Hastanesi");
        kocaeli.add("Gebze Devlet Hastanesi");
        kocaeli.add("Karamürsel Devlet Hastanesi");
        kocaeli.add("Kandıra Ecz.M.Kazım Dinç Devlet Hastanesi");
        kocaeli.add("Körfez Devlet Hastanesi");
        kocaeli.add("Kocaeli Derince Eğitim ve Araştırma Hastanesi");
        HastanelerMap.put("Kocaeli", kocaeli);


        ArrayList<String> konya = new ArrayList<>();
        konya.add("Konya Şehir Hastanesi");
        konya.add("Konya Eğitim ve Araştırma Hastanesi");
        konya.add("Konya Doğumevi ve Çocuk Hastalıkları Hastanesi");
        konya.add("Konya Numune Hastanesi");
        konya.add("Konya Beyhekim Devlet Hastanesi");
        HastanelerMap.put("Konya", konya);


        ArrayList<String> malatya = new ArrayList<>();
        malatya.add("Malatya Devlet Hastanesi");
        HastanelerMap.put("Malatya", malatya);


        ArrayList<String> muğla = new ArrayList<>();
        muğla.add("Muğla Eğitim Araştırma Hastanesi");
        muğla.add("Menteşe Devlet Hastanesi");
        muğla.add("Dalaman Devlet Hastanesi");
        muğla.add("Bodrum Devlet Hastanesi");
        muğla.add("Marmaris Devlet Hastanesi");
        muğla.add("Yatağan Devlet Hastanesi");
        muğla.add("Fethiye Devlet Hastanesi");
        muğla.add("Ortaca Devlet Hastanesi");
        muğla.add("Datça Devlet Hastanesi");
        HastanelerMap.put("Muğla", muğla);


        ArrayList<String> rize = new ArrayList<>();
        rize.add("Güneysu Tenzile Erdoğan İlçe Hastanesi");
        rize.add("Fındıklı Bölge Guatr Araştırma ve Tedavi Merkezi");
        rize.add("Çayeli Devlet Hastanesi");
        rize.add("Kaçkar Devlet Hastanesi");
        rize.add("Rize Devlet Hastanesi");
        HastanelerMap.put("Rize", rize);


        ArrayList<String> samsun = new ArrayList<>();
        samsun.add("Gazi Devlet Hastanesi");
        samsun.add("Çarşamba Devlet Hastanesi");
        samsun.add("Bafra Devlet Hastanesi");
        samsun.add("Vezirköprü Devlet Hastanesi");
        samsun.add("Havza Devlet Hastanesi");
        samsun.add("Kavak Devlet Hastanesi");
        samsun.add("Terme Devlet Hastanesi");
        samsun.add("Alaçam Devlet Hastanesi");
        samsun.add("Samsun Kadın Doğum Ve Çocuk Hastalıkları Hastanesi");
        samsun.add("Samsun Ağız ve Diş Sağlığı Merkezi");
        samsun.add("Samsun Fiziksel Tıp ve Rehabilitasyon Hastalıkları Hastanesi");
        samsun.add("Samsun Göğüs Hastalıkları ve Göğüs Cerrahisi Hastanesi");
        samsun.add("Samsun Ruh Sağlığı ve Hastalıkları Hastanesi");
        samsun.add("Samsun Eğitim ve Araştırma Hastanesi");
        HastanelerMap.put("Samsun", samsun);


        ArrayList<String> sivas = new ArrayList<>();
        sivas.add("Sivas Ağız ve Diş Sağlığı Hastanesi");
        sivas.add("Sivas Numune Hastanesi");
        sivas.add("Sivas Devlet Hastanesi");
        sivas.add("Divriği Sadık Özgür Devlet Hastanesi");
        sivas.add("Gemerek Devlet Hastanesi");
        sivas.add("Gölova Devlet Hastanesi");
        sivas.add("Gürün Devlet Hastanesi");
        sivas.add("İmranlı Devlet Hastanesi");
        sivas.add("Kangal Devlet Hastanesi");
        sivas.add("Koyulhisar Devlet Hastanesi");
        sivas.add("Şarkışla Devlet Hastanesi");
        sivas.add("Suşehri Devlet Hastanesi");
        sivas.add("Yıldızeli Devlet Hastanesi");
        sivas.add("Zara Devlet Hastanesi");
        HastanelerMap.put("Sivas", sivas);


        ArrayList<String> trabzon = new ArrayList<>();
        trabzon.add("Ahi Evren Göğüs Kalp ve Damar Cerrahisi Eğitim ve Araştırma Hastanesi");
        trabzon.add("Akçaabat Haçkalı Baba Devlet Hastanesi");
        trabzon.add("Araklı Bayram Halil Devlet Hastanesi");
        trabzon.add("Ataköy Ruh ve Sinir Hastalıkları Hastanesi");
        trabzon.add("Fatih Devlet Hastanesi");
        trabzon.add("Kanuni Eğitim ve Araştırma Hastanesi");
        trabzon.add("Maçka Ömer Burhanoğlu Fizik Tedavi ve Rehabilitasyon Hastanesi");
        trabzon.add("Of Devlet Hastanesi");
        trabzon.add("Sürmene Devlet Hastanesi");
        trabzon.add("Tonya Devlet Hastanesi");
        trabzon.add("Trabzon Ağız ve Diş Sağlığı Merkezi");
        trabzon.add("Vakfıkebir Devlet Hastanesi");
        trabzon.add("Yavuz Selim Kemik Hastalıkları ve Rehabilitasyon Hastanesi");
        HastanelerMap.put("Trabzon", trabzon);


    }

    private void setupSehirlerSpinner() {
        ArrayAdapter<String> sehirAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, new ArrayList<>(HastanelerMap.keySet()));
        sehirAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerSehirler.setAdapter(sehirAdapter);

        SpinnerSehirler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedSehir = sehirAdapter.getItem(position);
                setUpHastanelerSpinner(selectedSehir);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    private void setUpHastanelerSpinner(String sehir) {
        ArrayAdapter<String> hastaneAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, HastanelerMap.get(sehir));
        hastaneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerHastaneler.setAdapter(hastaneAdapter);
    }

}