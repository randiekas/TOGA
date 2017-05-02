package com.sakolah.guru.toga_guru.fragments.fragments_grup;

/**
 * Created by Randy Eka Setiawan on 2/15/2017.
 */
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.sakolah.guru.toga_guru.CustomAndroidGridViewAdapter;
import com.sakolah.guru.toga_guru.R;

import java.util.ArrayList;


public class ThreeFragment extends Fragment{
    private SliderLayout mDemoSlider;

    CoordinatorLayout rootLayoutAndroid;
    GridView gridView;

    ArrayList arrayList;

    public static String[] gridViewStrings = {
            "Randi Eka S",
            "Mario Maurer",
            "Nafilah Novehani",
            "Annisa Hafenty",
            "Pranda Dwi"
    };
    public static int[] gridViewImages = {
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.profile
    };

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
        final View view = inflater.inflate(R.layout.grup_fragment_three, container, false);
        gridView = (GridView) view.findViewById(R.id.grid);
        gridView.setAdapter(new CustomAndroidGridViewAdapter(view.getContext(), gridViewStrings, gridViewImages));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(view.getContext(), "position :"+position, Toast.LENGTH_SHORT).show();
                /*
                Intent i;
                if(position==0) // jika menu yang dipilih berita sekolah
                {
                    i = new Intent(view.getContext(), BeritaActivity.class);
                }else if(position==1) // jika menu yang dipilih jadwal
                {
                    i = new Intent(view.getContext(), JadwalActivity.class);
                }else if(position==2) // jika menu yang dipilih tanya jawab
                {
                    i = new Intent(view.getContext(), PertanyaanActivity.class);
                }else if(position==3) // jika menu yang dipilih grup kelas
                {
                    i = new Intent(view.getContext(), GrupKelas.class);
                }else if(position==4) // jika menu yang dipilih nilai siswa
                {
                    i = new Intent(view.getContext(), MengajarActivity.class);
                }else{
                    i = new Intent(view.getContext(), BeritaActivity.class);
                }
                startActivity(i);
                */
            }
        });

        rootLayoutAndroid = (CoordinatorLayout) view.findViewById(R.id.android_coordinator_layout);
        return view;
    }


}