package com.akshay.demo.demoapp.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.akshay.demo.demoapp.R;

public class BaseActivity extends AppCompatActivity implements IBaseView {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    public void showProgress() {

        progressDialog = ProgressDialog.show(this, "Loading...", "Please wait....");

    }

    @Override
    public void hideProgress() {
        if(progressDialog!=null && progressDialog.isShowing()){
            progressDialog.cancel();
        }
    }
}
