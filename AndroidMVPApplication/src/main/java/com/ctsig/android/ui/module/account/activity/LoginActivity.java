package com.ctsig.android.ui.module.account.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.ctsig.android.R;
import com.ctsig.android.common.utils.InputMethodUtils;
import com.ctsig.android.di.HasComponent;
import com.ctsig.android.di.component.AccountComponent;
import com.ctsig.android.di.component.DaggerAccountComponent;
import com.ctsig.android.di.module.AccountModule;
import com.ctsig.android.ui.base.BaseLoadingActivity;
import com.ctsig.android.ui.module.account.presenter.LoginPresenter;
import com.ctsig.android.ui.module.account.view.LoginView;

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
    public void loginSuccess() {

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
}

