package com.sakolah.guru.toga_guru.activity;

/**
 * Created by Randy Eka Setiawan on 5/2/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sakolah.guru.toga_guru.adapter.SiswaAdapter;
import com.sakolah.guru.toga_guru.model.RecyclerTouchListener;
import com.sakolah.guru.toga_guru.model.Siswa;

import java.util.List;

import com.sakolah.guru.toga_guru.R;
import com.sakolah.guru.toga_guru.response.SiswaResponse;
import com.sakolah.guru.toga_guru.rest.ApiClient;
import com.sakolah.guru.toga_guru.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SiswaActivity extends AppCompatActivity {
    List<Siswa> siswa ;
    String idsemester,idkelas,idtahunajaran;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siswa);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.siswa_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Bundle extras = getIntent().getExtras();
        idsemester = extras.getString("idsemester");
        idkelas = extras.getString("idkelas");
        idtahunajaran = extras.getString("idtahunajaran");
        Call<SiswaResponse> call = apiService.siswaList(idtahunajaran,idkelas);

        call.enqueue(new Callback<SiswaResponse>() {
            @Override
            public void onResponse(Call<SiswaResponse> call, Response<SiswaResponse> response) {
                int statusCode = response.code();
                siswa = response.body().getResults();
                recyclerView.setAdapter(new SiswaAdapter(siswa, R.layout.list_item_siswa, getApplicationContext()));
                //Log.e("SiswaActivity", response.toString());
            }

            @Override
            public void onFailure(Call<SiswaResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e("SiswaActivity", t.toString());

            }
        });
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                //Toast.makeText(getApplicationContext(), siswa.get(position).getJam() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent i;
                i = new Intent(getApplicationContext(), NilaiActivity.class);
                i.putExtra("nis", siswa.get(position).getNis());
                i.putExtra("nip", "197602192005071001");
                i.putExtra("idkelas", idkelas);
                i.putExtra("idsemester", idsemester);
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }
}

