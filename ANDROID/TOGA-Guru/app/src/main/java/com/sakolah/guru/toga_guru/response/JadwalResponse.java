package com.sakolah.guru.toga_guru.response;

/**
 * Created by Randy Eka Setiawan on 5/1/2017.
 */

import com.google.gson.annotations.SerializedName;
import com.sakolah.guru.toga_guru.model.Jadwal;

import java.util.List;

public class JadwalResponse {
    @SerializedName("page") private int page;
    @SerializedName("results") private List<Jadwal> results;
    @SerializedName("total_results") private int totalResults;
    @SerializedName("total_pages") private int totalPages;

    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }
    public List<Jadwal> getResults() { return results; }
    public void setResults(List<Jadwal> results) { this.results = results; }
    public int getTotalResults() { return totalResults; }
    public void setTotalResults(int totalResults) { this.totalResults = totalResults; }
    public int getTotalPages() { return totalPages; }
    public void setTotalPages(int totalPages) { this.totalPages = totalPages; }
}
