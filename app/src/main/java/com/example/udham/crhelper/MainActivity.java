package com.example.udham.crhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

import com.parse.Parse;


public class MainActivity extends AppCompatActivity {

    Button b1,b2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

        new AsyncTask<Void, Void, Void>() {
            @Override
            public Void doInBackground(Void... params) {
                // Enable Local Datastore.
                Parse.enableLocalDatastore(MainActivity.this);

                Parse.initialize(MainActivity.this, "Egsn9KbBiDHrcXa784wgbBHlZJebpmEoydC13ivt", "4duy7HwfneN5y1ZhEUipAjCp6umoDMiOJE7aVTQV");
                return null;
            }
        }.execute();

    }

    public void addListenerOnButton() {

        final Context context = this;

        b1 = (Button) findViewById(R.id.stu_button);

        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, login.class);
                intent.putExtra("key","student");
                startActivity(intent);

            }
        });

        b2= (Button) findViewById(R.id.tch_button);

        b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, login.class);
                intent.putExtra("key","teacher");
                startActivity(intent);

            }
        });
    }

}
