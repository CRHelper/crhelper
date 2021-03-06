package com.example.udham.crhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
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
import android.widget.ListView;
import android.widget.TextView;


public class syllabus extends Activity {

    ListView list;
    String[] completion;
    String[] subject;

    String link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        Resources res = getResources();
        completion=res.getStringArray(R.array.completion);
        subject=res.getStringArray(R.array.subject);
        list=(ListView) findViewById(R.id.syllabus_list_view);

        crAdapter adapter=new crAdapter(this,completion,subject);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        public void onItemClick(AdapterView<?> parent, View v,
                                                                int position, long id) {

                                            final String item = (String) parent.getItemAtPosition(position);
                                            Log.d("Stu_List",item);
                                            if(item.equals("completion % 1"))
                                            {

                                                link="https://drive.google.com/uc?export=download&id=0B3JcR1uSjaDXc0JJOFEwUWtabnc";
                                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
                                            }
                                            else  if(item.equals("completion % 2"))
                                            {
                                                link="https://drive.google.com/uc?export=download&id=0B3JcR1uSjaDXUnRwQm9GUzdIVzg";
                                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));


                                            }
                                            if(item.equals("completion % 3"))
                                            {
                                                link="https://drive.google.com/uc?export=download&id=0B3JcR1uSjaDXb0lRdjJlbm9CODQ";
                                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));

                                            }
                                            if(item.equals("completion % 4"))
                                            {
                                                link="https://drive.google.com/uc?export=download&id=0B3JcR1uSjaDXUnRwQm9GUzdIVzg";
                                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));


                                            }


                                        }
                                    }
        );





    }


    class crAdapter extends ArrayAdapter<String>
    {

        Context context;

        String[] titleArray;
        String[] subArray;

        crAdapter(Context c, String[] subject,  String[] completion) {
            super(c, R.layout.assignment_single_row, R.id.textView, subject);
            this.context = c;

            this.titleArray=subject;
            this.subArray=completion;

        }


        class MyViewHolder
        {

            TextView mySub;
            TextView myComp;
            MyViewHolder(View v)
            {

                mySub= (TextView) v.findViewById(R.id.text1);
                myComp= (TextView) v.findViewById(R.id.text2);
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


            holder.myComp.setText(titleArray[position]);
            holder.mySub.setText(subArray[position]);

            return row;
        }
    }

}
