package com.onoh.ewallet02.model;



public class Donasi {
    private int photo;
    private String namaDonasi, tanggalDonasi, nominalDonasi, deskripsiDonasi;

    public Donasi() {
    }

    public Donasi(int photo, String namaDonasi, String tanggalDonasi, String nominalDonasi, String deskripsiDonasi) {
        this.photo = photo;
        this.namaDonasi = namaDonasi;
        this.tanggalDonasi = tanggalDonasi;
        this.nominalDonasi = nominalDonasi;
        this.deskripsiDonasi = deskripsiDonasi;
    }

    //getter


    public int getPhoto() {
        return photo;
    }

    public String getNamaDonasi() {
        return namaDonasi;
    }

    public String getTanggalDonasi() {
        return tanggalDonasi;
    }

    public String getNominalDonasi() {
        return nominalDonasi;
    }

    public String getDeskripsiDonasi() {
        return deskripsiDonasi;
    }


    //setter


    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setNamaDonasi(String namaDonasi) {
        this.namaDonasi = namaDonasi;
    }

    public void setTanggalDonasi(String tanggalDonasi) {
        this.tanggalDonasi = tanggalDonasi;
    }

    public void setNominalDonasi(String nominalDonasi) {
        this.nominalDonasi = nominalDonasi;
    }


    public void setDeskripsiDonasi(String deskripsiDonasi) {
        this.deskripsiDonasi = deskripsiDonasi;
    }



}
