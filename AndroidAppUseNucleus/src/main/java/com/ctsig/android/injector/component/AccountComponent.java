package com.ctsig.android.injector.component;

import com.ctsig.android.injector.module.ActivityModule;
import com.ctsig.android.injector.module.AccountModule;
import com.ctsig.android.injector.scope.PerActivity;
import com.ctsig.android.ui.module.account.presenter.LoginPresenter;

import dagger.Component;

/**
 * @version V1.0
 * @des @Component: Components从根本上来说就是一个注入器，也可以说是@Inject和@Module的桥梁，它的主要作用就是连接这两个部分。
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-21 10:20
 */
@PerActivity
@Component(
        dependencies = AppComponent.class,
        modules = {AccountModule.class, ActivityModule.class})
public interface AccountComponent extends ActivityComponent{

    void inject(LoginPresenter loginPresenter) ;

}
