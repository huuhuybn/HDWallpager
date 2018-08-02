package com.subptz.ken.hdwallpager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.subptz.ken.hdwallpager.common.ACBase;
import com.subptz.ken.hdwallpager.common.Constants;

public class ACSplash extends ACBase implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int SPLASH_TIME_OUT = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ACSplash.this, ACMain.class);
                intent.putExtra(DATA,"ABC");
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);




    }
}
