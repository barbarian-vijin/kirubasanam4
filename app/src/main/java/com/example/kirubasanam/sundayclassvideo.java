package com.example.kirubasanam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class sundayclassvideo extends AppCompatActivity {
    private Button videoslkg;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sundayclassvideo);
        getSupportActionBar().setTitle("Select Your Class");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        videoslkg = findViewById(R.id.btnlkg);
        videoslkg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlkgvideos();
            }
        });

        //bottomnavigatin view
        bottomNavigationView=findViewById(R.id.bottom_navigator);
       // bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.profile:
                        startActivity(new Intent(getApplicationContext(),prayForUs.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.notification:
                        startActivity(new Intent(getApplicationContext(),notification.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
    }
    public void openlkgvideos(){
        Intent intent = new Intent(this,lkgvideos.class);
        startActivity(intent);
    }



}
