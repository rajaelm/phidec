package com.example.phidecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;
import java.util.Map;

public class ViewClient extends AppCompatActivity {

    private int position;
    private TextView Etname,Etusername,EtCin,EtRs,EtAdress,Etemail,EtTelephone,EtVille;
    private String id;
    private ImageButton editButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_client);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        Etname = findViewById(R.id.Etname);
        Etusername = findViewById(R.id.Etusername);
        EtCin = findViewById(R.id.EtCin);
        EtRs = findViewById(R.id.EtRs);
        EtAdress = findViewById(R.id.EtAdress);
        Etemail = findViewById(R.id.Etemail);
        EtTelephone = findViewById(R.id.EtTelephone);
        EtVille = findViewById(R.id.EtVille);



        id = String.valueOf((SecondActivity.list_data.get(position).getId()));
        Etname.setText(SecondActivity.list_data.get(position).getNom());
        Etusername.setText(SecondActivity.list_data.get(position).getUsername());
        EtCin.setText(SecondActivity.list_data.get(position).getCin());
        EtRs.setText(SecondActivity.list_data.get(position).getRs());
        EtAdress.setText(SecondActivity.list_data.get(position).getAddresse());
        Etemail.setText(SecondActivity.list_data.get(position).getEmail());
        EtTelephone.setText(SecondActivity.list_data.get(position).getPhone());
        EtVille.setText(SecondActivity.list_data.get(position).getVille());
        editButton = (ImageButton) findViewById(R.id.edit);
        editButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(ViewClient.this, EditClient.class);
                Bundle data = new Bundle();
                data.putInt("position",position);
                intent.putExtras(data);
                startActivity(intent);

//                intent.putExtra("position",position);
     //           startActivity(intent); // startActivity allow you to move
            }
        });

        FloatingActionButton deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                deleteData(String.valueOf(SecondActivity.list_data.get(position).getId()));
            }
        });

}
    private void deleteData(final String id) {

        StringRequest request = new StringRequest(Request.Method.POST, URLs.DELETE_Client,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("Deleted")){
                            Toast.makeText(ViewClient.this, "Utilisateur supprimé", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ViewClient.this,
                                    SecondActivity.class);
                            startActivity(intent); // startActivity allow you to move
                        }
                        else  if(response.equalsIgnoreCase("Failed")){
                            Toast.makeText(ViewClient.this, "Utilisateur non supprimé essayez à nouveau", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewClient.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();
                params.put("id", id);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }

}
