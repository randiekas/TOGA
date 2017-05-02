package com.sakolah.guru.toga_guru;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

/**
 * Created by Randy Eka Setiawan on 2/28/2017.
 */

public class Jadwal extends AppCompatActivity {
    Toolbar toolBar;
    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5,expandableLayout6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jadwal);
        toolBar = (Toolbar) this.findViewById(R.id.toolBar);
        toolBar.setTitle("Jadwal Mengajar");
        this.setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // untuk button 1
        Button expandableButton1 = (Button)findViewById(R.id.expandableButton1);
        expandableButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1 = (ExpandableRelativeLayout)findViewById(R.id.expandableLayout1);
                expandableLayout1.toggle(); // toggle expand and collapse
            }
        });
        // untuk button 2
        Button expandableButton2 = (Button)findViewById(R.id.expandableButton2);
        expandableButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout2 = (ExpandableRelativeLayout)findViewById(R.id.expandableLayout2);
                expandableLayout2.toggle(); // toggle expand and collapse
            }
        });
        // untuk button 3
        Button expandableButton3 = (Button)findViewById(R.id.expandableButton3);
        expandableButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout3 = (ExpandableRelativeLayout)findViewById(R.id.expandableLayout3);
                expandableLayout3.toggle(); // toggle expand and collapse
            }
        });
        // untuk button 4
        Button expandableButton4 = (Button)findViewById(R.id.expandableButton4);
        expandableButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout4 = (ExpandableRelativeLayout)findViewById(R.id.expandableLayout4);
                expandableLayout4.toggle(); // toggle expand and collapse
            }
        });
        // untuk button 5
        Button expandableButton5 = (Button)findViewById(R.id.expandableButton5);
        expandableButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout5 = (ExpandableRelativeLayout)findViewById(R.id.expandableLayout5);
                expandableLayout5.toggle(); // toggle expand and collapse
            }
        });
        // untuk button 6
        Button expandableButton6 = (Button)findViewById(R.id.expandableButton6);
        expandableButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout6 = (ExpandableRelativeLayout)findViewById(R.id.expandableLayout6);
                expandableLayout6.toggle(); // toggle expand and collapse
            }
        });
    }
}
