package com.example.kirubasanam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sundayclassvideo extends AppCompatActivity {
    private Button videoslkg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sundayclassvideo);

        videoslkg = findViewById(R.id.btnlkg);
        videoslkg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlkgvideos();
            }
        });

    }

    public void openlkgvideos(){
        Intent intent = new Intent(this,lkgvideos.class);
        startActivity(intent);
    }

}
