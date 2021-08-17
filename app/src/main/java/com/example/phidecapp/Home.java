package com.example.phidecapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    protected DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    Menu menu;
    TextView textView;
    ImageView imageView;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPrefManager sharedpreferences = SharedPrefManager.getInstance(this);
        user=sharedpreferences.getUser();
        ///** Set header info****////
        NavigationView navigationView = findViewById(R.id.nav_view);
        View header = navigationView.getHeaderView(0);
        TextView username = (TextView) header.findViewById(R.id.username);
        username.setText(user.getName());
        TextView email = (TextView) header.findViewById(R.id.email);
        email.setText(user.getEmail());

        /********************Link to profile********************/
        imageView =(ImageView)header.findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


                Intent intent = new Intent(Home.this,
                        Profile.class);
                startActivity(intent); // startActivity allow you to move
            }
        });
        /*---------------------Hooks------------------------*/
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);
        textView=findViewById(R.id.textView);
        toolbar=findViewById(R.id.toolbar);
        /*---------------------Toolbar------------------------*/
        setSupportActionBar(toolbar);

        /*---------------------Navigation Drawer Menu------------------------*/


        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new
                ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        //navigationView.setCheckedItem(R.id.home);

    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home: break; case R.id.gestion_users:
                Intent intent = new Intent(Home.this, FirstActivity.class);
                startActivity(intent);
                break;
            case R.id.activate_profile:
                intent = new Intent(Home.this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.chat:
                intent = new Intent(Home.this, ThirdActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_logout :  SharedPrefManager.getInstance(getApplicationContext()).logout();
            Toast.makeText(this, "Déconnecter", Toast.LENGTH_SHORT).show();
             intent = new Intent(Home.this,Login.class);
            startActivity(intent);
            finish();break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }
    public static void setDefaults(String key, String value, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getDefaults(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

}