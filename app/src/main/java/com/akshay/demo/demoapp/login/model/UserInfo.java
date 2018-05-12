package com.akshay.demo.demoapp.login.model;

/**
 * Created by akshay on 23/3/18.
 */

public class UserInfo {
    int id;
    String full_name;

    public UserInfo(String full_name) {
        this.full_name = full_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }
}
