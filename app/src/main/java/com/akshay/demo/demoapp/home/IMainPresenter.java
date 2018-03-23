package com.akshay.demo.demoapp.home;

import com.akshay.demo.demoapp.base.IBasePresenter;

/**
 * Created by akshay on 31/1/18.
 */

public interface IMainPresenter<V extends IMainView> extends IBasePresenter<V> {

    String getEmailId();

    void setUserLoggedOut();
}
