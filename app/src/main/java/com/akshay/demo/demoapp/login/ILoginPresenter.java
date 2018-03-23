package com.akshay.demo.demoapp.login;

import com.akshay.demo.demoapp.base.IBasePresenter;

/**
 * Created by akshay on 31/1/18.
 */

public interface ILoginPresenter<V extends ILoginView> extends IBasePresenter<V> {

    void startLogin(String emailId);
}
