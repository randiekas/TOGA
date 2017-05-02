package com.sakolah.guru.toga_guru.adapter;

/**
 * Created by Randy Eka Setiawan on 5/1/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sakolah.guru.toga_guru.activity.BeritaDetailActivity;
import com.sakolah.guru.toga_guru.model.Berita;
import com.sakolah.guru.toga_guru.R;
import java.util.List;



public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder> {
    private List<Berita> berita;
    private int rowLayout;
    private Context context;

    public static class BeritaViewHolder extends RecyclerView.ViewHolder {
        LinearLayout beritaLayout;
        TextView beritaTitle;
        TextView beritaName;
        TextView beritaCreated;
        TextView beritaContent;

        public BeritaViewHolder(View v) {
            super(v);
            beritaLayout = (LinearLayout) v.findViewById(R.id.berita_layout);
            beritaTitle = (TextView) v.findViewById(R.id.title);
            beritaName= (TextView) v.findViewById(R.id.name);
            beritaCreated= (TextView) v.findViewById(R.id.created);
            beritaContent= (TextView) v.findViewById(R.id.content);

        }
    }
    public BeritaAdapter(List<Berita> berita, int rowLayout, Context context) {
        this.berita = berita;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    // mulai
    @Override
    public BeritaAdapter.BeritaViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new BeritaViewHolder(view);
    }


    @Override
    public void onBindViewHolder(BeritaViewHolder holder, final int position) {
        holder.beritaTitle.setText(berita.get(position).getTitle());
        holder.beritaName.setText(berita.get(position).getName());
        holder.beritaCreated.setText(berita.get(position).getCreated_format());
        holder.beritaContent.setText(Html.fromHtml(berita.get(position).getContent()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, berita.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent i;
                i = new Intent(context, BeritaDetailActivity.class);
                i.putExtra("name", berita.get(position).getName());
                i.putExtra("title", berita.get(position).getTitle());
                i.putExtra("content", berita.get(position).getContent());
                i.putExtra("created_format", berita.get(position).getCreated_format());
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return berita.size();
    }

}
