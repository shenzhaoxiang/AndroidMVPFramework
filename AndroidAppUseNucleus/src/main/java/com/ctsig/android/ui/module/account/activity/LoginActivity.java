package com.ctsig.android.ui.module.account.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.ctsig.android.R;
import com.ctsig.android.utils.InputMethodUtils;
import com.ctsig.android.data.model.entity.User;
import com.ctsig.android.data.pref.AccountPref;
import com.ctsig.android.injector.HasComponent;
import com.ctsig.android.injector.component.AccountComponent;
import com.ctsig.android.injector.component.DaggerAccountComponent;
import com.ctsig.android.injector.module.AccountModule;
import com.ctsig.android.ui.base.BaseLoadingActivity;
import com.ctsig.android.ui.module.account.presenter.LoginPresenter;
import com.ctsig.android.ui.module.account.view.LoginView;
import com.ctsig.android.ui.module.demo.activity.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;
import nucleus.factory.PresenterFactory;
import nucleus.factory.RequiresPresenter;

@RequiresPresenter(LoginPresenter.class)
public class LoginActivity extends BaseLoadingActivity<LoginPresenter> implements LoginView ,HasComponent<AccountComponent> {


    @BindView(R.id.login_progress)
    ProgressBar loginProgress;
    @BindView(R.id.login_username)
    AutoCompleteTextView loginUsername;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_btn)
    Button loginBtn;

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void getBundleExtras(Bundle parms) {

    }

    @Override
    public void initViewsAndEvents(View view) {

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void injectorPresenter() {
        super.injectorPresenter();
        final PresenterFactory<LoginPresenter> superFactory = super.getPresenterFactory();
        setPresenterFactory(new PresenterFactory<LoginPresenter>() {
            @Override
            public LoginPresenter createPresenter() {
                LoginPresenter presenter = superFactory.createPresenter();
                getComponent().inject(presenter);
                return presenter;
            }
        });
    }

    @OnClick(R.id.login_btn)
    public void onClick() {

        String username = loginUsername.getText().toString();
        String password = loginPassword.getText().toString();

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            InputMethodUtils.hideSoftInput(this);
            getPresenter().login(username, password);
        }
    }


    @Override
    public String getLoadingMessage() {
        return null;
    }

    public static void launch(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @Override
    public AccountComponent getComponent() {
        return DaggerAccountComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .accountModule(new AccountModule())
                .build();
    }


    @Override
    public void loginSuccess(User user) {
        Snackbar.make(loginBtn, "Login Success", Snackbar.LENGTH_LONG).show();
        AccountPref.saveLogonUser(this, user);
        readyGoThenKill(MainActivity.class);
    }
}

