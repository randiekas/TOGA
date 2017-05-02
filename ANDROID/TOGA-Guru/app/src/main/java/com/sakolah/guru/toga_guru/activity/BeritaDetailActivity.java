package com.sakolah.guru.toga_guru.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.sakolah.guru.toga_guru.R;

/**
 * Created by Randy Eka Setiawan on 2/28/2017.
 */

public class BeritaDetailActivity extends AppCompatActivity {
    Toolbar toolBar;
    TextView title;
    TextView created_format;
    TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.berita_sekolah_detail);

        title = (TextView)findViewById(R.id.title);
        created_format = (TextView)findViewById(R.id.created_format);
        content = (TextView)findViewById(R.id.content);

        Bundle extras = getIntent().getExtras();
        toolBar = (Toolbar) this.findViewById(R.id.toolBar);
        toolBar.setTitle(extras.getString("name"));
        this.setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        title.setText(extras.getString("title"));
        created_format.setText(extras.getString("created_format"));
        content.setText(Html.fromHtml(extras.getString("content")));
    }
}
