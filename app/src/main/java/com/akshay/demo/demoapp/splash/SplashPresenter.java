package com.akshay.demo.demoapp.splash;

import com.akshay.demo.demoapp.models.DataManager;
import com.akshay.demo.demoapp.base.BasePresenter;
import android.os.Handler;


/**
 * Created by akshay on 27/1/18.
 */

public class SplashPresenter<V extends ISplashView> extends BasePresenter<V> implements ISplashPresenter<V> {
        public SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void decideNextActivity() {

        Handler handler =new Handler();
        getBaseView().showProgress();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (getDataManager().getLoggedInMode()) {
                    getBaseView().openHomeActivity();
                } else {
                    getBaseView().openLoginActivity();
                }

                getBaseView().hideProgress();
            }
        }, 3000);

    }
}
