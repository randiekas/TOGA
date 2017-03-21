package com.sakolah.guru.toga_guru.fragments;

/**
 * Created by Randy Eka Setiawan on 2/15/2017.
 */
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.sakolah.guru.toga_guru.BeritaSekolah;
import com.sakolah.guru.toga_guru.CustomAndroidGridViewAdapter;
import com.sakolah.guru.toga_guru.GrupKelas;
import com.sakolah.guru.toga_guru.Jadwal;
import com.sakolah.guru.toga_guru.NilaiSiswa;
import com.sakolah.guru.toga_guru.R;
import com.sakolah.guru.toga_guru.TanyaJawab;

import java.util.ArrayList;
import java.util.HashMap;


public class OneFragment extends Fragment{
    private SliderLayout mDemoSlider;

    CoordinatorLayout rootLayoutAndroid;
    GridView gridView;

    ArrayList arrayList;

    public static String[] gridViewStrings = {
            "Berita Sekolah",
            "Jadwal Mengajar",
            "Tanya Jawab",
            "Grup Kelas",
            "Nilai Siswa"
    };
    public static int[] gridViewImages = {
            R.drawable.icon_news,
            R.drawable.icon_calendar,
            R.drawable.icon_chat,
            R.drawable.icon_groups,
            R.drawable.icon_nilai
    };

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
        final View view = inflater.inflate(R.layout.fragment_one, container, false);
        mDemoSlider = (SliderLayout)view.findViewById(R.id.slider);

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal",R.drawable.image_1);
        file_maps.put("Big Bang Theory",R.drawable.image_2);
        file_maps.put("House of Cards",R.drawable.image_3);
        file_maps.put("Game of Thrones", R.drawable.image_4);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(view.getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        gridView = (GridView) view.findViewById(R.id.grid);
        gridView.setAdapter(new CustomAndroidGridViewAdapter(view.getContext(), gridViewStrings, gridViewImages));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                //Toast.makeText(view.getContext(), "position :"+position, Toast.LENGTH_SHORT).show();
                Intent i;
                if(position==0) // jika menu yang dipilih berita sekolah
                {
                    i = new Intent(view.getContext(), BeritaSekolah.class);
                }else if(position==1) // jika menu yang dipilih jadwal
                {
                    i = new Intent(view.getContext(), Jadwal.class);
                }else if(position==2) // jika menu yang dipilih tanya jawab
                {
                    i = new Intent(view.getContext(), TanyaJawab.class);
                }else if(position==3) // jika menu yang dipilih grup kelas
                {
                    i = new Intent(view.getContext(), GrupKelas.class);
                }else if(position==4) // jika menu yang dipilih nilai siswa
                {
                    i = new Intent(view.getContext(), NilaiSiswa.class);
                }else{
                    i = new Intent(view.getContext(), BeritaSekolah.class);
                }
                startActivity(i);
            }
        });

        rootLayoutAndroid = (CoordinatorLayout) view.findViewById(R.id.android_coordinator_layout);
        return view;
    }


}