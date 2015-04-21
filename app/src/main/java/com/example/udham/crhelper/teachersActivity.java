package com.example.udham.crhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.parse.ParseUser;


public class teachersActivity extends Activity {

    TextView tv1,tv2,tv3,tv4,welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);


        welcome=(TextView) findViewById(R.id.subTitle);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // do stuff with the user
            welcome.setText("Welcome "+currentUser.getUsername());
        }
        addListenerOnButton();
    }


    public void addListenerOnButton() {

        final Context context = this;

        tv1= (TextView) findViewById(R.id.class_text);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, classes.class);
                startActivity(intent);

            }
        });

        tv2= (TextView) findViewById(R.id.sull_text);

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, syllabus.class);
                startActivity(intent);

            }
        });

        tv3= (TextView) findViewById(R.id.tt_text);

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, timetable.class);
                startActivity(intent);

            }
        });


        tv4= (TextView) findViewById(R.id.stu_info_text);

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, stu_list.class);
                startActivity(intent);

            }
        });
    }



    }



