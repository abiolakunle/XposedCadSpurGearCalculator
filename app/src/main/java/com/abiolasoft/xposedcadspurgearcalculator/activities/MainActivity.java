package com.abiolasoft.xposedcadspurgearcalculator.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.abiolasoft.xposedcadspurgearcalculator.R;
import com.abiolasoft.xposedcadspurgearcalculator.adapters.SectionsPagerAdapter;

public class MainActivity extends BaseActivity {

    //Views
    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;


    //Adapters
    private SectionsPagerAdapter mSectionPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //toolbar setup
        mToolbar = (Toolbar) findViewById(R.id.main_app_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("XposedCad Spur Gear Calculator");

        //adapter
        mSectionPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        //ViewPager setup
        mViewPager = findViewById(R.id.main_viewPager);
        mViewPager.setAdapter(mSectionPagerAdapter);

        //TabLayout setup
        mTabLayout = findViewById(R.id.main_tab);
        mTabLayout.setupWithViewPager(mViewPager);



    }


}
