package com.akshay.demo.demoapp.login;

import com.akshay.demo.demoapp.data.PreferenceManager;
import com.akshay.demo.demoapp.base.BasePresenter;

/**
 * Created by akshay on 31/1/18.
 */

public class LoginPresenter<V extends ILoginView> extends BasePresenter<V> implements ILoginPresenter<V> {
    public LoginPresenter(PreferenceManager preferenceManager) {
        super(preferenceManager);
    }

    @Override
    public void startLogin(String emailId) {
        getPreferenceManager().saveEmailId(emailId);
        getPreferenceManager().setLoggedIn();
        getBaseView().openMainActivity();
    }
}
