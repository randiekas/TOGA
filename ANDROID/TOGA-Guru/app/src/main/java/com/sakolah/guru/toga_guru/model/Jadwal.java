package com.sakolah.guru.toga_guru.model;

/**
 * Created by Randy Eka Setiawan on 5/1/2017.
 */

import com.google.gson.annotations.SerializedName;

public class Jadwal {
    @SerializedName("jamke") private String jamke ;
    @SerializedName("jam1") private String jam1 ;
    @SerializedName("jam2") private String jam2 ;
    @SerializedName("jam") private String jam ;
    @SerializedName("SENIN") private String SENIN ;
    @SerializedName("SELASA") private String SELASA ;
    @SerializedName("RABU") private String RABU ;
    @SerializedName("KAMIS") private String KAMIS ;
    @SerializedName("JUMAT") private String JUMAT ;
    @SerializedName("SABTU") private String SABTU ;
    @SerializedName("MINGGU") private String MINGGU ;
    public Jadwal(String jamke, String jam1, String jam2, String jam, String SENIN, String SELASA, String RABU, String KAMIS, String JUMAT, String SABTU, String MINGGU){
        this.jamke = jamke;
        this.jam1 = jam1;
        this.jam2 = jam2;
        this.jam = jam;
        this.SENIN = SENIN;
        this.SELASA = SELASA;
        this.RABU = RABU;
        this.KAMIS = KAMIS;
        this.JUMAT = JUMAT;
        this.SABTU = SABTU;
        this.MINGGU = MINGGU;    }
    public void setJamke() { this.jamke = jamke; }
    public void setJam1() { this.jam1 = jam1; }
    public void setJam2() { this.jam2 = jam2; }
    public void setJam() { this.jam = jam; }
    public void setSENIN() { this.SENIN = SENIN; }
    public void setSELASA() { this.SELASA = SELASA; }
    public void setRABU() { this.RABU = RABU; }
    public void setKAMIS() { this.KAMIS = KAMIS; }
    public void setJUMAT() { this.JUMAT = JUMAT; }
    public void setSABTU() { this.SABTU = SABTU; }
    public void setMINGGU() { this.MINGGU = MINGGU; }
    public String getJamke() { return jamke; }
    public String getJam1() { return jam1; }
    public String getJam2() { return jam2; }
    public String getJam() { return jam; }
    public String getSENIN() { return SENIN; }
    public String getSELASA() { return SELASA; }
    public String getRABU() { return RABU; }
    public String getKAMIS() { return KAMIS; }
    public String getJUMAT() { return JUMAT; }
    public String getSABTU() { return SABTU; }
    public String getMINGGU() { return MINGGU; }
}
