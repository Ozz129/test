package com.example.prueba;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prueba_sunset.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Splash extends AppCompatActivity {
    private Timer timer;
    private ProgressBar progressBar;
    private int i = 0;
    TextView text;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        getData();
    }
    private void getData() {
        apiInterface service = ApiClient.getClient().create(apiInterface.class);

        Call<rtaModel> getDataCall = service.getList();

        getDataCall.enqueue(new Callback<rtaModel>() {

            @Override
            public void onResponse(Call<rtaModel> call, Response<rtaModel> response) {
                rtaModel rta = response.body();
                List<dataModel> rta2 = rta.getData();
                Toast.makeText(Splash.this, "CREADO CON EXITO " + rta2.get(0), Toast.LENGTH_SHORT).show();
                lst = findViewById(R.id.list);
                List<String> adapter = new ArrayList<String>();
                String[] nombres = new String[rta2.size()];
                for (int i = 0; i < rta2.size(); i++) {
                    nombres[i] = ""+rta2.get(i).nombre;
                }

                ArrayAdapter<String> adaptador = new ArrayAdapter<String>(Splash.this, android.R.layout.simple_list_item_1, nombres);
                lst.setAdapter((ListAdapter) adaptador);
            }

            @Override
            public void onFailure(Call<rtaModel> call, Throwable t) {
                Toast.makeText(Splash.this, "ERROR " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
