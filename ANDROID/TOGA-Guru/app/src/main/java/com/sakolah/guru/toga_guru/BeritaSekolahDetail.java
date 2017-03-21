package com.sakolah.guru.toga_guru;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Randy Eka Setiawan on 2/28/2017.
 */

public class BeritaSekolahDetail extends AppCompatActivity {
    Toolbar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.berita_sekolah_detail);

        toolBar = (Toolbar) this.findViewById(R.id.toolBar);
        toolBar.setTitle("Berita Sekolah Detail");
        this.setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
