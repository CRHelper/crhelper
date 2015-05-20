package com.example.udham.crhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Bundle;

import com.parse.Parse;


public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    public Void doInBackground(Void... params) {
                        Parse.initialize(Splash.this, "Egsn9KbBiDHrcXa784wgbBHlZJebpmEoydC13ivt", "4duy7HwfneN5y1ZhEUipAjCp6umoDMiOJE7aVTQV");
                        return null;
                    }
                }.execute();



                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, 2000);

    }


}
