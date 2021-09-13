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
public class Add_client extends DialogFragment {
    EditText etName, etemail,Etnomp, etrs,EtDebit,etville,etphone,EtCredit,etcom;
    Menu menu;
    Button submit;
    private Context mContext;
    // Creating Volley RequestQueue.
    RequestQueue requestQueue;

    // Create string variable to hold the EditText Value.
    String Name,Email,Rs,nomp,Ville,credit,Phone,debit,com;

    // Creating Progress dialog.
    ProgressDialog progressDialog;


    public static final String TAG = "example_dialog";

    private Toolbar toolbar;

    public static Add_client display(FragmentManager fragmentManager) {
        Add_client exampleDialog = new Add_client();
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
        View view = inflater.inflate(R.layout.fragment_add_client, container, false);

        toolbar = view.findViewById(R.id.toolbar);
        etName = view.findViewById(R.id.Etname);
        etemail =view.findViewById(R.id.Etemail);
        Etnomp = view.findViewById(R.id.EtNomp);
        etrs =view.findViewById(R.id.EtRs);
        EtDebit=view.findViewById(R.id.EtDebit);
        EtCredit=view.findViewById(R.id.Etcredit);
        etville=view.findViewById(R.id.EtVille);
        etphone=view.findViewById(R.id.EtTelephone);
        etcom=view.findViewById(R.id.EtCom);



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
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.ADD_sub,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                // Hiding the progress dialog after all task complete.
                                progressDialog.dismiss();

                                // Showing response message coming from server.
                                Toast.makeText(mContext, ServerResponse, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getActivity(), SecondActivity.class);
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
                        params.put("nom_client", Name);
                        params.put("email", Email);
                        params.put("nomp", nomp);
                        params.put("rs", Rs);
                        params.put("credit",credit);
                        params.put("ville", Ville);
                        params.put("debit", debit);
                        params.put("com", com);
                        params.put("phone", Phone);
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
        toolbar.setTitle("Ajouter un client");

        toolbar.setOnMenuItemClickListener(item -> {
            dismiss();
            return true;
        });
    }
    public void GetValueFromEditText(){
        Name = etName.getText().toString().trim();
        Email = etemail.getText().toString().trim();
        Rs = etrs.getText().toString().trim();
        nomp=Etnomp.getText().toString().trim();
        credit=EtCredit.getText().toString().trim();
        Ville=etville.getText().toString().trim();
        debit=EtDebit.getText().toString().trim();
        com=etcom.getText().toString().trim();
        Phone= etphone.getText().toString().trim();
    }
}