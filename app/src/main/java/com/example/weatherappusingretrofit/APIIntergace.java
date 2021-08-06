package com.example.weatherappusingretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIIntergace {


    @GET("weather?appid=4cd885359ac660f69f7b29d6ddd49bac&units=metric")
    Call<Example> getWeatherData(@Query("q") String name);
}
