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

public class ViewCar extends AppCompatActivity {

    private int position;
    private TextView Etname,Etmatricule,EtModele,EtConducteur,EtCg,Etdateexp,Etnpermis,Etdateexpp,EtCin,Etdatevcin,EtCarburant,EtAssurance,Etnchassi;
    private String id;
    private ImageButton editButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_car);

        Intent intent =getIntent();
        position = intent.getExtras().getInt("position");
        Etmatricule = findViewById(R.id.Etmatricule);
        Etname = findViewById(R.id.Etname);

        EtModele = findViewById(R.id.EtModele);
        EtConducteur = findViewById(R.id.EtConducteur);
        EtCg = findViewById(R.id.EtCg);
        Etdateexp = findViewById(R.id.Etdateexp);
        Etnpermis = findViewById(R.id.Etnpermis);
        Etdateexpp = findViewById(R.id.Etdateexpp);
        EtCin =findViewById(R.id.EtCin);
        Etdatevcin =findViewById(R.id.Etdatevcin);
        EtCarburant =findViewById(R.id.EtCarburant);
        EtAssurance =findViewById(R.id.EtAssurance);
        Etnchassi =findViewById(R.id.Etnchassi);


        id = String.valueOf((FirstActivity.list_car.get(position).getId()));
        Etname.setText(FirstActivity.list_car.get(position).getNom());
        Etmatricule.setText(FirstActivity.list_car.get(position).getMatricule());
        EtModele.setText(FirstActivity.list_car.get(position).getModele());
        EtConducteur.setText(FirstActivity.list_car.get(position).getConducteur());
        EtCg.setText(FirstActivity.list_car.get(position).getCg());
        Etdateexp.setText(FirstActivity.list_car.get(position).getDateexp());
        Etnpermis.setText(FirstActivity.list_car.get(position).getNpermis());
        Etdateexpp.setText(FirstActivity.list_car.get(position).getGetDateexpp());
        EtCin.setText(FirstActivity.list_car.get(position).getCin());
        Etdatevcin.setText(FirstActivity.list_car.get(position).getDatevcin());
        EtCarburant.setText(FirstActivity.list_car.get(position).getCarburant());
        EtAssurance.setText(FirstActivity.list_car.get(position).getAssurance());
        Etnchassi.setText(FirstActivity.list_car.get(position).getNchassi());

        editButton = (ImageButton) findViewById(R.id.edit);
       /* editButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(ViewCar.this, EditClient.class);
                Bundle data = new Bundle();
                data.putInt("position",position);
                intent.putExtras(data);
                startActivity(intent);

//                intent.putExtra("position",position);
                //           startActivity(intent); // startActivity allow you to move
            }
        });
*/
        FloatingActionButton deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                deleteData(String.valueOf(FirstActivity.list_car.get(position).getId()));
            }
        });

    }
    private void deleteData(final String id) {

        StringRequest request = new StringRequest(Request.Method.POST, URLs.DELETE_Car,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equalsIgnoreCase("Deleted")){
                            Toast.makeText(ViewCar.this, "Voiture supprimée", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ViewCar.this,
                                    SecondActivity.class);
                            startActivity(intent); // startActivity allow you to move
                        }
                        else  if(response.equalsIgnoreCase("Failed")){
                            Toast.makeText(ViewCar.this, "Voiture non supprimé essayez à nouveau", Toast.LENGTH_SHORT).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ViewCar.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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