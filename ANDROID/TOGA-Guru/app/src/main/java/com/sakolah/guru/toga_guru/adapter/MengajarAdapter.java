package com.sakolah.guru.toga_guru.adapter;

/**
 * Created by Randy Eka Setiawan on 5/2/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sakolah.guru.toga_guru.activity.BeritaDetailActivity;
import com.sakolah.guru.toga_guru.activity.SiswaActivity;
import com.sakolah.guru.toga_guru.model.Mengajar;

import java.util.List;

import com.sakolah.guru.toga_guru.R;
import com.sakolah.guru.toga_guru.model.Siswa;

public class MengajarAdapter extends RecyclerView.Adapter<MengajarAdapter.MengajarViewHolder> {
    private List<Mengajar> mengajar;
    private int rowLayout;
    private Context context;

    public static class MengajarViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mengajarLayout;
        TextView mengajarDepartemen;
        TextView mengajarTahunajaran;
        TextView mengajarKelas;

        public MengajarViewHolder(View v) {
            super(v);
            mengajarLayout = (LinearLayout) v.findViewById(R.id.mengajar_layout);
            mengajarDepartemen = (TextView) v.findViewById(R.id.departemen);
            mengajarTahunajaran= (TextView) v.findViewById(R.id.tahunajaran);
            mengajarKelas= (TextView) v.findViewById(R.id.kelas);

        }
    }
    public MengajarAdapter(List<Mengajar> mengajar, int rowLayout, Context context) {
        this.mengajar = mengajar;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    // mulai
    @Override
    public MengajarAdapter.MengajarViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MengajarViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MengajarViewHolder holder, final int position) {
        holder.mengajarDepartemen.setText(mengajar.get(position).getDepartemen());
        holder.mengajarTahunajaran.setText(mengajar.get(position).getTahunajaran()+"-"+mengajar.get(position).getSemester());
        holder.mengajarKelas.setText(mengajar.get(position).getKelas());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, berita.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent i;
                i = new Intent(context, SiswaActivity.class);
                i.putExtra("idtahunajaran", mengajar.get(position).getIdtahunajaran());
                i.putExtra("idkelas", mengajar.get(position).getIdkelas());
                i.putExtra("idsemester", mengajar.get(position).getIdsemester());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mengajar.size();
    }

}
