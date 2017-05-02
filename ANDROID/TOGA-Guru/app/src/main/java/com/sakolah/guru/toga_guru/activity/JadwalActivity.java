package com.sakolah.guru.toga_guru.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sakolah.guru.toga_guru.R;
import com.sakolah.guru.toga_guru.adapter.JadwalAdapter;
import com.sakolah.guru.toga_guru.model.Jadwal;
import com.sakolah.guru.toga_guru.response.JadwalResponse;
import com.sakolah.guru.toga_guru.rest.ApiClient;
import com.sakolah.guru.toga_guru.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Randy Eka Setiawan on 2/28/2017.
 */

public class JadwalActivity extends AppCompatActivity {
    Toolbar toolBar;
    List<Jadwal> jadwal ;
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

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.jadwal_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<JadwalResponse> call = apiService.jadwalList("197602192005071001");

        call.enqueue(new Callback<JadwalResponse>() {
            @Override
            public void onResponse(Call<JadwalResponse> call, Response<JadwalResponse> response) {
                int statusCode = response.code();
                jadwal = response.body().getResults();
                recyclerView.setAdapter(new JadwalAdapter(jadwal, R.layout.list_item_jadwal, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<JadwalResponse> call, Throwable t) {
                // Log error here since request failed
                //Log.e(TAG, t.toString());
            }
        });

    }
}
