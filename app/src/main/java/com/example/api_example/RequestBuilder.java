package com.example.api_example;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestBuilder {

    private static String URL = "https://mptenglishlearning.ru/api/";
    private static Retrofit retrofit = null;

    static Retrofit buildRequest(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }
}
