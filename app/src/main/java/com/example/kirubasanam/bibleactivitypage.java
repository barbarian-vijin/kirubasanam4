package com.example.kirubasanam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class bibleactivitypage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibleactivitypage);
        getSupportActionBar().setTitle("Select Bible");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}