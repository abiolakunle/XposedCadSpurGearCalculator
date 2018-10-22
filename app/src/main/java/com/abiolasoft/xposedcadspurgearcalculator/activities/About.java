package com.abiolasoft.xposedcadspurgearcalculator.activities;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.abiolasoft.xposedcadspurgearcalculator.R;

public class About extends BaseActivity {

    private Toolbar aboutToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        aboutToolbar = findViewById(R.id.about_app_bar);
        setSupportActionBar(aboutToolbar);
        getSupportActionBar().setTitle("XposedCad Spur Gear Calculator");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


}
