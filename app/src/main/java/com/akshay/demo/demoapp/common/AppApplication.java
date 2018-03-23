package com.akshay.demo.demoapp.common;

import android.app.Application;

import com.akshay.demo.demoapp.data.DatabaseManager;
import com.akshay.demo.demoapp.data.IDatabaseManager;
import com.akshay.demo.demoapp.data.PreferenceManager;
import com.akshay.demo.demoapp.data.SharedPreferenceHelper;

/**
 * Created by akshay on 27/1/18.
 */

public class AppApplication extends Application {
    PreferenceManager mPreferenceManager;
    IDatabaseManager databaseManager;

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferenceHelper sharedPrefsHelper = new SharedPreferenceHelper(getApplicationContext());
        mPreferenceManager = new PreferenceManager(sharedPrefsHelper);

        databaseManager = new DatabaseManager(getApplicationContext());
    }

    public PreferenceManager getPreferenceManager() {
        return mPreferenceManager;
    }

    public IDatabaseManager getDatabaseManager() {
        return databaseManager;
    }
}
