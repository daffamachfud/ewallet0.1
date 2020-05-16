package com.onoh.ewallet02.model;

public class HistoryPembayaran {

    private String tanggal;
    private String waktu;
    private String tipe;
    private String tujuan;
    private String nominal;
    private String status;
    private String idTransaksi;


    public HistoryPembayaran() {
    }

    public HistoryPembayaran(String tanggal, String waktu, String tipe, String tujuan, String nominal, String status, String idTransaksi) {
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.tipe = tipe;
        this.tujuan = tujuan;
        this.nominal = nominal;
        this.status = status;
        this.idTransaksi = idTransaksi;
    }

    //getter


    public String getTanggal() {
        return tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public String getTipe() {
        return tipe;
    }

    public String getTujuan() {
        return tujuan;
    }

    public String getNominal() {
        return nominal;
    }

    public String getStatus() {
        return status;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    //setter

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }


    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

}