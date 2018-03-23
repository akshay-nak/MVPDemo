package com.akshay.demo.demoapp.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.akshay.demo.demoapp.R;
import com.akshay.demo.demoapp.base.BaseActivity;
import com.akshay.demo.demoapp.common.AppApplication;
import com.akshay.demo.demoapp.data.IDatabaseManager;
import com.akshay.demo.demoapp.data.PreferenceManager;
import com.akshay.demo.demoapp.home.MainActivity;
import com.akshay.demo.demoapp.login.LoginActivity;

public class SplashActivity extends BaseActivity implements ISplashView {

    SplashPresenter mSplashPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        PreferenceManager preferenceManager = ((AppApplication) getApplication()).getPreferenceManager();
        IDatabaseManager databaseManager = ((AppApplication) getApplication()).getDatabaseManager();

        mSplashPresenter = new SplashPresenter(preferenceManager, databaseManager);

        mSplashPresenter.onAttach(this);

        mSplashPresenter.decideNextActivity();
    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openHomeActivity() {
        Intent intent = MainActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }

}
