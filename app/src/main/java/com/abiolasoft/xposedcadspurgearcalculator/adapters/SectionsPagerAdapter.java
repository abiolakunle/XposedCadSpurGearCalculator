package com.abiolasoft.xposedcadspurgearcalculator.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.abiolasoft.xposedcadspurgearcalculator.fragments.GearCalculator;
import com.abiolasoft.xposedcadspurgearcalculator.fragments.GearExamples;
import com.abiolasoft.xposedcadspurgearcalculator.fragments.GearFormulae;
import com.abiolasoft.xposedcadspurgearcalculator.fragments.GearTerms;

public class SectionsPagerAdapter extends FragmentPagerAdapter {


    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new GearCalculator();
                break;
            case 1:
                fragment = new GearFormulae();
                break;
            case 2:
                fragment = new GearTerms();
                break;
            case 3:
                fragment = new GearExamples();
                break;
            default:
                return null;
        }

        return fragment;

    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Calculator";
            case 1:
                return "Formulae";
            case 2:
                return "Terms";
            case 3:
                return "Example";
            default:
                return null;
        }

    }
}
