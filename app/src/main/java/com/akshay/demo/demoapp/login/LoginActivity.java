package com.akshay.demo.demoapp.login;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.akshay.demo.demoapp.R;
import com.akshay.demo.demoapp.common.CommonUtils;
import com.akshay.demo.demoapp.common.AppApplication;
import com.akshay.demo.demoapp.data.DataManager;
import com.akshay.demo.demoapp.base.BaseActivity;
import com.akshay.demo.demoapp.home.MainActivity;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements ILoginView {

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);

        DataManager dataManager = ((AppApplication) getApplication()).getDataManager();
        loginPresenter = new LoginPresenter(dataManager);

        loginPresenter.onAttach(this);

       Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonClick();
            }
        });
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginButtonClick() {
        String emailId = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        if (!CommonUtils.isEmailValid(emailId)) {
            Toast.makeText(this, "Enter correct Email", Toast.LENGTH_LONG).show();
            return;
        }

        if (password == null || password.isEmpty()) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_LONG).show();
            return;
        }

        loginPresenter.startLogin(emailId);
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }
}

