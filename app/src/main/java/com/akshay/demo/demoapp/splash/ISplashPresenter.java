package com.akshay.demo.demoapp.splash;

import com.akshay.demo.demoapp.base.IBasePresenter;

/**
 * Created by akshay on 27/1/18.
 */

public interface ISplashPresenter<V extends ISplashView> extends IBasePresenter<V> {

    void decideNextActivity();
}
