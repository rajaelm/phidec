package com.example.phidecapp;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class AddCar extends DialogFragment {
    EditText etName, Etmatricule, Etmodele,Etconducteur,Etcg,etdateexp,Etnpermis,etdateexpp,Etcin,Etdatevcin,Etcarburant,etassurance,Etnchassi;
    Menu menu;
    Button submit;
    private Context mContext;
    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Create string variable to hold the EditText Value.
    String Name,matricule,modele,conducteur,cg,dateexp,npermis,dateexpp,cin,datevcin,carburant,assurance,nchassi;

    // Creating Progress dialog.
    ProgressDialog progressDialog;


    public static final String TAG = "example_dialog";

    private Toolbar toolbar;

    public static AddCar display(FragmentManager fragmentManager) {
        AddCar exampleDialog = new AddCar();
        exampleDialog.show(fragmentManager, TAG);
        return exampleDialog;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme_FullScreenDialog);


    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
            dialog.getWindow().setWindowAnimations(R.style.AppTheme_Slide);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_add_car, container, false);

        toolbar = view.findViewById(R.id.toolbar);
        etName = view.findViewById(R.id.Etname);
        Etmatricule =view.findViewById(R.id.Etmatricule);
        Etmodele =view.findViewById(R.id.Etmodele);
        Etconducteur=view.findViewById(R.id.Etconducteur);
        Etcg=view.findViewById(R.id.Etcg);
        etdateexp=view.findViewById(R.id.dateexp);
        Etnpermis=view.findViewById(R.id.Etnpermis);
        etdateexpp=view.findViewById(R.id.dateexpp);
        Etcin=view.findViewById(R.id.Etcin);
        Etdatevcin=view.findViewById(R.id.Etdatevcin);
        Etcarburant=view.findViewById(R.id.Etcarburant);
        etassurance=view.findViewById(R.id.assurance);
        Etnchassi=view.findViewById(R.id.Etnchassi);

        submit= view.findViewById(R.id.submit);
        // Creating Volley newRequestQueue .
        requestQueue = Volley.newRequestQueue(mContext);

        progressDialog = new ProgressDialog(mContext);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Showing progress dialog at user registration time.
                progressDialog.setMessage("Veuillez patienter...");
                progressDialog.show();

                // Calling method to get value from EditText.
                GetValueFromEditText();

                // Creating string request with post method.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.ADD_Car,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing response message coming from server.
                                Toast.makeText(mContext, ServerResponse, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getActivity(), FirstActivity.class);
                                startActivity(intent);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(mContext, volleyError.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {

                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.

                        params.put("matricule", matricule);
                        params.put("nom", Name);
                        params.put("modele", modele);
                        params.put("conducteur", conducteur);
                        params.put("cg",cg);
                        params.put("dateexp", dateexp);
                        params.put("npermis", npermis);
                        params.put("dateexpp", dateexpp);
                        params.put("cin", cin);

                        params.put("datevcin", datevcin);
                        params.put("carburant", carburant);
                        params.put("assurance", assurance);
                        params.put("nchassi", nchassi);
                        return params;
                    }

                };

                // Creating RequestQueue.
                RequestQueue requestQueue = Volley.newRequestQueue(mContext);

                // Adding the StringRequest object into requestQueue.
                requestQueue.add(stringRequest);

            }
        });

        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setNavigationOnClickListener(v -> dismiss());
        toolbar.setTitle("Ajouter une voiture");
        // toolbar.inflateMenu(R.menu.add_user_menu);
        toolbar.setOnMenuItemClickListener(item -> {
            dismiss();
            return true;
        });
    }
    public void GetValueFromEditText(){
        Name = etName.getText().toString().trim();
        matricule = Etmatricule.getText().toString().trim();
        modele = Etmodele.getText().toString().trim();
        conducteur=Etconducteur.getText().toString().trim();
        cg=Etcg.getText().toString().trim();
        dateexp=etdateexp.getText().toString().trim();
        npermis=Etnpermis.getText().toString().trim();
        dateexpp=etdateexpp.getText().toString().trim();
        cin= Etdatevcin.getText().toString().trim();
        datevcin= Etcin.getText().toString().trim();
        carburant= Etcarburant.getText().toString().trim();
        assurance= etassurance.getText().toString().trim();
        nchassi= Etnchassi.getText().toString().trim();

    }

}