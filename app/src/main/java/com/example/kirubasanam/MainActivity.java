package com.example.kirubasanam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
//image slider image link
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;

    private String[] urls = new String[] {"https://www.linkpicture.com/q/wallpaperuse.com-tamil-bible-verses-wallpapers-597005.jpg", "https://demonuts.com/Demonuts/SampleImages/W-08.JPG", "https://demonuts.com/Demonuts/SampleImages/W-10.JPG",
            "https://demonuts.com/Demonuts/SampleImages/W-13.JPG", "https://demonuts.com/Demonuts/SampleImages/W-17.JPG", "https://demonuts.com/Demonuts/SampleImages/W-21.JPG"};

    private Button videos;
    private Button Bible;
    private Button Books;
    public EditText name;
    public Button query_button;
    public TextView result_address;

    @Override
    //main activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //database
        name = findViewById(R.id.name);
        query_button = findViewById(R.id.query_button);
        result_address=findViewById(R.id.result);

        //now setting onclicklistener to query button
        query_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create the instance of database and open database connection
                DatabaseAcess databaseAcess = DatabaseAcess.getInstance(getApplicationContext());
                databaseAcess.open();

                //getting string value from edittext
                String n = name.getText().toString();
                String address = databaseAcess.getAdress(n);//used the get address method  to get adress

                //setting result to result field
                result_address.setText(address);
                databaseAcess.close();
                //datbaseconnection closed

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
                Intent intent = new Intent(this, bibletypepage.class);
                startActivity(intent);
            }

            // opening books
            public void opensundayschoolbook(){
          Intent intent = new Intent(this,sundaclassbook.class);
          startActivity(intent);
            }

        }

