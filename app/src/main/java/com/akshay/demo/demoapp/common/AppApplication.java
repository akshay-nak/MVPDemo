package com.akshay.demo.demoapp.common;

import android.app.Application;

import com.akshay.demo.demoapp.data.DataManager;
import com.akshay.demo.demoapp.data.SharedPreferenceHelper;

/**
 * Created by akshay on 27/1/18.
 */

public class AppApplication extends Application {
    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferenceHelper sharedPrefsHelper = new SharedPreferenceHelper(getApplicationContext());
        dataManager = new DataManager(sharedPrefsHelper);

    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
