package com.sakolah.guru.toga_guru.response;

/**
 * Created by Randy Eka Setiawan on 5/2/2017.
 */

import com.google.gson.annotations.SerializedName;
import com.sakolah.guru.toga_guru.model.Mengajar;

import java.util.List;
public class MengajarResponse {
    @SerializedName("page") private int page;
    @SerializedName("results") private List<Mengajar> results;
    @SerializedName("total_results") private int totalResults;
    @SerializedName("total_pages") private int totalPages;

    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }
    public List<Mengajar> getResults() { return results; }
    public void setResults(List<Mengajar> results) { this.results = results; }
    public int getTotalResults() { return totalResults; }
    public void setTotalResults(int totalResults) { this.totalResults = totalResults; }
    public int getTotalPages() { return totalPages; }
    public void setTotalPages(int totalPages) { this.totalPages = totalPages; }
}
