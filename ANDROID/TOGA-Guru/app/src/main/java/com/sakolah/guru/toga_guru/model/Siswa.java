package com.sakolah.guru.toga_guru.model;

/**
 * Created by Randy Eka Setiawan on 5/2/2017.
 */

import com.google.gson.annotations.SerializedName;

public class Siswa {
    @SerializedName("nis") private String nis ;
    @SerializedName("nama") private String nama ;
    public Siswa(String nis, String nama){
        this.nis = nis;
        this.nama = nama;    }
    public void setNis() { this.nis = nis; }
    public void setNama() { this.nama = nama; }
    public String getNis() { return nis; }
    public String getNama() { return nama; }
}
