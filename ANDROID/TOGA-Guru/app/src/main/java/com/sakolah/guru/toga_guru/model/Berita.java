package com.sakolah.guru.toga_guru.model;

/**
 * Created by Randy Eka Setiawan on 5/1/2017.
 */

import com.google.gson.annotations.SerializedName;

public class Berita {
    @SerializedName("name") private String name ;
    @SerializedName("link") private String link ;
    @SerializedName("id") private String id ;
    @SerializedName("id_nvigation") private String id_nvigation ;
    @SerializedName("title") private String title ;
    @SerializedName("content") private String content ;
    @SerializedName("created") private String created ;
    @SerializedName("created_format") private String created_format ;
    @SerializedName("image") private String image ;
    public Berita(String name, String link, String id, String id_nvigation, String title, String content, String created, String created_format, String image){
        this.name = name;
        this.link = link;
        this.id = id;
        this.id_nvigation = id_nvigation;
        this.title = title;
        this.content = content;
        this.created = created;
        this.created_format = created_format;
        this.image = image;    }
    public void setName() { this.name = name; }
    public void setLink() { this.link = link; }
    public void setId() { this.id = id; }
    public void setId_nvigation() { this.id_nvigation = id_nvigation; }
    public void setTitle() { this.title = title; }
    public void setContent() { this.content = content; }
    public void setCreated() { this.created = created; }
    public void setCreated_format() { this.created_format = created_format; }
    public void setImage() { this.image = image; }
    public String getName() { return name; }
    public String getLink() { return link; }
    public String getId() { return id; }
    public String getId_nvigation() { return id_nvigation; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getCreated() { return created; }
    public String getCreated_format() { return created_format; }
    public String getImage() { return image; }
}
