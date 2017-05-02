package com.sakolah.guru.toga_guru.model;

/**
 * Created by Randy Eka Setiawan on 5/1/2017.
 */

import com.google.gson.annotations.SerializedName;

public class Pertanyaan {
    @SerializedName("id") private String id ;
    @SerializedName("id_profile") private String id_profile ;
    @SerializedName("name") private String name ;
    @SerializedName("nomor_induk") private String nomor_induk ;
    @SerializedName("type") private String type ;
    @SerializedName("id_ask_category") private String id_ask_category ;
    @SerializedName("ask") private String ask ;
    @SerializedName("point") private String point ;
    @SerializedName("answered") private String answered ;
    @SerializedName("solved") private String solved ;
    @SerializedName("created") private String created ;
    @SerializedName("category") private String category ;
    @SerializedName("bg") private String bg ;
    @SerializedName("answer") private String answer ;
    @SerializedName("user_answer") private String user_answer ;
    public Pertanyaan(String id, String id_profile, String name, String nomor_induk, String type, String id_ask_category, String ask, String point, String answered, String solved, String created, String category, String bg, String answer, String user_answer){
        this.id = id;
        this.id_profile = id_profile;
        this.name = name;
        this.nomor_induk = nomor_induk;
        this.type = type;
        this.id_ask_category = id_ask_category;
        this.ask = ask;
        this.point = point;
        this.answered = answered;
        this.solved = solved;
        this.created = created;
        this.category = category;
        this.bg = bg;
        this.answer = answer;
        this.user_answer = user_answer;    }
    public void setId() { this.id = id; }
    public void setId_profile() { this.id_profile = id_profile; }
    public void setName() { this.name = name; }
    public void setNomor_induk() { this.nomor_induk = nomor_induk; }
    public void setType() { this.type = type; }
    public void setId_ask_category() { this.id_ask_category = id_ask_category; }
    public void setAsk() { this.ask = ask; }
    public void setPoint() { this.point = point; }
    public void setAnswered() { this.answered = answered; }
    public void setSolved() { this.solved = solved; }
    public void setCreated() { this.created = created; }
    public void setCategory() { this.category = category; }
    public void setBg() { this.bg = bg; }
    public void setAnswer() { this.answer = answer; }
    public void setUser_answer() { this.user_answer = user_answer; }
    public String getId() { return id; }
    public String getId_profile() { return id_profile; }
    public String getName() { return name; }
    public String getNomor_induk() { return nomor_induk; }
    public String getType() { return type; }
    public String getId_ask_category() { return id_ask_category; }
    public String getAsk() { return ask; }
    public String getPoint() { return point; }
    public String getAnswered() { return answered; }
    public String getSolved() { return solved; }
    public String getCreated() { return created; }
    public String getCategory() { return category; }
    public String getBg() { return bg; }
    public String getAnswer() { return answer; }
    public String getUser_answer() { return user_answer; }
}
