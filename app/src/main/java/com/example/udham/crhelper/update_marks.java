
package com.example.udham.crhelper;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class update_marks extends Activity {

    EditText roll,attn;
    Button update;
    RadioGroup rgp;
    RadioButton rb;

    String roll_no,attendance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_marks);
        getdata();

        addListenerButton();
    }

    public void getdata()
    {
        roll=(EditText) findViewById(R.id.roll_no);
        attn=(EditText) findViewById(R.id.attn);
        rgp=(RadioGroup) findViewById(R.id.radioGroup);
        update=(Button) findViewById(R.id.update);



    }
    public void addListenerButton()
    {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                roll_no=roll.getText().toString();
                attendance=attn.getText().toString();

                int sel=rgp.getCheckedRadioButtonId();
                rb = (RadioButton) findViewById(sel);
                final String ch=rb.getText().toString();

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    public Void doInBackground(Void... params) {


                        ParseQuery<ParseObject> query = ParseQuery.getQuery("Marks");
                        query.whereEqualTo("Roll_No",roll_no);
                        query.findInBackground(new FindCallback<ParseObject>() {
                            @Override
                            public void done(List<ParseObject> userList, com.parse.ParseException e) {
                                if (e == null) {
                                    if (userList.size() > 0) {

                                        for (int i = 0; i < userList.size(); i++) {
                                            ParseObject p = userList.get(i);
                                            p.put(ch,attendance);
                                            p.saveInBackground();


                                            Toast.makeText(update_marks.this,
                                                    "Updating...", Toast.LENGTH_LONG).show();


                                        }
                                    }

                                }
                            }
                        });

                        return null;
                    }
                }.execute();




            }
        });

    }


}



