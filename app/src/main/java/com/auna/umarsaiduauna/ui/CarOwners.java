package com.auna.umarsaiduauna.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import com.auna.umarsaiduauna.R;
import com.auna.umarsaiduauna.adapter.CSVReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CarOwners extends ListActivity {
    ArrayList<HashMap<String, String>> csvdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Car Owners");
        new Mytask().execute();

    }

    class Mytask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            CSVReader csvreader = new CSVReader(CarOwners.this,
                    "car_ownsers_data.csv");

            try {
                csvdata = csvreader.ReadCSV();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            // keys of hashmap
            String[] from = { "row[1]","row[2]" , "row[3]" , "row[4]" , "row[5]" , "row[6]" , "row[7]", "row[8]" , "row[9]", "row[10]"};

            // view id's to which data to be binded
            int[] to = { R.id.first_name , R.id.last_name, R.id.email, R.id.country, R.id.car_model, R.id.car_color, R.id.car_model_year, R.id.gender, R.id.job_title, R.id.bio};

            // Creating Adapter
            ListAdapter adapter = new SimpleAdapter(CarOwners.this, csvdata,
                    R.layout.activity_car_owners, from, to);

            // Setting Adapter to ListView
            setListAdapter(adapter);

        }

    }
}
