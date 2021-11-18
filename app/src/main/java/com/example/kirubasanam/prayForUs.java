package com.example.kirubasanam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class prayForUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pray_for_us);
        getSupportActionBar().setTitle("Pray For Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}