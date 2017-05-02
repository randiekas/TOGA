package com.sakolah.guru.toga_guru.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sakolah.guru.toga_guru.R;
import com.sakolah.guru.toga_guru.adapter.PertanyaanAdapter;
import com.sakolah.guru.toga_guru.model.Pertanyaan;
import com.sakolah.guru.toga_guru.response.PertanyaanResponse;
import com.sakolah.guru.toga_guru.rest.ApiClient;
import com.sakolah.guru.toga_guru.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PertanyaanActivity extends AppCompatActivity {
    List<Pertanyaan> pertanyaan ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.tanya_jawab);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Tanya Jawab");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initCollapsingToolbar();

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.pertanyaan_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<PertanyaanResponse> call = apiService.pertanyaanList();

        call.enqueue(new Callback<PertanyaanResponse>() {
            @Override
            public void onResponse(Call<PertanyaanResponse> call, Response<PertanyaanResponse> response) {
                int statusCode = response.code();
                pertanyaan = response.body().getResults();
                recyclerView.setAdapter(new PertanyaanAdapter(pertanyaan, R.layout.list_item_pertanyaan, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<PertanyaanResponse> call, Throwable t) {
                // Log error here since request failed
                //Log.e(TAG, t.toString());
            }
        });

    }
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Tanya Jawab");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
}
