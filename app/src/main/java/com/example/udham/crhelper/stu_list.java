package com.example.udham.crhelper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class stu_list extends Activity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_list);
        list=(ListView) findViewById(R.id.stulistView);
        list.setAdapter(new crAdapter(this));

    }


    class SingleRow
    {
        String names;
        String roll;
        int image;


       SingleRow(String names, String roll,int image) {
            this.names=names;
            this.roll=roll;
            this.image=image;
        }
    }

    class crAdapter extends BaseAdapter
    {

        ArrayList<SingleRow> list;
        Context context;
        crAdapter(Context c)
        {
            context=c;
            list=new ArrayList<SingleRow>();

            Resources res=c.getResources();
            String[] names=res.getStringArray(R.array.names);
            String[] roll=res.getStringArray(R.array.roll);
            int[] image={R.drawable.profile,R.drawable.profile,R.drawable.profile,R.drawable.profile,R.drawable.profile,R.drawable.profile,R.drawable.profile};

            for(int i=0;i<8;i++)
            {
                list.add(new SingleRow(names[i],roll[i],image[i]));
            }
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=inflater.inflate(R.layout.single_row, parent , false);

            TextView names=(TextView)row.findViewById(R.id.textView1);
            TextView roll=(TextView)row.findViewById(R.id.textView2);
            TextView image=(TextView)row.findViewById(R.id.imageView);

            SingleRow temp=list.get(position);

            names.setText(temp.names);
            roll.setText(temp.roll);
            image.setText(temp.image);


            return null;
        }
    }


}
