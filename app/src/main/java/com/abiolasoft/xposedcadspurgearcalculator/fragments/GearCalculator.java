package com.abiolasoft.xposedcadspurgearcalculator.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.abiolasoft.xposedcadspurgearcalculator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GearCalculator extends Fragment implements View.OnTouchListener {


    private TextInputLayout moduleView, numOfTeethView, diametralPitchView, circularPitchView, dedendumView, outsideDiameterView;
    private TextInputLayout rootDiameterView, diameterOfBaseView, circularToothView, wholeDepthView, clearanceView, pitchDiameterView;
    private RadioGroup pAngleGroup;

    private RadioButton angle145, angle20, angle25;

    private Button calculate, reset;


    private View view;


    public GearCalculator() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gear_calculator, container, false);

        //TextInputLayout setup
        moduleView = view.findViewById(R.id.module);
        numOfTeethView = view.findViewById(R.id.number_of_teeth);
        diametralPitchView = view.findViewById(R.id.diametral_pitch);
        circularPitchView = view.findViewById(R.id.circular_pitch);
        dedendumView = view.findViewById(R.id.dedendum);
        outsideDiameterView = view.findViewById(R.id.outside_diameter);
        pitchDiameterView = view.findViewById(R.id.pitch_diameter);
        rootDiameterView = view.findViewById(R.id.root_diameter);
        diameterOfBaseView = view.findViewById(R.id.diameter_of_basecircle);
        circularToothView = view.findViewById(R.id.circular_tooth_thickness);
        wholeDepthView = view.findViewById(R.id.whole_depth);
        clearanceView = view.findViewById(R.id.clearance);

        //radioButtonGroup
        pAngleGroup = view.findViewById(R.id.p_angle_group);

        //buttons
        calculate = view.findViewById(R.id.calculate);
        reset = view.findViewById(R.id.reset);

        //radios
        angle145 = view.findViewById(R.id.p_angle_145);
        angle20 = view.findViewById(R.id.p_angle_20);
        angle25 = view.findViewById(R.id.p_angle_25);

        calculate.setOnTouchListener(this);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doCalculation();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetCalculator();
            }
        });
        reset.setOnTouchListener(this);


        return view;


    }

    private void resetCalculator() {

        moduleView.getEditText().setText(String.valueOf(""));
        numOfTeethView.getEditText().setText(String.valueOf(""));
        diametralPitchView.getEditText().setText(String.valueOf(""));
        circularPitchView.getEditText().setText(String.valueOf(""));
        dedendumView.getEditText().setText(String.valueOf(""));
        outsideDiameterView.getEditText().setText(String.valueOf(""));
        pitchDiameterView.getEditText().setText(String.valueOf(""));
        rootDiameterView.getEditText().setText(String.valueOf(""));
        diameterOfBaseView.getEditText().setText(String.valueOf(""));
        circularToothView.getEditText().setText(String.valueOf(""));
        wholeDepthView.getEditText().setText(String.valueOf(""));
        clearanceView.getEditText().setText(String.valueOf(""));

    }

    private void doCalculation() {

        double module = 0;  // mod ule
        double addendum = 0; //addendum
        double number_of_teeth = 0; //number of teeth
        double pressure_angle = 0;  // pressure angle
        double diametral_pitch = 0; //diametral pitch
        double circular_pitch = 0; //circular pitch
        double dedendum = 0; //dedendumView
        double outside_diameter = 0; //outside diameter
        double pitch_diameter = 0; //pitch diameter
        double root_diameter = 0; //root diameter
        double diameter_base_circle = 0; //diameter of base circle
        double tooth_thickness = 0; //tooth thickness
        double whole_depth = 0; //whole depth
        double clearance = 0; //clearanceView

        double stF = 0.167; // standard factor


        try {
            module = Double.valueOf(this.moduleView.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            number_of_teeth = Double.valueOf(numOfTeethView.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            diametral_pitch = Double.valueOf(diametralPitchView.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            circular_pitch = Double.valueOf(circularPitchView.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            dedendum = Double.valueOf(this.dedendumView.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            outside_diameter = Double.valueOf(outsideDiameterView.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            pitch_diameter = Double.valueOf(pitchDiameterView.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            root_diameter = Double.valueOf(rootDiameterView.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            diameter_base_circle = Double.valueOf(diameterOfBaseView.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            tooth_thickness = Double.valueOf(circularToothView.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            whole_depth = Double.valueOf(wholeDepthView.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            clearance = Double.valueOf(this.clearanceView.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if(angle145.isChecked()){
            pressure_angle = Double.valueOf(angle145.getText().toString());
        } else if(angle20.isChecked()){
            pressure_angle = Double.valueOf(angle20.getText().toString());
        } else {
            pressure_angle = Double.valueOf(angle25.getText().toString());
        }


        boolean confirm = true;
        int confirm_solvable = -1;

        while (confirm) {
            confirm = false;
            confirm_solvable++;

            if (number_of_teeth == 0 && module > 0 && pitch_diameter > 0) {
                number_of_teeth = (pitch_diameter / module);

                confirm = true;
            }
            if (number_of_teeth == 0 && outside_diameter > 0 && module > 0) {
                number_of_teeth = ((outside_diameter - (2.0d * module)) / module);

                confirm = true;
            }
            if (clearance == 0 && module > 0) {
                clearance = (stF * module);

                confirm = true;
            }
            if (pitch_diameter == 0 && module > 0 && number_of_teeth > 0) {
                pitch_diameter = (module * number_of_teeth);

                confirm = true;
            }
            if (pitch_diameter == 0 && diametral_pitch > 0 && number_of_teeth > 0) {
                pitch_diameter = ((number_of_teeth * diametral_pitch) / 3.14d);

                confirm = true;
            }
            if (module == 0 && addendum > 0) {
                module = addendum;

                confirm = true;
            }
            if (module == 0 && pitch_diameter > 0 && number_of_teeth > 0) {
                module = (pitch_diameter / number_of_teeth);

                confirm = true;
            }
            if (module == 0 && outside_diameter > 0 && number_of_teeth > 0) {
                module = (outside_diameter / (number_of_teeth + 2.0d));

                confirm = true;
            }
            if (module == 0 && diametral_pitch > 0) {
                module = (diametral_pitch / 3.14d);

                confirm = true;
            }
            if (module == 0 && whole_depth > 0) {
                module = (whole_depth / (2.0d + stF));

                confirm = true;
            }
            if (addendum == 0 && module > 0) {
                addendum = module;

                confirm = true;
            }
            if (outside_diameter == 0 && pitch_diameter > 0 && module > 0) {
                outside_diameter = (pitch_diameter + (2.0d * module));

                confirm = true;
            }
            if (outside_diameter == 0 && number_of_teeth > 0 && module > 0) {
                outside_diameter = (module * (number_of_teeth + 2.0d));

                confirm = true;
            }
            if (outside_diameter == 0 && root_diameter > 0 && whole_depth > 0) {
                outside_diameter = (root_diameter + (2.0d * whole_depth));

                confirm = true;
            }
            if (root_diameter == 0 && pitch_diameter > 0 && module > 0 && clearance > 0) {
                root_diameter = (pitch_diameter - (2.0d * (module + clearance)));

                confirm = true;
            }
            if (root_diameter == 0 && outside_diameter > 0 && module > 0 && clearance > 0) {
                root_diameter = (outside_diameter - (2.0d * (2.0d * (module + clearance))));

                confirm = true;
            }
            if (whole_depth == 0 && clearance > 0 && module > 0) {
                whole_depth = ((2.0d * module) + clearance);

                confirm = true;
            }
            if (dedendum == 0 && clearance > 0 && module > 0) {
                dedendum = (module + clearance);

                confirm = true;
            }
            if (diametral_pitch == 0 && circular_pitch > 0) {
                diametral_pitch = (3.14d / circular_pitch);

                confirm = true;
            }
            if (diametral_pitch == 0 && outside_diameter > 0 && number_of_teeth > 0) {
                diametral_pitch = ((number_of_teeth + 2) / outside_diameter);

                confirm = true;
            }

            if (tooth_thickness == 0 && module > 0) {
                tooth_thickness = 1.5708 / (1 / module);

                confirm = true;
            }

            if (circular_pitch == 0 && diametral_pitch > 0) {
                circular_pitch = 3.14d / diametral_pitch;

                confirm = true;
            }
            if (pitch_diameter > 0 && pressure_angle > 0) {
                diameter_base_circle = pitch_diameter * Math.cos(pressure_angle);
            }

        }


        if (confirm_solvable == 1) {
            moduleView.getEditText().setText(String.valueOf(module));
            numOfTeethView.getEditText().setText(String.valueOf(number_of_teeth));
            diametralPitchView.getEditText().setText(String.valueOf(diametral_pitch));
            circularPitchView.getEditText().setText(String.valueOf(circular_pitch));
            dedendumView.getEditText().setText(String.valueOf(dedendum));
            outsideDiameterView.getEditText().setText(String.valueOf(outside_diameter));
            pitchDiameterView.getEditText().setText(String.valueOf(pitch_diameter));
            rootDiameterView.getEditText().setText(String.valueOf(root_diameter));
            diameterOfBaseView.getEditText().setText(String.valueOf(diameter_base_circle));
            circularToothView.getEditText().setText(String.valueOf(tooth_thickness));
            wholeDepthView.getEditText().setText(String.valueOf(whole_depth));
            clearanceView.getEditText().setText(String.valueOf(clearance));
        }


        if (confirm_solvable == 0) {
            Toast.makeText(getContext(), "The values you supplied are not sufficient to perform any calculation", Toast.LENGTH_LONG ).show();
        } else {
            Toast.makeText(getContext(), "Calculation successful", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public boolean onTouch(View v, MotionEvent event)
    {

        if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE)
        {
            v.setBackgroundColor(Color.parseColor("#000000"));
        }

        if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL)
        {
            v.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        return false;
    }
}
