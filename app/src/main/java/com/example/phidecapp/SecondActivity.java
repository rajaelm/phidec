package com.example.phidecapp;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity  extends Home {
    public static List<List_data> list_data;
    private RecyclerView rv;
    private MyAdapter adapter;
    private static Context context;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        /*****Search*********/
        EditText search = findViewById(R.id.edittextsearch);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        /*****************************************/
        rv=(RecyclerView)findViewById(R.id.recyclerview);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list_data=new ArrayList<>();
        adapter=new MyAdapter(list_data);

        getClientData();
        FloatingActionButton button = findViewById(R.id.activeButton);
        button.setOnClickListener(v -> openDialog());
        back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(SecondActivity.this,
                        Home.class);
                startActivity(intent); // startActivity allow you to move
            }
        });
        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(context, rv ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        Intent intent = new Intent(SecondActivity.this, ViewClient.class);
                        intent.putExtra("position",position);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }
    private void getClientData() {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URLs.URL_Client, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("data");
                    for (int i=0; i<array.length(); i++ ){
                        JSONObject ob =array.getJSONObject(i);
                        List_data listData=new List_data(ob.getInt("id"),ob.getString("nom"),ob.getString("username"),ob.getString("email"),ob.getString("cin"),ob.getString("ville"), ob.getString("rs"),ob.getString("phone"),ob.getString("addresse"));
                        list_data.add(listData);
                    }
                    rv.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    ///////////////////*****Search***************///////////////
    private void filter(String text) {
        ArrayList<List_data> filteredList = new ArrayList<>();

        for (List_data client : list_data) {
            if (client.getNom().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(client);
            }
        }

        adapter.filterList(filteredList);
    }
    private void openDialog() {
        Add_user.display(getSupportFragmentManager());
    }
}