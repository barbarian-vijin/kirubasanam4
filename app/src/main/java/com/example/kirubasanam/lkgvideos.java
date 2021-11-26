package com.example.kirubasanam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class lkgvideos extends AppCompatActivity {
            private Button videolkglesson1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lkgvideos);
        videolkglesson1 = findViewById(R.id.btnlesson1);
        videolkglesson1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLesson1();
            }
        });

    }

    public void openLesson1(){

        Intent intent = new Intent(this,lesson1lkg.class);
        startActivity(intent);
    }


}
