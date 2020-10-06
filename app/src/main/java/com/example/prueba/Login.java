package com.example.prueba;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba_sunset.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    Button listar, registrar;
    EditText name, surname, identification, email, phone;
    Object response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        name =  findViewById(R.id.edt_name);
        surname =  findViewById(R.id.edt_surname);
        identification = findViewById(R.id.edt_identification);
        email = findViewById(R.id.edt_email);
        phone = findViewById(R.id.edt_phone);

        listar = findViewById(R.id.btn_listar);

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //registrar();
                Intent goSplash = new Intent(Login.this, Splash.class);
                startActivity(goSplash);

            }
        });

        registrar = findViewById(R.id.btn_registrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });
    }

    private void registrar() {
        apiInterface service = ApiClient.getClient().create(apiInterface.class);

        String document_type = "cc";
        String nombre = name.getText().toString();
        String apellido = surname.getText().toString();
        String telefono = phone.getText().toString();
        String correo = email.getText().toString();
        String identificacion = identification.toString();

        Call<Object> getCall = service.register(document_type, identificacion, nombre, apellido, telefono, correo, "123");

        getCall.enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                // la documentacion no presenta un mapa claro de la respuesta a este servicio
                    Toast.makeText(Login.this, "CREADO CON EXITO ", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Toast.makeText(Login.this, "ERROR " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
