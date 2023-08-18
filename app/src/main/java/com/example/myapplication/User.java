package com.example.myapplication;

public class User {

    private String ad, soyad, kimlikNo, telefon, sehir, hastane, gun, saat;

    public User() {

    }

    public User(String ad, String soyad, String kimlikNo, String telefon, String sehir, String hastane, String gun, String saat) {
        this.ad = ad;
        this.soyad = soyad;
        this.kimlikNo = kimlikNo;
        this.telefon = telefon;
        this.sehir = sehir;
        this.hastane = hastane;
        this.gun = gun;
        this.saat = saat;
    }

    public String getAd() {return ad;}

    public String getSoyad() {return soyad;}

    public String getKimlikNo() {return kimlikNo;}

    public  String getTelefon(){return telefon;}

    public  String getSehir(){return sehir;}

    public  String getHastane(){return hastane;}

    public  String getGun(){return gun;}

    public  String getSaat(){return saat;}
}
