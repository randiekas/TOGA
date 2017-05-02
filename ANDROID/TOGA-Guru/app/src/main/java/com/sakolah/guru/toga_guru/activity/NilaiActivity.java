package com.sakolah.guru.toga_guru.activity;

/**
 * Created by Randy Eka Setiawan on 5/2/2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import com.sakolah.guru.toga_guru.R;
import com.sakolah.guru.toga_guru.adapter.NilaiAdapter;
import com.sakolah.guru.toga_guru.model.Nilai;
import com.sakolah.guru.toga_guru.response.NilaiResponse;
import com.sakolah.guru.toga_guru.rest.ApiClient;
import com.sakolah.guru.toga_guru.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NilaiActivity extends AppCompatActivity {
    List<Nilai> nilai ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nilai);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.nilai_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Bundle extras = getIntent().getExtras();
        Call<NilaiResponse> call = apiService.nilaiList(extras.getString("idkelas"),extras.getString("idsemester"),extras.getString("nis"),extras.getString("nip"));
        //"89","21","1402011094","197602192005071001"
        Log.e("NilaiActivity",extras.getString("idkelas")+","+extras.getString("idsemester")+","+extras.getString("nis")+","+extras.getString("nip"));
        call.enqueue(new Callback<NilaiResponse>() {
            @Override
            public void onResponse(Call<NilaiResponse> call, Response<NilaiResponse> response) {
                int statusCode = response.code();
                nilai = response.body().getResults();
                recyclerView.setAdapter(new NilaiAdapter(nilai, R.layout.list_item_nilai, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<NilaiResponse> call, Throwable t) {
                // Log error here since request failed
                //Log.e(TAG, t.toString());
            }
        });
    }
}

