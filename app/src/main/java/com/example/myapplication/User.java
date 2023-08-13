package com.example.myapplication;

public class User {

    private String ad,soyad,kimlikNo,telefon,sehir;

    public User() {

    }

    public User(String ad, String soyad, String kimlikNo, String telefon, String sehir) {
        this.ad = ad;
        this.soyad = soyad;
        this.kimlikNo = kimlikNo;
        this.telefon = telefon;
        this.sehir = sehir;
    }

    public String getAd() {return ad;}

    public String getSoyad() {return soyad;}

    public String getKimlikNo() {return kimlikNo;}

    public  String getTelefon(){return telefon;}

    public  String getSehir(){return sehir;}
}
