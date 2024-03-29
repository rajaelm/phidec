package com.example.phidecapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EditProfile extends AppCompatActivity {
    private User user;
    EditText etName,etEmail,Etusername,Ettelephoen;
    Button editprof;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        SharedPrefManager sharedPrefManager = SharedPrefManager.getInstance(this);
        user = sharedPrefManager.getUser();
        etName = (EditText) findViewById(R.id.Etname);
        etName.setText(user.getName());
        etEmail = (EditText) findViewById(R.id.Etemail);
        etEmail.setText(user.getEmail());

        Etusername = (EditText) findViewById(R.id.Etusername);
        Etusername.setText(user.getUsername());

        Ettelephoen = (EditText) findViewById(R.id.telephone);
        Ettelephoen.setText(user.getTelephone());

        editprof=(Button)findViewById(R.id.savemodifs);
        editprof.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SaveEditDetail();
            }
        });
        back = (ImageButton) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(EditProfile.this,
                        Profile.class);
                startActivity(intent); // startActivity allow you to move
            }
        });

    }
    private void SaveEditDetail() {

        final String name = etName.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        final String username = Etusername.getText().toString().trim();
        final String tel = Ettelephoen.getText().toString().trim();
        final String id = String.valueOf(user.getId());


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Saving...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.EDIT_PROFILE, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String result) {
                        progressDialog.dismiss();

                        try {
                            JSONObject jsonObject = new JSONObject(result);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")){
                                Toast.makeText(EditProfile.this, "Success!", Toast.LENGTH_SHORT).show();

                        }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();
                            Toast.makeText(EditProfile.this, "Error "+ e.toString(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Profile.class));
                            finish();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(EditProfile.this, "Error "+ error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                params.put("name", name);
                params.put("email", email);
                params.put("username", username);
                params.put("telephone", tel);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);

    }

}