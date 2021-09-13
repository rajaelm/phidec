package com.example.phidecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class ViewSub extends AppCompatActivity {


    private int position;
    private TextView Etname,Etnomp,EtCredit,EtRs,EtDebit,Etemail,EtTelephone,EtVille,EtCom;
    private String id;
    private ImageButton editButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sub);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");

        Etname = findViewById(R.id.Etname);
        Etnomp = findViewById(R.id.EtNomp);
        EtCredit = findViewById(R.id.Etcredit);
        EtRs = findViewById(R.id.EtRs);
        EtDebit = findViewById(R.id.EtDebit);
        Etemail = findViewById(R.id.Etemail);
        EtTelephone = findViewById(R.id.EtTelephone);
        EtVille = findViewById(R.id.EtVille);
        EtCom =findViewById(R.id.EtCom);


        id = String.valueOf((FirstActivity.list_client.get(position).getId()));
        Etname.setText(FirstActivity.list_client.get(position).getNom_client());
        EtCredit.setText(FirstActivity.list_client.get(position).getCredit());
        Etnomp.setText(FirstActivity.list_client.get(position).getNomp());
        EtRs.setText(FirstActivity.list_client.get(position).getRs());
        EtDebit.setText(FirstActivity.list_client.get(position).getDebit());
        Etemail.setText(FirstActivity.list_client.get(position).getEmail());
        EtTelephone.setText(FirstActivity.list_client.get(position).getPhone());
        EtVille.setText(FirstActivity.list_client.get(position).getVille());
        EtCom.setText(FirstActivity.list_client.get(position).getCom());
        editButton = (ImageButton) findViewById(R.id.edit);
        editButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(ViewSub.this, EditClient.class);
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
                deleteData(String.valueOf(FirstActivity.list_client.get(position).getId()));
            }
        });

    }
    private void deleteData(final String id) {

        StringRequest request = new StringRequest(Request.Method.POST, URLs.DELETE_sub,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("Deleted")){
                            Toast.makeText(ViewSub.this, "Utilisateur supprimé", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ViewSub.this,
                                    FirstActivity.class);
                            startActivity(intent); // startActivity allow you to move
                        }
                        else  if(response.equalsIgnoreCase("Failed")){
                            Toast.makeText(ViewSub.this, "Utilisateur non supprimé essayez à nouveau", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewSub.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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