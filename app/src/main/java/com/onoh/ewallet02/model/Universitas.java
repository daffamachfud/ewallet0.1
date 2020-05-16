package com.onoh.ewallet02.model;

public class Universitas {

    private int photo;
    private String namaUniv;


    public Universitas() {
    }

    public Universitas(int photo, String namaUniv) {
        this.photo = photo;
        this.namaUniv = namaUniv;
    }

    //getter


    public int getPhoto() {
        return photo;
    }

    public String getNamaUniv() {
        return namaUniv;
    }


    //setter


    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setNamaUniv(String namaUniv) {
        this.namaUniv = namaUniv;
    }


}