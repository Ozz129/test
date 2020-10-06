package com.example.prueba;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ApiClient {

    private static Retrofit retrofit = null;

    static Retrofit getClient (){
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        retrofit = new Retrofit.Builder().baseUrl("https://apiprueba.gopass.com.co/").
                addConverterFactory(GsonConverterFactory.create()).
                client(client.build()).build();

        return retrofit;
    }
}
