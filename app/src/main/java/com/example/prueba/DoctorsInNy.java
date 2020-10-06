package com.example.prueba;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.prueba_sunset.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DoctorsInNy.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DoctorsInNy#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DoctorsInNy extends Fragment {
        Spinner sp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doctors_in_ny, container, false);

        sp = v.findViewById(R.id.spNy);

        String[] datos = new String[] {"Sort by", "", "", "", ""};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, datos);

        sp.setAdapter(adapter);

        return v;
    }
}
