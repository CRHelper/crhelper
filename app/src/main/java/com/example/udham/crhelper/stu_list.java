package com.example.udham.crhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class stu_list extends Activity {


    ListView list;
    String[] names;
    String[] roll;
    int[] image={R.drawable.profile,R.drawable.profile,R.drawable.profile,R.drawable.profile,R.drawable.profile,R.drawable.profile,R.drawable.profile};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_list);

        Resources res = getResources();
        names=res.getStringArray(R.array.names);
        roll=res.getStringArray(R.array.roll);
        list=(ListView) findViewById(R.id.stulistView);

        crAdapter adapter=new crAdapter(this,names,image,roll);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        public void onItemClick(AdapterView<?> parent, View v,
                                                                int position, long id) {

                                            Intent myIntent = new Intent(v.getContext(), stuInfo.class);
                                            startActivityForResult(myIntent, 0);

                                        }
                                    }
        );





    }


    class crAdapter extends ArrayAdapter<String>
    {

        Context context;
        int[] images;
        String[] titleArray;
        String[] rollArray;

        crAdapter(Context c, String[] names, int imgs[], String[] roll) {
            super(c, R.layout.single_row, R.id.textView, names);
            this.context = c;
            this.images = imgs;
            this.titleArray=names;
            this.rollArray=roll;

        }


        class MyViewHolder
        {
            ImageView myImage;
            TextView myName;
            TextView myRoll;
            MyViewHolder(View v)
            {
                myImage= (ImageView) v.findViewById(R.id.imageView);
                myName= (TextView) v.findViewById(R.id.textView1);
                myRoll= (TextView) v.findViewById(R.id.textView2);
            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row=convertView;
            MyViewHolder holder=null;
            if(row==null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.single_row, parent, false);
                holder=new MyViewHolder(row);
                row.setTag(holder);
                Log.d("CR","Creating new row");
            }
            else
            {
                holder= (MyViewHolder) row.getTag();
                Log.d("CR","Recycling");
            }

            holder.myImage.setImageResource(images[position]);
            holder.myName.setText(titleArray[position]);
            holder.myRoll.setText(rollArray[position]);

            return row;
        }
    }


}
