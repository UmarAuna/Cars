package com.auna.umarsaiduauna.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.auna.umarsaiduauna.model.Cars;
import com.auna.umarsaiduauna.repository.CarRepository;

import java.util.List;

public class CarViewModel extends AndroidViewModel {
    private CarRepository carRepository;

    public CarViewModel(@NonNull Application application) {
        super(application);
        carRepository = new CarRepository(application);
    }

    public LiveData<List<Cars>> getAllCar(){
        return carRepository.getMutableLiveData();
    }
}
