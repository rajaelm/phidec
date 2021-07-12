package com.example.phidecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Signup extends AppCompatActivity {
    private TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        login = (TextView) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /*
                 * Intent is just like glue which helps to navigate one activity
                 * to another.
                 */
                Intent intent = new Intent(Signup.this,
                        Login.class);
                startActivity(intent); // startActivity allow you to move
            }
        });
    }
}