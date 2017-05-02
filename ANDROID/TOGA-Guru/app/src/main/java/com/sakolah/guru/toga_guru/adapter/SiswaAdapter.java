package com.sakolah.guru.toga_guru.adapter;

/**
 * Created by Randy Eka Setiawan on 5/2/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sakolah.guru.toga_guru.activity.SiswaActivity;
import com.sakolah.guru.toga_guru.model.Siswa;

import java.util.List;

import com.sakolah.guru.toga_guru.R;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.SiswaViewHolder> {
    private List<Siswa> siswa;
    private int rowLayout;
    private Context context;

    public static class SiswaViewHolder extends RecyclerView.ViewHolder {
        LinearLayout siswaLayout;
        TextView siswaNis;
        TextView siswaNama;

        public SiswaViewHolder(View v) {
            super(v);
            siswaLayout = (LinearLayout) v.findViewById(R.id.siswa_layout);
            siswaNis= (TextView) v.findViewById(R.id.nis);
            siswaNama= (TextView) v.findViewById(R.id.nama);

        }
    }
    public SiswaAdapter(List<Siswa> siswa, int rowLayout, Context context) {
        this.siswa = siswa;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    // mulai
    @Override
    public SiswaAdapter.SiswaViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new SiswaViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SiswaViewHolder holder, final int position) {
        holder.siswaNis.setText(siswa.get(position).getNis());
        holder.siswaNama.setText(siswa.get(position).getNama());
    }

    @Override
    public int getItemCount() {
        return siswa.size();
    }

}
