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
    private EditText Etname,EtCredit,EtDebit,EtRs,Etnomp,Etemail,EtTelephone,EtVille,EtCom;
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
        EtCredit = findViewById(R.id.EtCredit);
        EtDebit = findViewById(R.id.EtDebit);
        EtRs = findViewById(R.id.EtRs);
        Etnomp = findViewById(R.id.EtNomp);
        Etemail = findViewById(R.id.Etemail);
        EtTelephone = findViewById(R.id.EtTelephone);
        EtVille = findViewById(R.id.EtVille);
        EtCom = findViewById(R.id.EtCom);

        idInt = (SecondActivity.list_data.get(position).getId());
        Etname.setText(SecondActivity.list_data.get(position).getNom_client());
        EtCredit.setText(SecondActivity.list_data.get(position).getCredit());
        EtDebit.setText(SecondActivity.list_data.get(position).getDebit());
        EtRs.setText(SecondActivity.list_data.get(position).getRs());
        Etnomp.setText(SecondActivity.list_data.get(position).getNomp());
        Etemail.setText(SecondActivity.list_data.get(position).getEmail());
        EtTelephone.setText(SecondActivity.list_data.get(position).getPhone());
        EtVille.setText(SecondActivity.list_data.get(position).getVille());
        EtCom.setText(SecondActivity.list_data.get(position).getCom());

    }
    public void btn_updateData(View view) {

        final String name = Etname.getText().toString();
        final String credit = EtCredit.getText().toString();
        final String email = Etemail.getText().toString();
        final String debit = EtDebit.getText().toString();
        final String nomp = Etnomp.getText().toString();
        final String phone = EtTelephone.getText().toString();
        final String ville = EtVille.getText().toString();
        final String rs = EtRs.getText().toString();
        final String com = EtCom.getText().toString();
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
                params.put("credit",credit);
                params.put("debit",debit);
                params.put("email",email);
                params.put("rs",rs);
                params.put("phone",phone);
                params.put("nomp",nomp);
                params.put("ville",ville);
                params.put("com",com);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(EditClient.this);
        requestQueue.add(request);

    }
}