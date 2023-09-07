package com.example.myapplication;

public class User {

    private String ad, soyad, kimlikNo, telefon, tarih, hastane, sehir, saat, alan;

    public User() {

    }

    public User(String ad, String soyad, String kimlikNo, String telefon,
                String tarih, String sehir, String hastane, String alan, String saat) {
        this.ad = ad;
        this.soyad = soyad;
        this.kimlikNo = kimlikNo;
        this.telefon = telefon;
        this.tarih = tarih;
        this.hastane = hastane;
        this.sehir = sehir;
        this.saat = saat;
        this.alan = alan;
    }

    public String getAd() {return ad;}

    public String getSoyad() {return soyad;}

    public String getKimlikNo() {return kimlikNo;}

    public  String getTelefon(){return telefon;}

    public  String getTarih(){return tarih;}

    public  String getHastane(){return hastane;}

    public  String getSehir(){return sehir;}

    public  String getSaat(){return saat;}

    public  String getAlan(){return alan;}
}
