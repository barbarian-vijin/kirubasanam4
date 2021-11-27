package com.example.kirubasanam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class bibleactivitypage extends AppCompatActivity {
        BottomNavigationView bottomNavigationView;
        private Button englishBible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibleactivitypage);
        getSupportActionBar().setTitle("Select Bible");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        bottomNavigationView=findViewById(R.id.bottom_navigator);
       bottomNavigationView.setSelectedItemId(R.id.profile);
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
        englishBible =findViewById(R.id.btnenglishbible);
        englishBible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEnglishBible();
            }
        });



    }
    public  void openEnglishBible(){
        Intent intent = new Intent(this,Englishbible.class);
        startActivity(intent);
    }
}