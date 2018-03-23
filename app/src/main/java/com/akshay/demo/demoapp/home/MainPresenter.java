package com.akshay.demo.demoapp.home;

import com.akshay.demo.demoapp.models.DataManager;
import com.akshay.demo.demoapp.base.BasePresenter;

/**
 * Created by akshay on 31/1/18.
 */

public class MainPresenter<V extends IMainView> extends BasePresenter<V> implements IMainPresenter<V> {
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public String getEmailId() {
        return getDataManager().getEmailId();
    }

    @Override
    public void setUserLoggedOut() {
        getDataManager().clear();
        getBaseView().openSplashActivity();
    }
}
