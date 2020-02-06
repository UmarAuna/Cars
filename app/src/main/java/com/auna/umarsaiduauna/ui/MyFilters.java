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

import com.auna.umarsaiduauna.R;
import com.auna.umarsaiduauna.adapter.CarAdapter;
import com.auna.umarsaiduauna.model.Cars;
import com.auna.umarsaiduauna.viewmodel.CarViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyFilters extends AppCompatActivity {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    private CarViewModel carViewModel;
    CarAdapter carAdapter;
    List<Cars> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_filters);
        setTitle("My Filters");
        carViewModel = ViewModelProviders.of(this).get(CarViewModel.class);
        initializationViews();

        getCars();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getCars();
            }
        });
    }

    private void initializationViews() {
        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        recyclerView = findViewById(R.id.blogRecyclerView);
    }

    private void getCars() {
        swipeRefreshLayout.setRefreshing(true);
        carViewModel.getAllCar().observe(this, new Observer<List<Cars>>() {
            @Override
            public void onChanged(List<Cars> carsList) {
                swipeRefreshLayout.setRefreshing(false);
                prepareRecyclerView(carsList);
            }
        });
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
