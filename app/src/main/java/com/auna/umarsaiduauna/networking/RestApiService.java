package com.auna.umarsaiduauna.networking;

import com.auna.umarsaiduauna.model.Cars;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiService {
    @GET("assessment/filter.json")
    Call<List<Cars>> getCars();

}
