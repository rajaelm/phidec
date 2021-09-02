package com.example.phidecapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class FirstActivity extends Home {
    public static List<Car> list_car;
    private RecyclerView rv;
    private CarsAdapter adapter;
    private static Context context;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_first);
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
        list_car=new ArrayList<>();
        adapter=new CarsAdapter(list_car);

        getCarData();
        FloatingActionButton button = findViewById(R.id.activeButton);
        button.setOnClickListener(v -> openDialog());
        back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(FirstActivity.this,
                        Home.class);
                startActivity(intent); // startActivity allow you to move
            }
        });
        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(context, rv ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        Intent intent = new Intent(FirstActivity.this, ViewCar.class);
                        intent.putExtra("position",position);
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }
    private void getCarData() {
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URLs.GET_CAR, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("data");
                    for (int i=0; i<array.length(); i++ ){
                        JSONObject ob =array.getJSONObject(i);
                        Car listCar=new Car(ob.getInt("id"),ob.getString("nom"),ob.getString("modele"),ob.getString("matricule"),ob.getString("conducteur"),
                                ob.getString("cg"),ob.getString("dateexp"),ob.getString("npermis"),
                                ob.getString("dateexpp"),ob.getString("cin"),ob.getString("datevcin"),
                                ob.getString("carburant"),ob.getString("assurance"),ob.getString("nchassi"));
                        list_car.add(listCar);
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
        ArrayList<Car> filteredList = new ArrayList<>();

        for (Car car : list_car) {
            if (car.getMatricule().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(car);
            }
        }

        adapter.filterList(filteredList);
    }
    private void openDialog() {
        AddCar.display(getSupportFragmentManager());
    }

}
