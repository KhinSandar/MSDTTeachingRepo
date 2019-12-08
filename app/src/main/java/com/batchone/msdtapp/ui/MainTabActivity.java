package com.batchone.msdtapp.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.batchone.msdtapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.batchone.msdtapp.ui.ui.main.SectionsPagerAdapter;

public class MainTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        Bundle extraes = getIntent().getExtras();
        if (extraes == null) {
            return;
        }
        // get data via the key
        String value1 = extraes.getString("PersonID");//Intent.EXTRA_TEXT
        // do something with the data
        //Toast.makeText(getApplicationContext(),"Value 1 " +value1,Toast.LENGTH_LONG).show();

        if (value1 != null) {

        }else{
            // null case
            value1 = "Null case";
            Toast.makeText(getApplicationContext(),"Value 1 " +value1,Toast.LENGTH_SHORT).show();
        }

        // Getting all extras
        Bundle extras = getIntent().getExtras();
        // Getting your int (second param is the default value if null)
        int value2 = extras.getInt("PersonID", 0);
        Toast.makeText(getApplicationContext(),"Value 1 " + value1 +"value2 " + value2,Toast.LENGTH_SHORT).show();



        SharedPreferences prefs = getSharedPreferences(MainActivity.MY_PREFS_NAME, MODE_PRIVATE);
        final String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
        final int idName = prefs.getInt("id", 0); //0 is the default value.


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action" + name +"/" + idName, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}