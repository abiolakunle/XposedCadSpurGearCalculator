package com.abiolasoft.xposedcadspurgearcalculator.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abiolasoft.xposedcadspurgearcalculator.R;
import com.abiolasoft.xposedcadspurgearcalculator.adapters.FormulaeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GearFormulae extends Fragment {

    private int[] formula_images;
    private FormulaeAdapter formulaeAdapter;
    private RecyclerView formulaRecycler;


    public GearFormulae() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflates the view for the fragement
        View view = inflater.inflate(R.layout.fragment_gear_formulae, container, false);

        formulaRecycler = view.findViewById(R.id.formula_rv);

        //array of resource id  of formula images
        formula_images = new int[]{
                R.drawable.pitch_diameter,
                R.drawable.diametral_pitch,
                R.drawable.addendum,
                R.drawable.dedendum,
                R.drawable.outside_diameter,
                R.drawable.root_diameter,
                R.drawable.base_circle,
                R.drawable.circular_pitch,
                R.drawable.circular_tooth_thickness,
                R.drawable.whole_depth,
                R.drawable.clearance
        };


        formulaeAdapter = new FormulaeAdapter(formula_images);
        formulaRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        formulaRecycler.setAdapter(formulaeAdapter);


        // Inflate the layout for this fragment
        return view;

    }

}
