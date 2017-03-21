package com.sakolah.guru.toga_guru.fragments;

/**
 * Created by Randy Eka Setiawan on 2/15/2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.sakolah.guru.toga_guru.R;

public class ThreeFragment extends Fragment{
    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4, expandableLayout5,expandableLayout6;

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_three, container, false);
        // untuk button 1
        Button expandableButton1 = (Button)view.findViewById(R.id.expandableButton1);
        expandableButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout1 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout1);
                expandableLayout1.toggle(); // toggle expand and collapse
            }
        });
        // untuk button 2
        Button expandableButton2 = (Button)view.findViewById(R.id.expandableButton2);
        expandableButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout2 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout2);
                expandableLayout2.toggle(); // toggle expand and collapse
            }
        });
        // untuk button 3
        Button expandableButton3 = (Button)view.findViewById(R.id.expandableButton3);
        expandableButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout3 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout3);
                expandableLayout3.toggle(); // toggle expand and collapse
            }
        });
        // untuk button 4
        Button expandableButton4 = (Button)view.findViewById(R.id.expandableButton4);
        expandableButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout4 = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayout4);
                expandableLayout4.toggle(); // toggle expand and collapse
            }
        });
        return view;
    }
}