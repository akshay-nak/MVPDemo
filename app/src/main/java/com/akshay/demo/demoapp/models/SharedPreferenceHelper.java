package com.akshay.demo.demoapp.models;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by akshay on 27/1/18.
 */

public class SharedPreferenceHelper {

    public static final String PREF_NAME = "my_preference";

    public static final String EMAIL_ID = "email_id";

    private SharedPreferences sharedPreferences;

    public SharedPreferenceHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void clear() {
        if (sharedPreferences != null)
            sharedPreferences.edit().clear().apply();
    }

    public void put(String key,String value)
    {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public void putEmailId(String value)
    {
        sharedPreferences.edit().putString(EMAIL_ID, value).apply();
    }

    public String getEmailId()
    {
        String emailId=sharedPreferences.getString(EMAIL_ID, null);
        return emailId;
    }

    public String getString(String key)
    {
        String value=sharedPreferences.getString(key, null);


        return value;
    }

    public boolean getLoggedInMode() {
        return sharedPreferences.getBoolean("IS_LOGGED_IN", false);
    }

    public void setLoggedInMode(boolean loggedIn) {
        sharedPreferences.edit().putBoolean("IS_LOGGED_IN", loggedIn).apply();
    }
}
