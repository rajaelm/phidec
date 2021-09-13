package com.example.phidecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.preference.PreferenceManager;

public class Profile extends AppCompatActivity {
    private TextView etName, etEmail,etUsername, ettelephone,etrs,etaddresse,etcin,etVille;
    private User user;
    ImageButton back;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SharedPrefManager sharedPrefManager = SharedPrefManager.getInstance(this);
        user = sharedPrefManager.getUser();

        etName = (TextView) findViewById(R.id.Etname);
        etName.setText(user.getName());

        etEmail = (TextView) findViewById(R.id.Etemail);
        etEmail.setText(user.getEmail());

        etUsername = (TextView) findViewById(R.id.Etusername);
        etUsername.setText(user.getUsername());

        ettelephone = (TextView) findViewById(R.id.EtTelephone);
        ettelephone.setText(user.getTelephone());

        etrs= (TextView) findViewById(R.id.Etrs);
        etrs.setText(user.getRs());

        etaddresse= (TextView) findViewById(R.id.Etaddresse);
        etaddresse.setText(user.getAddresse());

        etcin= (TextView) findViewById(R.id.EtCin);
        etcin.setText(user.getCin());

        etVille= (TextView) findViewById(R.id.EtVille);
        etVille.setText(user.getVille());

        edit= (Button)findViewById(R.id.Editprof);
        back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Profile.this,
                        Home.class);
                startActivity(intent); // startActivity allow you to move
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Profile.this,
                        EditProfile.class);
                startActivity(intent); // startActivity allow you to move
            }
        });
    }


}