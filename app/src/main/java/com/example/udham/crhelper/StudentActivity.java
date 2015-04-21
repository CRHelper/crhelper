package com.example.udham.crhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;


public class StudentActivity extends Activity {

    TextView tv,welcome,tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        tv= (TextView) findViewById(R.id.att_text);
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

        tv1= (TextView) findViewById(R.id.att_text);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, attendance.class);
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

        tv3= (TextView) findViewById(R.id.assign_text);

        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, assignmentActivity.class);
                startActivity(intent);

            }
        });


        tv4= (TextView) findViewById(R.id.other_text);

        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, stuInfo.class);
                startActivity(intent);

            }
        });
    }

}
