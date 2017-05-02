package com.sakolah.guru.toga_guru.fragments.fragments_grup;

/**
 * Created by Randy Eka Setiawan on 2/15/2017.
 */
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sakolah.guru.toga_guru.R;


public class OneFragment extends Fragment{

    public OneFragment() {
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
        final View view = inflater.inflate(R.layout.grup_fragment_one, container, false);
        Button savePost = (Button)view.findViewById(R.id.savePost);
        Button cancelPost = (Button)view.findViewById(R.id.cancelPost);
        FloatingActionButton btnAdd = (FloatingActionButton)view.findViewById(R.id.addButton);
        final LinearLayout formArea = (LinearLayout)view.findViewById(R.id.formArea);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formArea.setVisibility(View.VISIBLE);
            }
        });
        cancelPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                formArea.setVisibility(View.INVISIBLE);
            }
        });
        return view;
    }

}