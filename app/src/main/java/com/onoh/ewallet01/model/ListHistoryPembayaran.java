package com.onoh.ewallet01.model;

public class ListHistoryPembayaran {

    private String tanggal;
    private String tujuan;
    private String nominal;

    public ListHistoryPembayaran() {
    }

    public ListHistoryPembayaran(String tanggal, String tujuan, String nominal) {
        this.tanggal = tanggal;
        this.tujuan = tujuan;
        this.nominal = nominal;
    }

    //getter


    public String getTanggal() {
        return tanggal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public String getNominal() {
        return nominal;
    }

    //setter


    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }
}