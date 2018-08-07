package com.example.manhtuan.sampleapp.net;


import com.example.manhtuan.sampleapp.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("json")
    Observable<Response> getRestaurant(@Query("location") String location, @Query("radius") String radius,
                                       @Query("type") String type, @Query("key") String key, @Query("pagetoken") String pageToken);
}
