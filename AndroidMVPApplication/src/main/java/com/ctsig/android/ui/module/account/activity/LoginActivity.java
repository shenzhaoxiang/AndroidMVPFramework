package com.ctsig.android.ui.module.account.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.ctsig.android.R;
import com.ctsig.android.app.App;
import com.ctsig.android.base.BaseActivity;
import com.ctsig.android.di.HasComponent;
import com.ctsig.android.di.component.AccountComponent;
import com.ctsig.android.di.component.DaggerAccountComponent;
import com.ctsig.android.di.module.AccountModule;
import com.ctsig.android.di.module.ActivityModule;
import com.ctsig.android.ui.module.account.view.LoginView;


public class LoginActivity extends BaseActivity implements LoginView, HasComponent<AccountComponent> {


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
    public void injectorPresenter(){

    }

    @Override
    public AccountComponent getComponent() {
        return DaggerAccountComponent.builder()
                .applicationComponent(App.get(this).getComponent())
                .activityModule(new ActivityModule(this))
                .accountModule(new AccountModule())
                .build();
    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void error(Throwable e) {

    }
}

