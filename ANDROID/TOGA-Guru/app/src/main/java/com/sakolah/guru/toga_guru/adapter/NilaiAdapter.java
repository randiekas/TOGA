package com.sakolah.guru.toga_guru.adapter;

/**
 * Created by Randy Eka Setiawan on 5/2/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import com.sakolah.guru.toga_guru.R;
import com.sakolah.guru.toga_guru.model.Nilai;

public class NilaiAdapter extends RecyclerView.Adapter<NilaiAdapter.NilaiViewHolder> {
    private List<Nilai> nilai;
    private int rowLayout;
    private Context context;

    public static class NilaiViewHolder extends RecyclerView.ViewHolder {
        LinearLayout nilaiLayout;
        TextView nilaiDasarpenilaian;
        TextView nilaiPelajaran;
        TextView nilaiAngka;

        public NilaiViewHolder(View v) {
            super(v);
            nilaiLayout = (LinearLayout) v.findViewById(R.id.nilai_layout);
            nilaiDasarpenilaian = (TextView) v.findViewById(R.id.dasarpenilaian);
            nilaiPelajaran = (TextView) v.findViewById(R.id.pelajaran);
            nilaiAngka = (TextView) v.findViewById(R.id.nilaiangka);

        }
    }
    public NilaiAdapter(List<Nilai> nilai, int rowLayout, Context context) {
        this.nilai = nilai;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    // mulai
    @Override
    public NilaiAdapter.NilaiViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new NilaiViewHolder(view);
    }


    @Override
    public void onBindViewHolder(NilaiViewHolder holder, final int position) {
        holder.nilaiDasarpenilaian.setText(nilai.get(position).getDasarpenilaian()+"-"+nilai.get(position).getKkm());
        holder.nilaiPelajaran.setText(nilai.get(position).getPelajaran());
        holder.nilaiAngka.setText(nilai.get(position).getNilaiangka());
    }

    @Override
    public int getItemCount() {
        return nilai.size();
    }

}
