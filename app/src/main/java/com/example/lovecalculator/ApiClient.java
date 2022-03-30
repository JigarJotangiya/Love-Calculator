package com.example.lovecalculator;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://love-calculator.p.rapidapi.com/";
    public static Retrofit retrofit;

    public static  Retrofit getApiClient(){

        retrofit = new  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }

}
