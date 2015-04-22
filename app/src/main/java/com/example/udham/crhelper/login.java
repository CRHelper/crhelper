package com.example.udham.crhelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseUser;

import java.text.ParseException;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class login extends Activity {
    AutoCompleteTextView username=null;
    EditText password=null;
    Button login;
    Button Sign_up;
    public static String uname,pwd;

    TextView out;
    int selectedId;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        input();
        addListenerOnButton();

    }
    public void addListenerOnButton()
    {
        final Context context = this;

        login = (Button) findViewById(R.id.sign_in);
        Sign_up = (Button) findViewById(R.id.action_sign_up);

        Sign_up.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, sign_up.class);
                startActivity(intent);

            }
        });


        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = username.getText().toString();
                pwd = password.getText().toString();

                ParseUser.logInInBackground(uname, pwd, new LogInCallback() {
                    public void done(ParseUser user, com.parse.ParseException e) {
                        if (user != null) {

                            if(data.equals("student"))
                            {
                                student_login();
                            }
                            else
                            {
                                teacher_login();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();

                        }
                    }

                });
            }

        });


    }

    public void input()
    {
        try {
            out = (TextView) findViewById(R.id.textView);
            username = (AutoCompleteTextView) findViewById(R.id.email);
            password = (EditText) findViewById(R.id.password);

            data = getIntent().getExtras().getString("key");


        }catch(Exception e)
        {
            out.setText("Please Input valid text/password");
        }
    }
    public void teacher_login()
    {
        Intent intent = new Intent(this, teachersActivity.class);
        startActivity(intent);
    }

    public void student_login()
    {
        Intent intent = new Intent(this, StudentActivity.class);
        startActivity(intent);
    }

}
