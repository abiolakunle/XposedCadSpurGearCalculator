package com.abiolasoft.xposedcadspurgearcalculator.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abiolasoft.xposedcadspurgearcalculator.R;
import com.abiolasoft.xposedcadspurgearcalculator.adapters.TermsAdapter;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class GearTerms extends Fragment {

    private Map<String, String> terms_description;
    private TermsAdapter termsAdapter;
    private RecyclerView termsRecycler;

    public GearTerms() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gear_terms, container, false);

        termsRecycler = view.findViewById(R.id.terms_rv);

        terms_description = new Hashtable<String, String>();
        populateTermMap();
        //get keys from map and put them into array
        String[] terms = terms_description.keySet().toArray(new String[terms_description.size()]);

        termsAdapter = new TermsAdapter(terms, terms_description);
        termsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        termsRecycler.setAdapter(termsAdapter);

        return view;
    }


    public void populateTermMap() {

        terms_description.put("PITCH DIAMETER (D)", "The diameter of the Pitch Circle from which the gear is designed. An imaginary circle, which will contact the pitch circle of another gear when in mesh.");
        terms_description.put("DIAMETRAL PITCH (P)", "A ratio of the number of teeth per inch of pitch diameter.");
        terms_description.put("ADDENDUM (A)", "The radial distance from the pitch circle to the top of the gear tooth.");
        terms_description.put("DEDENDUM (B)", "The radial distance from the pitch circle to the bottom of the tooth.");
        terms_description.put("OUTSIDE DIAMETER (OD)", "The overall diameter of the gear.");
        terms_description.put("ROOT DIAMETER (RD)", "The diameter at the Bottom of the tooth.");
        terms_description.put("BASE CIRCLE (BC)", "The circle used to form the involute section of the gear tooth.");
        terms_description.put("CIRCULAR PITCH (CP)", "The measured distance along the circumference of the Pitch Diameter from the point of one tooth to the corresponding point on an adjacent tooth.");
        terms_description.put("CIRCULAR TOOTH THICKNESS (T)", "Thickness of a tooth measure along the circumference of the Pitch Circle.");
        terms_description.put("WHOLE DEPTH (WD)", "Refers to the distance from the top of the tooth to the bottom of the tooth.");
        terms_description.put("PRESSURE ANGLE (PA)", "It refers to the angle through which forces are transmitted between meshing gears.");
        terms_description.put("CLEARANCE (C)", "Refers to the radial distance between the top and bottom of gears in mesh.");
        terms_description.put("CENTER DISTANCE", "The center distance of two spur gears in mesh is the distance from the center shaft of one spur gear to the center shaft of the other.");
        terms_description.put("PITCH POINT", "It is the point of contact between the pitch circles of two gears in mesh");
        terms_description.put("LINE OF ACTION", "Contact between the teeth of meshing gears take place along a line tangential to the two base circles. This line passes through the pitch point and is called the line of action.");
        terms_description.put("WORKING DEPTH", "It is the maximum depth that the tooth extends into the tooth space of a mating gear. It is the sum of the addenda of the gears.");
        terms_description.put("TOOTH FACE", "Is the surface of a tooth above the pitch circle, parallel to the axis of the gear.");
        terms_description.put("TOOTH FLANK", "Is the tooth surface below the pitch circle, parallel to the axis of the gear.");
    }

}
