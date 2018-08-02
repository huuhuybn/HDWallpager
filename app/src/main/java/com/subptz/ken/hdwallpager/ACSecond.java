package com.subptz.ken.hdwallpager;

import android.support.v7.app.ActionBar;
import android.os.Bundle;

import com.subptz.ken.hdwallpager.common.ACBase;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class ACSecond extends ACBase {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_acsecond);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }




    }

}
