package com.sakolah.guru.toga_guru.rest;

import com.sakolah.guru.toga_guru.response.BeritaResponse;
import com.sakolah.guru.toga_guru.response.JadwalResponse;
import com.sakolah.guru.toga_guru.response.MengajarResponse;
import com.sakolah.guru.toga_guru.response.NilaiResponse;
import com.sakolah.guru.toga_guru.response.PertanyaanResponse;
import com.sakolah.guru.toga_guru.response.SiswaResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("berita/list")
    Call<BeritaResponse> beritaList();

    @FormUrlEncoded
    @POST("jadwal/list")
    Call<JadwalResponse> jadwalList(@Field("nip") String nip);

    @GET("nilai/list_mengajar")
    Call<MengajarResponse> mengajarList();

    @FormUrlEncoded
    @POST("nilai/list_siswa")
    Call<SiswaResponse> siswaList(@Field("idtahunajaran") String idtahunajaran, @Field("idkelas") String idkelas);

    @FormUrlEncoded
    @POST("nilai/list_nilai")
    Call<NilaiResponse> nilaiList(@Field("idkelas") String idtahunajaran, @Field("idsemester") String idkelas, @Field("nis") String nis, @Field("nip") String nip);

    @POST("pertanyaan/list")
    Call<PertanyaanResponse> pertanyaanList();
}
