package com.example.udham.crhelper;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseObject;


public class stuInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_info);
        getDetail();

    }

    public static void getDetail()
    {
        ParseObject detail = new ParseObject("Marks");
        detail.put("Roll_No", "09111503111");
        detail.put("Name", "Geet Mehta");
        detail.put("Email", "geet.mehta16@gmail.com");
        detail.put("Subject_1", 80);
        detail.put("Subject_2", 70);
        detail.put("Subject_3", 90);

        detail.saveInBackground();

    }

}
