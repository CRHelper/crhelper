package com.example.udham.crhelper;

import java.util.List;
import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class assignmentActivity extends Activity {

    ListView list;
    String[] assignment;
    String[] subject;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        Resources res = getResources();
        assignment=res.getStringArray(R.array.assignment);
        subject=res.getStringArray(R.array.subject);
        list=(ListView) findViewById(R.id.assignment_list_view);

        crAdapter adapter=new crAdapter(this,assignment,subject);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        public void onItemClick(AdapterView<?> parent, View v,
                                                                int position, long id) {

                                            Intent intent = new Intent(Intent.ACTION_SEND);
                                            intent.setType("message/rfc822");
                                            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                                            intent.putExtra(Intent.EXTRA_TEXT, "message");
                                            Intent mailer = Intent.createChooser(intent, null);
                                            startActivity(mailer);
                                            //Intent myIntent = new Intent(v.getContext(), stuInfo.class);
                                            //startActivityForResult(myIntent, 0);

                                        }
                                    }
        );





    }


    class crAdapter extends ArrayAdapter<String>
    {

        Context context;

        String[] titleArray;
        String[] subArray;

        crAdapter(Context c, String[] names,  String[] roll) {
            super(c, R.layout.assignment_single_row, R.id.textView, names);
            this.context = c;

            this.titleArray=names;
            this.subArray=roll;

        }


        class MyViewHolder
        {

            TextView myAssignment;
            TextView mySub;
            MyViewHolder(View v)
            {

                myAssignment= (TextView) v.findViewById(R.id.text1);
                mySub= (TextView) v.findViewById(R.id.text2);
            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row=convertView;
            MyViewHolder holder=null;
            if(row==null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.assignment_single_row, parent, false);
                holder=new MyViewHolder(row);
                row.setTag(holder);
                Log.d("CR", "Creating new row");
            }
            else
            {
                holder= (MyViewHolder) row.getTag();
                Log.d("CR","Recycling");
            }


            holder.myAssignment.setText(titleArray[position]);
            holder.mySub.setText(subArray[position]);

            return row;
        }
    }


}


