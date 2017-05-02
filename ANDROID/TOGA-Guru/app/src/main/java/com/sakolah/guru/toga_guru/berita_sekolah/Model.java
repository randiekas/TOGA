package com.sakolah.guru.toga_guru.berita_sekolah;

/**
 * Created by Randy Eka Setiawan on 3/18/2017.
 */

public class Model {
    private String name;
    private int numOfSongs;
    private int thumbnail;

    public Model() {
    }

    public Model(String name, int numOfSongs, int thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
