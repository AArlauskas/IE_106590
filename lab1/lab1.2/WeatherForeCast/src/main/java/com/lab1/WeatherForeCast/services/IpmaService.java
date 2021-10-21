package com.lab1.WeatherForeCast.services;

import com.lab1.WeatherForeCast.models.IpmaCityForeCast;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * IPMA API service mapping
 */
public interface IpmaService {
    @GET("forecast/meteorology/cities/daily/{city_id}.json")
    Call<IpmaCityForeCast> getForecastForACity(@Path("city_id") int cityId);
}

