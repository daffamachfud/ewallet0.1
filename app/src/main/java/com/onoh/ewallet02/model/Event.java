package com.onoh.ewallet02.model;

public class Event {

    private int photo;
    private String namaEvent, namaTempat, tanggalEvent, jenisEvent, deskripsiAcara;


    public Event() {
    }

    public Event(int photo, String namaEvent, String namaTempat, String tanggalEvent, String jenisEvent, String deskripsiAcara) {
        this.photo = photo;
        this.namaEvent = namaEvent;
        this.namaTempat = namaTempat;
        this.tanggalEvent = tanggalEvent;
        this.jenisEvent = jenisEvent;
        this.deskripsiAcara = deskripsiAcara;
    }

    //getter


    public int getPhoto() {
        return photo;
    }

    public String getNamaEvent() {
        return namaEvent;
    }

    public String getNamaTempat() {
        return namaTempat;
    }

    public String getTanggalEvent() {
        return tanggalEvent;
    }

    public String getJenisEvent() {
        return jenisEvent;
    }

    public String getDeskripsiAcara() {
        return deskripsiAcara;
    }

    //setter


    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
    }

    public void setNamaTempat(String namaTempat) {
        this.namaTempat = namaTempat;
    }

    public void setTanggalEvent(String tanggalEvent) {
        this.tanggalEvent = tanggalEvent;
    }


    public void setJenisEvent(String jenisEvent) {
        this.namaEvent = jenisEvent;
    }

    public void setDeskripsiAcara(String deskripsiAcara) {
        this.deskripsiAcara = deskripsiAcara;
    }


}