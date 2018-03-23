package com.akshay.demo.demoapp.login;

import com.akshay.demo.demoapp.models.DataManager;
import com.akshay.demo.demoapp.base.BasePresenter;

/**
 * Created by akshay on 31/1/18.
 */

public class LoginPresenter<V extends ILoginView> extends BasePresenter<V> implements ILoginPresenter<V> {
    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void startLogin(String emailId) {
        getDataManager().saveEmailId(emailId);
        getDataManager().setLoggedIn();
        getBaseView().openMainActivity();
    }
}
