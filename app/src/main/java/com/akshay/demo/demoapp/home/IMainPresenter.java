package com.akshay.demo.demoapp.home;

import com.akshay.demo.demoapp.base.IBasePresenter;
import com.akshay.demo.demoapp.login.model.UserInfo;

/**
 * Created by akshay on 31/1/18.
 */

public interface IMainPresenter<V extends IMainView> extends IBasePresenter<V> {

    String getEmailId();

    UserInfo getUser();

    void setUserLoggedOut();
}
