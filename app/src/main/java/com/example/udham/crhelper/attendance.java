package com.example.udham.crhelper;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class attendance extends Activity {


    TextView a1,a2,a3,a4,a5,res;
    String atn1,atn2,atn3,atn4,atn5;
    TextView roll,eml,mob,nam;
    String roll_no,email,mobile,name;
    String tot1,tot2,tot3,tot4,tot5;
    TextView t1,t2,t3,t4,t5;
    int sub1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        getdata();
        putdata();
    }

   public void getdata()
   {

       a1=(TextView) findViewById(R.id.sub1);
       a2=(TextView) findViewById(R.id.sub2);
       a3=(TextView) findViewById(R.id.sub3);
       a4=(TextView) findViewById(R.id.sub4);
       a5=(TextView) findViewById(R.id.sub5);

       roll=(TextView)findViewById(R.id.roll_no);
       eml=(TextView) findViewById(R.id.email);
       mob=(TextView) findViewById(R.id.mobile);
       res=(TextView) findViewById(R.id.res);

       t1=(TextView) findViewById(R.id.total1);
       t2=(TextView) findViewById(R.id.total2);
       t3=(TextView) findViewById(R.id.total3);
       t4=(TextView) findViewById(R.id.total4);
       t5=(TextView) findViewById(R.id.total5);

   }

     public void putdata()
    {


        new AsyncTask<Void, Void, Void>() {
            @Override
            public Void doInBackground(Void... params) {

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
                                       // name = p.getString("Name").toUpperCase();

                                        atn1 = p.getString("Subject_1");
                                        atn2 = p.getString("Subject_2");
                                        atn3 = p.getString("Subject_3");
                                        atn4 = p.getString("Subject_4");
                                        atn5 = p.getString("Subject_5");


                                        roll_no = p.getString("Roll_No");
                                        email = p.getString("Email");
                                        mobile = p.getString("Mobile");

                                        tot1=p.getString("Total_sub1");
                                        tot2=p.getString("Total_sub2");
                                        tot3=p.getString("Total_sub3");
                                        tot4=p.getString("Total_sub4");
                                        tot5=p.getString("Total_sub5");


                                        setdata();

                                    }
                                }

                            }
                        }
                    });
                }

                return null;
            }
        }.execute();

    }

    public void setdata()
    {

        a1.setText(atn1);
        a2.setText(atn2);
        a3.setText(atn3);
        a4.setText(atn4);
        a5.setText(atn5);

        roll.setText("Roll no : "+roll_no);
        eml.setText("ID: "+email);
        mob.setText("Mobile : " + mobile);

        t1.setText(tot1);
        t2.setText(tot1);
        t3.setText(tot1);
        t4.setText(tot1);
        t5.setText(tot1);




    }

}
