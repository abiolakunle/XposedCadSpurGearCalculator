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


    private TextInputLayout module, numOfTeeth, diametralPitch, circularPitch, dedendum, outsideDiameter, pitchDiameter;
    private TextInputLayout rootDiameter, diameterOfBase, circularTooth, wholeDepth, clearance;
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
        module = view.findViewById(R.id.module);
        numOfTeeth = view.findViewById(R.id.number_of_teeth);
        diametralPitch = view.findViewById(R.id.diametral_pitch);
        circularPitch = view.findViewById(R.id.circular_pitch);
        dedendum = view.findViewById(R.id.dedendum);
        outsideDiameter = view.findViewById(R.id.outside_diameter);
        pitchDiameter = view.findViewById(R.id.pitch_diameter);
        rootDiameter = view.findViewById(R.id.root_diameter);
        diameterOfBase = view.findViewById(R.id.diameter_of_basecircle);
        circularTooth = view.findViewById(R.id.circular_tooth_thickness);
        wholeDepth = view.findViewById(R.id.whole_depth);
        clearance = view.findViewById(R.id.clearance);

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

        module.getEditText().setText(String.valueOf(""));
        numOfTeeth.getEditText().setText(String.valueOf(""));
        diametralPitch.getEditText().setText(String.valueOf(""));
        circularPitch.getEditText().setText(String.valueOf(""));
        dedendum.getEditText().setText(String.valueOf(""));
        outsideDiameter.getEditText().setText(String.valueOf(""));
        pitchDiameter.getEditText().setText(String.valueOf(""));
        rootDiameter.getEditText().setText(String.valueOf(""));
        diameterOfBase.getEditText().setText(String.valueOf(""));
        circularTooth.getEditText().setText(String.valueOf(""));
        wholeDepth.getEditText().setText(String.valueOf(""));
        clearance.getEditText().setText(String.valueOf(""));

    }

    private void doCalculation() {

        double mod = 0;  // mod ule
        double add = 0; //addendum
        double noT = 0; //number of teeth
        double pAng = 0;  // pressure angle
        double diP = 0; //diametral pitch
        double ciP = 0; //circular pitch
        double ded = 0; //dedendum
        double ouD = 0; //outside diameter
        double piD = 0; //pitch diameter
        double roD = 0; //root diameter
        double doB = 0; //diameter of base circle
        double toT = 0; //tooth thickness
        double whD = 0; //whole depth
        double clr = 0; //clearance

        double stF = 0.167; // standard factor


        try {
            mod = Double.valueOf(module.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            noT = Double.valueOf(numOfTeeth.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            diP = Double.valueOf(diametralPitch.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            ciP = Double.valueOf(circularPitch.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            ded = Double.valueOf(dedendum.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            ouD = Double.valueOf(outsideDiameter.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            piD = Double.valueOf(pitchDiameter.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            roD = Double.valueOf(rootDiameter.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            doB = Double.valueOf(diameterOfBase.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            toT = Double.valueOf(circularTooth.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            whD = Double.valueOf(wholeDepth.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            clr = Double.valueOf(clearance.getEditText().getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if(angle145.isChecked()){
            pAng = Double.valueOf(angle145.getText().toString());
        } else if(angle20.isChecked()){
            pAng = Double.valueOf(angle20.getText().toString());
        } else {
            pAng = Double.valueOf(angle25.getText().toString());
        }


        boolean confirm = true;
        int confirm_solvable = -1;

        while (confirm) {
            confirm = false;
            confirm_solvable++;

            if (noT == 0 && mod > 0 && piD > 0) {
                noT = (piD / mod);

                confirm = true;
            }
            if (noT == 0 && ouD > 0 && mod > 0) {
                noT = ((ouD - (2.0d * mod)) / mod);

                confirm = true;
            }
            if (clr == 0 && mod > 0) {
                clr = (stF * mod);

                confirm = true;
            }
            if (piD == 0 && mod > 0 && noT > 0) {
                piD = (mod * noT);

                confirm = true;
            }
            if (piD == 0 && diP > 0 && noT > 0) {
                piD = ((noT * diP) / 3.14d);

                confirm = true;
            }
            if (mod == 0 && add > 0) {
                mod = add;

                confirm = true;
            }
            if (mod == 0 && piD > 0 && noT > 0) {
                mod = (piD / noT);

                confirm = true;
            }
            if (mod == 0 && ouD > 0 && noT > 0) {
                mod = (ouD / (noT + 2.0d));

                confirm = true;
            }
            if (mod == 0 && diP > 0) {
                mod = (diP / 3.14d);

                confirm = true;
            }
            if (mod == 0 && whD > 0) {
                mod = (whD / (2.0d + stF));

                confirm = true;
            }
            if (add == 0 && mod > 0) {
                add = mod;

                confirm = true;
            }
            if (ouD == 0 && piD > 0 && mod > 0) {
                ouD = (piD + (2.0d * mod));

                confirm = true;
            }
            if (ouD == 0 && noT > 0 && mod > 0) {
                ouD = (mod * (noT + 2.0d));

                confirm = true;
            }
            if (ouD == 0 && roD > 0 && whD > 0) {
                ouD = (roD + (2.0d * whD));

                confirm = true;
            }
            if (roD == 0 && piD > 0 && mod > 0 && clr > 0) {
                roD = (piD - (2.0d * (mod + clr)));

                confirm = true;
            }
            if (roD == 0 && ouD > 0 && mod > 0 && clr > 0) {
                roD = (ouD - (2.0d * (2.0d * (mod + clr))));

                confirm = true;
            }
            if (whD == 0 && clr > 0 && mod > 0) {
                whD = ((2.0d * mod) + clr);

                confirm = true;
            }
            if (ded == 0 && clr > 0 && mod > 0) {
                ded = (mod + clr);

                confirm = true;
            }
            if (diP == 0 && ciP > 0) {
                diP = (3.14d / ciP);

                confirm = true;
            }
            if (diP == 0 && ouD > 0 && noT > 0) {
                diP = ((noT + 2) / ouD);

                confirm = true;
            }

            if (toT == 0 && mod > 0) {
                toT = 1.5708 / (1 / mod);

                confirm = true;
            }

            if (ciP == 0 && diP > 0) {
                ciP = 3.14d / diP;

                confirm = true;
            }
            if (piD > 0 && pAng > 0) {
                doB = piD * Math.cos(pAng);
            }

        }


        if (confirm_solvable == 1) {
            module.getEditText().setText(String.valueOf(mod));
            numOfTeeth.getEditText().setText(String.valueOf(noT));
            diametralPitch.getEditText().setText(String.valueOf(diP));
            circularPitch.getEditText().setText(String.valueOf(ciP));
            dedendum.getEditText().setText(String.valueOf(ded));
            outsideDiameter.getEditText().setText(String.valueOf(ouD));
            pitchDiameter.getEditText().setText(String.valueOf(piD));
            rootDiameter.getEditText().setText(String.valueOf(roD));
            diameterOfBase.getEditText().setText(String.valueOf(doB));
            circularTooth.getEditText().setText(String.valueOf(toT));
            wholeDepth.getEditText().setText(String.valueOf(whD));
            clearance.getEditText().setText(String.valueOf(clr));
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
