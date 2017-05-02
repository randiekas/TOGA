package com.sakolah.guru.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CrimeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container); // setting layout yang akan di embed fragment.
        if (fragment == null) { // jika element yang mempunyai id fragment_container nya ada
            fragment = new CrimeFragment(); // isi element tersebut dengan fragment CrimeFragment
            fm.beginTransaction() // memulai transaksi/inisiasi fragment
                    .add(R.id.fragment_container, fragment) // tambahkan element tersbut ke fragment yang sudah di define sebelumnya.
                    .commit();
        }
    }
}
