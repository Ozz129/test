package com.example.prueba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.prueba_sunset.R;


public class SearchDoctor extends Fragment {

    Spinner spinner, spinnerF;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_doctor, container, false);

        spinner = v.findViewById(R.id.spinnerDoctor);
        spinnerF = v.findViewById(R.id.spinnerFinal);

        String[] datos = new String[] {"Doctor Practice", "", "", "", ""};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, datos);

        spinner.setAdapter(adapter);

        String[] datosF = new String[] {"Insurance", "", "", "", ""};
        ArrayAdapter<String> adapterF = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, datos);

        spinnerF.setAdapter(adapterF);
        return v;
    }

}
