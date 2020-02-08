package com.auna.umarsaiduauna.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.auna.umarsaiduauna.R;
import com.auna.umarsaiduauna.adapter.CarAdapter;
import com.auna.umarsaiduauna.model.Cars;
import com.auna.umarsaiduauna.networking.NetworkStatus;
import com.auna.umarsaiduauna.viewmodel.CarViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyFilters extends AppCompatActivity {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    private CarViewModel carViewModel;
    CarAdapter carAdapter;
    List<Cars> orders;
    ImageView imageView2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_filters);
        setTitle("My Filters");
        carViewModel = new ViewModelProvider(this).get(CarViewModel.class);
        initializationViews();

        getCars();

        swipeRefreshLayout.setOnRefreshListener(this::getCars);
    }

    private void initializationViews() {
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        recyclerView = findViewById(R.id.blogRecyclerView);
        textView = findViewById(R.id.textView);
        imageView2 = findViewById(R.id.imageView2);
    }

    private void getCars() {
        if(new NetworkStatus().isOnline(getApplicationContext())){
            swipeRefreshLayout.setRefreshing(true);
            carViewModel.getAllCar().observe(this, carsList -> {
                swipeRefreshLayout.setRefreshing(false);
                prepareRecyclerView(carsList);
                imageView2.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
            });
        }else{
            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            imageView2.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
        }

    }


    private void prepareRecyclerView(List<Cars> carsList){
        carAdapter = new CarAdapter(this,carsList);
        orders = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(carAdapter);
        carAdapter.notifyDataSetChanged();
    }



}
