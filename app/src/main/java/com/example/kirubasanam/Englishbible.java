package com.example.kirubasanam;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Englishbible extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_englishbible);
        getSupportActionBar().setTitle("English Bible");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}