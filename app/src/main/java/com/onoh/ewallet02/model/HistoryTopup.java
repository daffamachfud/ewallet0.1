package com.onoh.ewallet02.model;

public class HistoryTopup {

    private String tanggal;
    private String waktu;
    private String tipeTopup;
    private String nominal;
    private String status;
    private String idTransaksi;


    public HistoryTopup() {
    }

    public HistoryTopup(String tanggal, String waktu, String tipeTopup, String nominal, String status, String idTransaksi) {
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.tipeTopup = tipeTopup;
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

    public String getTipeTopup() {
        return tipeTopup;
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

    public void setTipeTopup(String tipeTopup) {
        this.tipeTopup = tipeTopup;
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