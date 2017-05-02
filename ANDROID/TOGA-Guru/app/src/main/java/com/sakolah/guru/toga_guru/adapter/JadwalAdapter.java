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

import com.sakolah.guru.toga_guru.model.Jadwal;

import java.util.List;

import com.sakolah.guru.toga_guru.R;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder> {
    private List<Jadwal> jadwal;
    private int rowLayout;
    private Context context;

    public static class JadwalViewHolder extends RecyclerView.ViewHolder {
        LinearLayout jadwalLayout;
        TextView jadwalHari;
        TextView jadwalJam;
        TextView jadwalKelas;
        // TextView movieTitle;

        public JadwalViewHolder(View v) {
            super(v);
            jadwalLayout = (LinearLayout) v.findViewById(R.id.jadwal_layout);
            jadwalHari = (TextView) v.findViewById(R.id.hari);
            jadwalJam = (TextView) v.findViewById(R.id.jam);
            jadwalKelas= (TextView) v.findViewById(R.id.kelas);

        }
    }
    public JadwalAdapter(List<Jadwal> jadwal, int rowLayout, Context context) {
        this.jadwal = jadwal;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    // mulai
    @Override
    public JadwalAdapter.JadwalViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new JadwalViewHolder(view);
    }


    @Override
    public void onBindViewHolder(JadwalViewHolder holder, final int position) {
        if(!jadwal.get(position).getSENIN().equals(""))
        {
            holder.jadwalHari.append("SENIN ");
            holder.jadwalKelas.setText(jadwal.get(position).getSENIN());
        }
        if(!jadwal.get(position).getSELASA().equals(""))
        {
            holder.jadwalHari.append("SELASA ");
            holder.jadwalKelas.setText(jadwal.get(position).getSELASA());
        }
        if(!jadwal.get(position).getRABU().equals(""))
        {
            holder.jadwalHari.append("RABU ");
            holder.jadwalKelas.setText(jadwal.get(position).getRABU());
        }
        if(!jadwal.get(position).getKAMIS().equals(""))
        {
            holder.jadwalHari.append("KAMIS ");
            holder.jadwalKelas.setText(jadwal.get(position).getKAMIS());
        }
        if(!jadwal.get(position).getJUMAT().equals(""))
        {
            holder.jadwalHari.append("JUMAT ");
            holder.jadwalKelas.setText(jadwal.get(position).getJUMAT());
        }
        if(!jadwal.get(position).getSABTU().equals(""))
        {
            holder.jadwalHari.append("SABTU ");
            holder.jadwalKelas.setText(jadwal.get(position).getSABTU());
        }
        if(!jadwal.get(position).getMINGGU().equals(""))
        {
            holder.jadwalHari.setText("MINGGU ");
            holder.jadwalKelas.setText(jadwal.get(position).getMINGGU());
        }
        holder.jadwalJam.setText(jadwal.get(position).getJam());

    }

    @Override
    public int getItemCount() {
        return jadwal.size();
    }

}
