package com.example.phidecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FirstActivity extends Home {

/*
    ListView l;
    String tutorials[]
            = { "Algorithms", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies", "CS Subjects",
            "Web ", "CS ",
            " Technologies", "Subjects",
            "Weogies", "Cbjects",
            "Web ologies", "CS bjects",
            "Ws", "Cs"
            };*/

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
       /* LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        /* View contentView = inflater.inflate(R.layout.activity_home, null, false);

        drawerLayout.addView(contentView, 0);

        /*l = findViewById(R.id.list);
        ArrayAdapter<String> arr;
        arr
                = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                tutorials);
        l.setAdapter(arr);*/
        //View contentView1 = inflater.inflate(R.layout.activity_first, null, false);
        //generate list
        ArrayList<String> list = new ArrayList<String>();
        list.add("client 1");
        list.add("client 2");
        list.add("client 3");
        list.add("client 4");
        //instantiate custom adapter
        MyCustomAdapter adapter = new MyCustomAdapter(list, this);

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.list);
        lView.setAdapter(adapter);
    }

}
