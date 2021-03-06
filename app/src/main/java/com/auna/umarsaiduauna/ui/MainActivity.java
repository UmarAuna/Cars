package com.auna.umarsaiduauna.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.auna.umarsaiduauna.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cardViewFilter(View v){
       startActivity(new Intent(MainActivity.this, MyFilters.class));
    }

    public void cardViewOwner(View v){
        startActivity(new Intent(MainActivity.this, CarOwners.class));
    }
}
