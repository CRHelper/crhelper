package com.example.udham.crhelper;

import android.app.Activity;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class profile_pic extends Activity {

    ParseImageView iv;
    ParseFile img;
    TextView tv1,tv2,tv3,tv4;
    String roll_no,email,mob,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);
        iv=(ParseImageView)findViewById(R.id.imageView3);

        getdata();
        putimage();
        putdata();

    }

public void getdata()
{
    tv1=(TextView) findViewById(R.id.name_disp);
    tv2=(TextView) findViewById(R.id.roll_no_disp);
    tv3=(TextView) findViewById(R.id.email_disp);
    tv4=(TextView) findViewById(R.id.mob_disp);


}
    public void putdata()
    {


                ParseUser currentUser = ParseUser.getCurrentUser();
                if(currentUser!=null)
                {
                    ParseQuery<ParseObject> query = ParseQuery.getQuery("Attendance");
                    query.whereEqualTo("Name",currentUser.getUsername());
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> userList, ParseException e) {
                            if (e == null) {
                                if (userList.size() > 0) {

                                    for (int i = 0; i < userList.size(); i++) {
                                        ParseObject p = userList.get(i);

                                        roll_no = p.getString("Roll_No");
                                        email = p.getString("Email");
                                        mob = p.getString("Mobile");
                                        name=p.getString("Name");
                                        putRes();
                                    }
                                }

                            }
                        }
                    });
                }



    }

    public void putRes()
    {
        tv1.setText(name);
        tv2.setText(roll_no);
        tv3.setText(email);
        tv4.setText(mob);
    }
    public void putimage()
    {


                ParseUser currentUser = ParseUser.getCurrentUser();
                if(currentUser!=null)
                {
                    ParseQuery<ParseObject> query = ParseQuery.getQuery("Images");
                    query.whereEqualTo("name",currentUser.getUsername());
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> userList, ParseException e) {
                            if (e == null) {
                                if (userList.size() > 0) {

                                    for (int i = 0; i < userList.size(); i++) {
                                        ParseObject p = userList.get(i);
                                        ParseFile image = (ParseFile) p.getParseFile("image");
                                        iv.setParseFile(image);
                                        if (image != null) {
                                            iv.loadInBackground();
                                        } else {
                                            iv.setImageDrawable(getResources().getDrawable(R.drawable.bvcoe1));
                                        }

                                    }
                                }

                            }
                        }
                    });
                }


    }
}
