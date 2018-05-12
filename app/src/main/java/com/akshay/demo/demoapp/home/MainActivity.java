package com.akshay.demo.demoapp.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akshay.demo.demoapp.R;
import com.akshay.demo.demoapp.base.BaseActivity;
import com.akshay.demo.demoapp.common.AppApplication;
import com.akshay.demo.demoapp.data.IDatabaseManager;
import com.akshay.demo.demoapp.data.PreferenceManager;
import com.akshay.demo.demoapp.login.model.UserInfo;
import com.akshay.demo.demoapp.splash.SplashActivity;

public class MainActivity extends BaseActivity implements IMainView {

    static final String TAG = MainActivity.class.getName();
    TextView textViewShow;
    TextView textViewUser;
    Button buttonLogout;
    MainPresenter mainPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceManager preferenceManager = ((AppApplication) getApplication()).getPreferenceManager();
        IDatabaseManager databaseManager = ((AppApplication) getApplication()).getDatabaseManager();
        mainPresenter = new MainPresenter(preferenceManager, databaseManager);
        mainPresenter.onAttach(this);

        textViewShow = (TextView) findViewById(R.id.textViewShow);
        textViewUser = (TextView) findViewById(R.id.textViewUser);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        textViewShow.setText(mainPresenter.getEmailId());

        UserInfo user = mainPresenter.getUser();
        textViewUser.setText(user != null ? user.getFull_name() : "Not found");

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.setUserLoggedOut();
            }
        });

    }

    @Override
    public void openSplashActivity() {
        Intent intent = SplashActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }

}
