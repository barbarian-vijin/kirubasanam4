package com.example.kirubasanam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.viewpagerindicator.CirclePageIndicator;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
//image slider image link
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;

    private String[] urls = new String[] {"https://www.linkpicture.com/q/wallpaperuse.com-tamil-bible-verses-wallpapers-597005.jpg", "https://demonuts.com/Demonuts/SampleImages/W-08.JPG", "https://demonuts.com/Demonuts/SampleImages/W-10.JPG",
            "https://demonuts.com/Demonuts/SampleImages/W-13.JPG", "https://demonuts.com/Demonuts/SampleImages/W-17.JPG", "https://demonuts.com/Demonuts/SampleImages/W-21.JPG"};
    BottomNavigationView bottomNavigationView;
    private Button videos;
    private Button Bible;
    private Button Books;
    private Button Prayforus;

    @Override
    //main activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView=findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),prayForUs.class));
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.home:
                       return true;
                    case R.id.notification:
                        startActivity(new Intent(getApplicationContext(),notification.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });


        init();
        videos = findViewById(R.id.btnsundayschoolvideos);
        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSundayschoolvideos();
            }
        });
       Bible = findViewById(R.id.btnbible);
        Bible.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         openbible();
                                     }
        });
        Books = findViewById(R.id.btnbooks);
        Books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensundayschoolbook();
            }
        });
        Prayforus =findViewById(R.id.btnprayforus);
        Prayforus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openprayforus();
            }
        });


    }
            //image slider


            private void init() {
                mPager = (ViewPager) findViewById(R.id.pager);
                mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this, urls));

                CirclePageIndicator indicator = (CirclePageIndicator)
                        findViewById(R.id.indicator);

                indicator.setViewPager(mPager);

                final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
                indicator.setRadius(5 * density);

                NUM_PAGES = urls.length;

                // Auto start of viewpager
                final Handler handler = new Handler();
                final Runnable Update = new Runnable() {
                    public void run() {
                        if (currentPage == NUM_PAGES) {
                            currentPage = 0;
                        }
                        mPager.setCurrentItem(currentPage++, true);
                    }
                };
                Timer swipeTimer = new Timer();
                swipeTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(Update);
                    }
                }, 4000, 4000);

                // Pager listener over indicator
                indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                    @Override
                    public void onPageSelected(int position) {
                        currentPage = position;

                    }

                    @Override
                    public void onPageScrolled(int pos, float arg1, int arg2) {

                    }

                    @Override
                    public void onPageScrollStateChanged(int pos) {

                    }
                });

            }
            // opening sunday school
            public void openSundayschoolvideos() {
                Intent intent = new Intent(this, sundayclassvideo.class);
                startActivity(intent);
            }
            //opening bible
            public void openbible() {
                Intent intent = new Intent(this, bibleactivitypage.class);
                startActivity(intent);
            }

            // opening books
            public void opensundayschoolbook(){
                Intent intent = new Intent(this,sundaclassbook.class);
                 startActivity(intent);
            }

            //opening prayfor us
            public void openprayforus(){
                 Intent intent = new Intent(this,prayForUs.class);
                 startActivity(intent);
            }

    }