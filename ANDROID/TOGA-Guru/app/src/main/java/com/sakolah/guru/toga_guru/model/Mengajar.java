package com.sakolah.guru.toga_guru.model;

/**
 * Created by Randy Eka Setiawan on 5/2/2017.
 */

import com.google.gson.annotations.SerializedName;

public class Mengajar {
    @SerializedName("departemen") private String departemen ;
    @SerializedName("idtingkat") private String idtingkat ;
    @SerializedName("tingkat") private String tingkat ;
    @SerializedName("idtahunajaran") private String idtahunajaran ;
    @SerializedName("tahunajaran") private String tahunajaran ;
    @SerializedName("idsemester") private String idsemester ;
    @SerializedName("semester") private String semester ;
    @SerializedName("idkelas") private String idkelas ;
    @SerializedName("kelas") private String kelas ;
    public Mengajar(String departemen, String idtingkat, String tingkat, String idtahunajaran, String tahunajaran, String idsemester, String semester, String idkelas, String kelas){
        this.departemen = departemen;
        this.idtingkat = idtingkat;
        this.tingkat = tingkat;
        this.idtahunajaran = idtahunajaran;
        this.tahunajaran = tahunajaran;
        this.idsemester = idsemester;
        this.semester = semester;
        this.idkelas = idkelas;
        this.kelas = kelas;    }
    public void setDepartemen() { this.departemen = departemen; }
    public void setIdtingkat() { this.idtingkat = idtingkat; }
    public void setTingkat() { this.tingkat = tingkat; }
    public void setIdtahunajaran() { this.idtahunajaran = idtahunajaran; }
    public void setTahunajaran() { this.tahunajaran = tahunajaran; }
    public void setIdsemester() { this.idsemester = idsemester; }
    public void setSemester() { this.semester = semester; }
    public void setIdkelas() { this.idkelas = idkelas; }
    public void setKelas() { this.kelas = kelas; }
    public String getDepartemen() { return departemen; }
    public String getIdtingkat() { return idtingkat; }
    public String getTingkat() { return tingkat; }
    public String getIdtahunajaran() { return idtahunajaran; }
    public String getTahunajaran() { return tahunajaran; }
    public String getIdsemester() { return idsemester; }
    public String getSemester() { return semester; }
    public String getIdkelas() { return idkelas; }
    public String getKelas() { return kelas; }
}
