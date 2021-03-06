package com.akshay.demo.demoapp.base;

import com.akshay.demo.demoapp.data.IDatabaseManager;
import com.akshay.demo.demoapp.data.PreferenceManager;

/**
 * Created by akshay on 27/1/18.
 */

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    PreferenceManager preferenceManager;
    IDatabaseManager databaseManager;
    private V mMVIPView;

    public BasePresenter(PreferenceManager preferenceManager, IDatabaseManager databaseManager) {
        this.preferenceManager = preferenceManager;
        this.databaseManager = databaseManager;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mMVIPView = mvpView;
    }

    public V getBaseView() {
        return mMVIPView;
    }

    public PreferenceManager getPreferenceManager() {
        return preferenceManager;
    }

    public IDatabaseManager getDatabaseManager() {
        return databaseManager;
    }
}
