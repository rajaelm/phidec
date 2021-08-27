package com.example.phidecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class EditClient extends AppCompatActivity {
    private int position;
    private EditText Etname,Etusername,EtCin,EtRs,EtAdress,Etemail,EtTelephone,EtVille;
    private int idInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_client);
       // Intent intent = getIntent();
      //  position = intent.getExtras().getInt("position");
        Intent intentReceived = getIntent();
        Bundle data = intentReceived.getExtras();
        if(data != null){
            position = data.getInt("position");
        }else{
            position = 0;
        }

        Etname = findViewById(R.id.Etname);
        Etusername = findViewById(R.id.Etusername);
        EtCin = findViewById(R.id.EtCin);
        EtRs = findViewById(R.id.EtRs);
        EtAdress = findViewById(R.id.EtAdress);
        Etemail = findViewById(R.id.Etemail);
        EtTelephone = findViewById(R.id.EtTelephone);
        EtVille = findViewById(R.id.EtVille);

        idInt = (SecondActivity.list_data.get(position).getId());
        Etname.setText(SecondActivity.list_data.get(position).getNom());
        Etusername.setText(SecondActivity.list_data.get(position).getUsername());
        EtCin.setText(SecondActivity.list_data.get(position).getCin());
        EtRs.setText(SecondActivity.list_data.get(position).getRs());
        EtAdress.setText(SecondActivity.list_data.get(position).getAddresse());
        Etemail.setText(SecondActivity.list_data.get(position).getEmail());
        EtTelephone.setText(SecondActivity.list_data.get(position).getPhone());
        EtVille.setText(SecondActivity.list_data.get(position).getVille());

    }
    public void btn_updateData(View view) {

        final String name = Etname.getText().toString();
        final String username = Etusername.getText().toString();
        final String email = Etemail.getText().toString();
        final String cin = EtCin.getText().toString();
        final String address = EtAdress.getText().toString();
        final String phone = EtTelephone.getText().toString();
        final String ville = EtVille.getText().toString();
        final String rs = EtRs.getText().toString();
        final String id = String.valueOf(idInt);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Enregistrement des modification....");
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.POST, URLs.EDIT_Client,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(EditClient.this, response, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),SecondActivity.class));
                        finish();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(EditClient.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<String,String>();

                params.put("id",id);
                params.put("name",name);
                params.put("username",username);
                params.put("cin",cin);
                params.put("email",email);
                params.put("rs",rs);
                params.put("phone",phone);
                params.put("addresse",address);
                params.put("ville",ville);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(EditClient.this);
        requestQueue.add(request);

    }
}