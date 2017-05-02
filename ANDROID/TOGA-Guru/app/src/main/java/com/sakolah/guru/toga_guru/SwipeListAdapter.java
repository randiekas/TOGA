package com.sakolah.guru.toga_guru;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.sakolah.guru.toga_guru.berita_sekolah.Model;
import com.sakolah.guru.toga_guru.berita_sekolah.ModelAdapter;

import java.util.ArrayList;
import java.util.List;
public class SwipeListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Movie> movieList;
    private String[] bgColors;
 
    public SwipeListAdapter(Activity activity, List<Movie> movieList) {
        this.activity = activity;
        this.movieList = movieList;
        bgColors = activity.getApplicationContext().getResources().getStringArray(R.array.movie_serial_bg);
    }
 
    @Override
    public int getCount() {
        return movieList.size();
    }
 
    @Override
    public Object getItem(int location) {
        return movieList.get(location);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
 
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);
 
        TextView serial = (TextView) convertView.findViewById(R.id.serial);
        TextView title = (TextView) convertView.findViewById(R.id.title);
 
        serial.setText(String.valueOf(movieList.get(position).id));
        title.setText(movieList.get(position).title);
 
        String color = bgColors[position % bgColors.length];
        serial.setBackgroundColor(Color.parseColor(color));
 
        return convertView;
    }
 
}