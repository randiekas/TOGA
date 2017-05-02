package com.sakolah.guru.toga_guru.model;

/**
 * Created by Randy Eka Setiawan on 5/2/2017.
 */

import com.google.gson.annotations.SerializedName;

public class Nilai {
    @SerializedName("nis") private String nis ;
    @SerializedName("nama") private String nama ;
    @SerializedName("pelajaran") private String pelajaran ;
    @SerializedName("dasarpenilaian") private String dasarpenilaian ;
    @SerializedName("kkm") private String kkm ;
    @SerializedName("nilaiangka") private String nilaiangka ;
    @SerializedName("nilaihuruf") private String nilaihuruf ;
    public Nilai(String nis, String nama, String pelajaran, String dasarpenilaian, String kkm, String nilaiangka, String nilaihuruf){
        this.nis = nis;
        this.nama = nama;
        this.pelajaran = pelajaran;
        this.dasarpenilaian = dasarpenilaian;
        this.kkm = kkm;
        this.nilaiangka = nilaiangka;
        this.nilaihuruf = nilaihuruf;    }
    public void setNis() { this.nis = nis; }
    public void setNama() { this.nama = nama; }
    public void setPelajaran() { this.pelajaran = pelajaran; }
    public void setDasarpenilaian() { this.dasarpenilaian = dasarpenilaian; }
    public void setKkm() { this.kkm = kkm; }
    public void setNilaiangka() { this.nilaiangka = nilaiangka; }
    public void setNilaihuruf() { this.nilaihuruf = nilaihuruf; }
    public String getNis() { return nis; }
    public String getNama() { return nama; }
    public String getPelajaran() { return pelajaran; }
    public String getDasarpenilaian() { return dasarpenilaian; }
    public String getKkm() { return kkm; }
    public String getNilaiangka() { return nilaiangka; }
    public String getNilaihuruf() { return nilaihuruf; }
}
