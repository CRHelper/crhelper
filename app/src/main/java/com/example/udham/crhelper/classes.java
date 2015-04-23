package com.example.udham.crhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class classes extends Activity {

    ImageButton b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        addListenerOnButton();
    }

    public void addListenerOnButton() {

        final Context context = this;

        b1= (ImageButton) findViewById(R.id.imageButton1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, stu_list.class);
                startActivity(intent);

            }
        });

        b2= (ImageButton) findViewById(R.id.imageButton2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, stu_list.class);
                startActivity(intent);

            }
        });

        b3= (ImageButton) findViewById(R.id.imageButton3);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, stu_list.class);
                startActivity(intent);

            }
        });


        b4= (ImageButton) findViewById(R.id.imageButton4);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, stu_list.class);
                startActivity(intent);

            }
        });
    }

}
