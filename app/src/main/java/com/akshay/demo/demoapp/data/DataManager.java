package com.akshay.demo.demoapp.data;

/**
 * Created by akshay on 27/1/18.
 */

public class DataManager {
    SharedPreferenceHelper mSharedPrefsHelper;

    public DataManager(SharedPreferenceHelper sharedPrefsHelper) {
        mSharedPrefsHelper = sharedPrefsHelper;
    }

    public void clear() {
        mSharedPrefsHelper.clear();
    }

    public void saveEmailId(String email) {
        mSharedPrefsHelper.putEmailId(email);
    }

    public String getEmailId() {
        return mSharedPrefsHelper.getEmailId();
    }

    public void saveData(String key, String value) {
        mSharedPrefsHelper.put(key, value);
    }

    public String getString(String key) {
        return mSharedPrefsHelper.getString(key);
    }

    public void setLoggedIn() {
        mSharedPrefsHelper.setLoggedInMode(true);
    }

    public Boolean getLoggedInMode() {
        return mSharedPrefsHelper.getLoggedInMode();
    }
}
