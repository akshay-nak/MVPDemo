package com.akshay.demo.demoapp.home;

import com.akshay.demo.demoapp.data.IDatabaseManager;
import com.akshay.demo.demoapp.data.PreferenceManager;
import com.akshay.demo.demoapp.base.BasePresenter;

/**
 * Created by akshay on 31/1/18.
 */

public class MainPresenter<V extends IMainView> extends BasePresenter<V> implements IMainPresenter<V> {
    public MainPresenter(PreferenceManager preferenceManager, IDatabaseManager databaseManager) {
        super(preferenceManager,databaseManager);
    }

    @Override
    public String getEmailId() {
        return getPreferenceManager().getEmailId();
    }

    @Override
    public void setUserLoggedOut() {
        getPreferenceManager().clear();
        getBaseView().openSplashActivity();
    }
}
