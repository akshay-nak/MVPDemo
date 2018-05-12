package com.akshay.demo.demoapp.login;

import com.akshay.demo.demoapp.base.BasePresenter;
import com.akshay.demo.demoapp.data.IDatabaseManager;
import com.akshay.demo.demoapp.data.PreferenceManager;
import com.akshay.demo.demoapp.login.model.UserInfo;

/**
 * Created by akshay on 31/1/18.
 */

public class LoginPresenter<V extends ILoginView> extends BasePresenter<V> implements ILoginPresenter<V> {
    public LoginPresenter(PreferenceManager preferenceManager, IDatabaseManager databaseManager) {
        super(preferenceManager, databaseManager);
    }

    @Override
    public void startLogin(String emailId) {
        getPreferenceManager().saveEmailId(emailId);
        getPreferenceManager().setLoggedIn();
        getDatabaseManager().saveUserProfile(new UserInfo(emailId));
        getBaseView().openMainActivity();
    }
}
