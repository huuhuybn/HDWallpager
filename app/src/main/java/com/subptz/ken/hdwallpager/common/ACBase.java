package com.subptz.ken.hdwallpager.common;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class ACBase extends AppCompatActivity implements Constants {

    private ProgressDialog progressDialog;

    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressDialog = new ProgressDialog(this);
        sharedPreferences = getSharedPreferences(DATA, Context.MODE_PRIVATE);
    }


    public void showProgressBar() {

        if (progressDialog != null) progressDialog.show();

    }


    public void hideProgressBar() {
        if (progressDialog != null) progressDialog.hide();

    }


    public void setUser(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER, name);
        editor.apply();
    }


    public String getUser() {
        return sharedPreferences.getString(USER, null);
    }

}
