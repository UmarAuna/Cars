package com.auna.umarsaiduauna.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.auna.umarsaiduauna.model.Cars;
import com.auna.umarsaiduauna.networking.RestApiService;
import com.auna.umarsaiduauna.networking.RetrofitInstance;
import com.auna.umarsaiduauna.utils.MyApp;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarRepository {
    private MutableLiveData<List<Cars>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    private List<Cars> carList;

    public CarRepository(Application application){
        this.application = application;
    }

    public MutableLiveData<List<Cars>> getMutableLiveData(){
        RestApiService  apiService = RetrofitInstance.getService();
        Call<List<Cars>> call = apiService.getCars();

        call.enqueue(new Callback<List<Cars>>() {
            @Override
            public void onResponse(@NotNull Call<List<Cars>> call, @NotNull Response<List<Cars>> response) {
                carList = response.body();
                mutableLiveData.setValue(carList);
                Log.d("TAG", "" + carList);
            }

            @Override
            public void onFailure(@NotNull Call<List<Cars>> call,  @NotNull Throwable t) {
                Log.d("TAG", "" + t);
            }
        });

        return mutableLiveData;
    }

}
