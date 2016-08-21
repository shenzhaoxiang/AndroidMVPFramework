package com.ctsig.android.di.component;

import com.ctsig.android.di.module.ActivityModule;
import com.ctsig.android.di.module.ApiModule;
import com.ctsig.android.di.scope.PerActivity;
import com.ctsig.android.ui.module.account.presenter.LoginPresenter;

import dagger.Component;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-21 10:20
 */
@PerActivity
@Component(
        dependencies = AppComponent.class,
        modules = {ApiModule.class, ActivityModule.class})
public interface ApiComponent extends ActivityComponent{

    void inject(LoginPresenter loginPresenter) ;

}
