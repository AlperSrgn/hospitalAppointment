package com.example.myapplication;

public class User {

    private String ad,soyad,kimlikNo;

    public User() {

    }

    public User(String ad, String soyad, String kimlikNo) {
        this.ad = ad;
        this.soyad = soyad;
        this.kimlikNo = kimlikNo;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getKimlikNo() {
        return kimlikNo;
    }
}
