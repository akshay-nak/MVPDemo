package com.akshay.demo.demoapp.splash;

import com.akshay.demo.demoapp.data.PreferenceManager;
import com.akshay.demo.demoapp.base.BasePresenter;
import android.os.Handler;


/**
 * Created by akshay on 27/1/18.
 */

public class SplashPresenter<V extends ISplashView> extends BasePresenter<V> implements ISplashPresenter<V> {
        public SplashPresenter(PreferenceManager preferenceManager) {
        super(preferenceManager);
    }

    @Override
    public void decideNextActivity() {

        Handler handler =new Handler();
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
