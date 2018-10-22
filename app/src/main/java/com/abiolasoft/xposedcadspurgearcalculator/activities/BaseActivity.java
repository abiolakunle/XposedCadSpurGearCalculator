package com.abiolasoft.xposedcadspurgearcalculator.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.abiolasoft.xposedcadspurgearcalculator.R;

public class BaseActivity extends AppCompatActivity {


    //Options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);



        switch (item.getItemId()){
            case R.id.menu_share:
                int applicationNameId = this.getApplicationInfo().labelRes;
                final String appPackageName = this.getPackageName();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, this.getString(applicationNameId));
                String text = "Hi, i use XposedCad Gpur Gear Calculator to calculate gear parameters automatically, Install and try it out now: \n\n";
                String link = "https://play.google.com/store/apps/details?id=" + appPackageName;
                i.putExtra(Intent.EXTRA_TEXT, text + " " + link);
                startActivity(Intent.createChooser(i, "Share link:"));
                break;

            case R.id.menu_about:
                Intent menuIntent = new Intent(this, About.class);
                startActivity(menuIntent);
                break;

            case android.R.id.home:
                finish();
                break;

            default:
        }

        return true;
    }


}
