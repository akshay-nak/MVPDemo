package com.akshay.demo.demoapp.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.akshay.demo.demoapp.common.AppApplication;
import com.akshay.demo.demoapp.R;
import com.akshay.demo.demoapp.data.DataManager;
import com.akshay.demo.demoapp.base.BaseActivity;
import com.akshay.demo.demoapp.login.LoginActivity;
import com.akshay.demo.demoapp.home.MainActivity;

public class SplashActivity extends BaseActivity implements ISplashView {

    SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        DataManager dataManager = ((AppApplication) getApplication()).getDataManager();

        mSplashPresenter = new SplashPresenter(dataManager);

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

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

}
