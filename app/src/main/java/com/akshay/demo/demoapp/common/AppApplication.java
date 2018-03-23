package com.akshay.demo.demoapp.common;

import android.app.Application;

import com.akshay.demo.demoapp.data.PreferenceManager;
import com.akshay.demo.demoapp.data.SharedPreferenceHelper;

/**
 * Created by akshay on 27/1/18.
 */

public class AppApplication extends Application {
    PreferenceManager preferenceManager;

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferenceHelper sharedPrefsHelper = new SharedPreferenceHelper(getApplicationContext());
        preferenceManager = new PreferenceManager(sharedPrefsHelper);
    }

    public PreferenceManager getPreferenceManager() {
        return preferenceManager;
    }
}
