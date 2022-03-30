package com.example.lovecalculator;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("getPercentage")
    Call<LoveData>getper(@Query("sname")String sname,
                        @Query("fname")String fname,
                        @Header("X-RapidAPI-Host")String host,
                        @Header("X-RapidAPI-Key")String key);

}
