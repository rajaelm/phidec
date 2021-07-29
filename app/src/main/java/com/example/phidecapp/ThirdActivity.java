package com.example.phidecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class ThirdActivity extends Home {
User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_home, null, false);
        View contentView2 = inflater.inflate(R.layout.activity_third, null, false);
        drawerLayout.addView(contentView, 0);
        //user= user = SharedPrefManager.getInstance(getActivity()).getUser();
    }
}