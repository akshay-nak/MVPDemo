package com.akshay.demo.demoapp.base;

/**
 * Created by akshay on 27/1/18.
 */

public interface IBasePresenter<V extends IBaseView>{

    void onAttach(V mvpView);
}
