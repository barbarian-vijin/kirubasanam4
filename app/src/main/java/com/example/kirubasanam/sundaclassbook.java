package com.example.kirubasanam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class sundaclassbook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sundaclassbook);
        getSupportActionBar().setTitle("Select Your Class");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}