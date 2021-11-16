package com.example.kirubasanam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bibletypepage extends AppCompatActivity {
    private Button englishBible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibletypepage);
        englishBible = findViewById(R.id.btnEnglishbible);
        englishBible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openenglishbible();
            }
        });
    }
    private void openenglishbible() {
        Intent intent = new Intent(this,Englishbible.class);
        startActivity(intent);
    }
}