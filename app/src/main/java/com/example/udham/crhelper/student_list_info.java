package com.example.udham.crhelper;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class student_list_info extends Activity {

    TextView m1,m2,m3,m4,m5;
    TextView r1,r2,r3,r4,r5;
    Button submit;

    TextView roll,eml,mob,nam;
    String roll_no,email,mobile,name;
    String marks1,marks2,marks3,marks4,marks5;
    String remark1,remark2,remark3,remark4,remark5;
    String data,data_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_info);

        getData();
        checkData();
        putDetail(data_name);

        addListenerButton();

    }

    public String checkData()
    {
        if(data.equals("neeraj"))
        {
            data_name="neeraj";
            return  data_name;
        }
        else if(data.equals("rahul"))
        {
            data_name="rahul";
            return  data_name;
        }
        else if(data.equals("udham"))
        {
            data_name="udham";
            return  data_name;
        }
        else if(data.equals("gurmeet"))
        {
            data_name="gurmeet";
            return  data_name;
        }
        else if(data.equals("manoj"))
        {
            data_name="manoj";
            return  data_name;
        }
        else if(data.equals("sumit"))
        {
            data_name="sumit";
            return  data_name;
        }
        else if(data.equals("parikshit"))
        {
            data_name="parikshit";
            return  data_name;
        }
        return null;
    }



    public void getData()
    {
        m1=(TextView) findViewById(R.id.marks1);
        m2=(TextView) findViewById(R.id.marks2);
        m3=(TextView) findViewById(R.id.marks3);
        m4=(TextView) findViewById(R.id.marks4);
        m5=(TextView) findViewById(R.id.marks5);

        r1=(TextView) findViewById(R.id.remarks1);
        r2=(TextView) findViewById(R.id.remarks2);
        r3=(TextView) findViewById(R.id.remarks3);
        r4=(TextView) findViewById(R.id.remarks4);
        r5=(TextView) findViewById(R.id.remarks5);

        roll=(TextView) findViewById(R.id.roll_no);
        eml=(TextView) findViewById(R.id.email);
        mob=(TextView) findViewById(R.id.mobile);
        nam=(TextView) findViewById(R.id.name);

        submit=(Button) findViewById(R.id.submit);
        data = getIntent().getExtras().getString("key");


    }


    public void putDetail(String msg)
    {

        final String temp=msg;

        new AsyncTask<Void, Void, Void>() {
            @Override
            public Void doInBackground(Void... params) {


                    ParseQuery<ParseObject> query = ParseQuery.getQuery("Marks");
                    query.whereEqualTo("Name",temp);
                    query.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> userList, ParseException e) {
                            if (e == null) {
                                if (userList.size() > 0) {

                                    for (int i = 0; i < userList.size(); i++) {
                                        ParseObject p = userList.get(i);
                                        name = p.getString("Name").toUpperCase();
                                        marks1 = p.getString("Subject_1");
                                        marks2 = p.getString("Subject_2");
                                        marks3 = p.getString("Subject_3");
                                        marks4 = p.getString("Subject_4");
                                        marks5 = p.getString("Subject_5");

                                        roll_no = p.getString("Roll_No");
                                        email = p.getString("Email");
                                        mobile = p.getString("Mobile");

                                        remark1= p.getString("Remark_1");
                                        remark2= p.getString("Remark_2");
                                        remark3= p.getString("Remark_3");
                                        remark4= p.getString("Remark_4");
                                        remark5= p.getString("Remark_5");
                                        putRes();
                                    }
                                }

                            }
                        }
                    });


                return null;
            }
        }.execute();

    }

    public void putRes()
    {
        m1.setText(marks1);
        m2.setText(marks2);
        m3.setText(marks3);
        m4.setText(marks4);
        m5.setText(marks5);

        roll.setText("Roll no : "+roll_no);
        eml.setText("ID: "+email);
        mob.setText("Mobile : "+mobile);
        nam.setText(name);

        r1.setText(remark1);
        r2.setText(remark2);
        r3.setText(remark3);
        r4.setText(remark4);
        r5.setText(remark5);

    }

    public void addListenerButton()
    {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
            }
        });



    }

}
