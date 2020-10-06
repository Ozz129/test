package com.example.prueba;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiInterface {

    @FormUrlEncoded
    @POST("client/registre")
    public Call<Object> register(
            @Field("tipoDocumento") String type,
            @Field("numeroIdentificacion") String identification,
            @Field("nombres") String name,
            @Field("apellidos") String surname,
            @Field("telefonoMovil") String phone,
            @Field("correo") String email,
            @Field("password") String pass

    );

    @GET("establishment/getAllEstablishment")
    Call <rtaModel> getList();
}
