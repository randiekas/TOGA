package com.sakolah.guru.toga_guru.adapter;

/**
 * Created by Randy Eka Setiawan on 5/1/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sakolah.guru.toga_guru.model.Pertanyaan;

import java.util.List;

import com.sakolah.guru.toga_guru.R;

public class PertanyaanAdapter extends RecyclerView.Adapter<PertanyaanAdapter.PertanyaanViewHolder> {
    private List<Pertanyaan> pertanyaan;
    private int rowLayout;
    private Context context;

    public static class PertanyaanViewHolder extends RecyclerView.ViewHolder {
        LinearLayout pertanyaanLayout;
        TextView pertanyaanName;
        TextView pertanyaanNomor_induk;
        TextView pertanyaanAsk;
        TextView pertanyaanCategory;

        public PertanyaanViewHolder(View v) {
            super(v);
            pertanyaanLayout = (LinearLayout) v.findViewById(R.id.pertanyaan_layout);
            pertanyaanName = (TextView) v.findViewById(R.id.name);
            pertanyaanNomor_induk = (TextView) v.findViewById(R.id.nomor_induk);
            pertanyaanAsk = (TextView) v.findViewById(R.id.ask);
            pertanyaanCategory = (TextView) v.findViewById(R.id.category);
        }
    }
    public PertanyaanAdapter(List<Pertanyaan> pertanyaan, int rowLayout, Context context) {
        this.pertanyaan = pertanyaan;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    // mulai
    @Override
    public PertanyaanAdapter.PertanyaanViewHolder onCreateViewHolder(ViewGroup parent,
                                                                     int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new PertanyaanViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PertanyaanViewHolder holder, final int position) {
        holder.pertanyaanAsk.setText(pertanyaan.get(position).getAsk());
        holder.pertanyaanName.setText(pertanyaan.get(position).getName());
        holder.pertanyaanCategory.setText(pertanyaan.get(position).getCategory());
        holder.pertanyaanNomor_induk.setText(pertanyaan.get(position).getNomor_induk());
    }

    @Override
    public int getItemCount() {
        return pertanyaan.size();
    }

}
