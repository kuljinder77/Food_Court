package com.example.kuljindersingh.foodcourt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity
{

    Button login;
    EditText username , password;
    TextView warning;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        warning = (TextView) findViewById(R.id.warning) ;
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)

            {
                if(username.getText().toString().equalsIgnoreCase("admin") && password.getText().toString().equalsIgnoreCase("admin"))
                {
                    Intent a = new Intent(getApplicationContext(),front.class);
                    startActivity(a);


                }else
                {

                warning.setText("Please provide correct input");
                }

            }
        });

    }

}
