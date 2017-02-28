package com.sakolah.guru.toga_guru;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Randy Eka Setiawan on 2/28/2017.
 */

public class BeritaSekolah extends AppCompatActivity {
    Toolbar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.berita_sekolah);

        toolBar = (android.support.v7.widget.Toolbar) this.findViewById(R.id.toolBar);
        toolBar.setTitle("Berita Sekolah");
        toolBar.setNavigationIcon(R.drawable.icon_arrow_left);
        this.setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
