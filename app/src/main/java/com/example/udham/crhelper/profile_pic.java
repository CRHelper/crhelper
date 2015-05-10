package com.example.udham.crhelper;

import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
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


public class profile_pic extends ActionBarActivity {

    ParseImageView iv;
    ParseFile img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pic);
        iv=(ParseImageView)findViewById(R.id.imageView3);

        putimage();
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
