package com.akshay.demo.demoapp.splash;

import android.os.Handler;

import com.akshay.demo.demoapp.base.BasePresenter;
import com.akshay.demo.demoapp.data.IDatabaseManager;
import com.akshay.demo.demoapp.data.PreferenceManager;


/**
 * Created by akshay on 27/1/18.
 */

public class SplashPresenter<V extends ISplashView> extends BasePresenter<V> implements ISplashPresenter<V> {
    public SplashPresenter(PreferenceManager preferenceManager, IDatabaseManager databaseManager) {
        super(preferenceManager, databaseManager);
    }

    @Override
    public void decideNextActivity() {

        Handler handler = new Handler();
        getBaseView().showProgress();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (getPreferenceManager().getLoggedInMode()) {
                    getBaseView().openHomeActivity();
                } else {
                    getBaseView().openLoginActivity();
                }

                getBaseView().hideProgress();
            }
        }, 3000);

    }
}
