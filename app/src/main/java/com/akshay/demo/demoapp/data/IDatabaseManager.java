package com.akshay.demo.demoapp.data;

import com.akshay.demo.demoapp.login.model.UserInfo;

/**
 * Created by akshay on 23/3/18.
 */

public interface IDatabaseManager {

    void saveUserProfile(UserInfo userInfo);
}
