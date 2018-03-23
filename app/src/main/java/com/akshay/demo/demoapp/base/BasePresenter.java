package com.akshay.demo.demoapp.base;

import com.akshay.demo.demoapp.models.DataManager;

/**
 * Created by akshay on 27/1/18.
 */

public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    DataManager dataManager;
    private V mMVIPView;

    public BasePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mMVIPView = mvpView;
    }

    public V getBaseView() {
        return mMVIPView;
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
