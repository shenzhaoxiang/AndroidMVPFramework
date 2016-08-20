package com.ctsig.android.di.component;

import com.ctsig.android.di.module.AccountModule;
import com.ctsig.android.di.module.ActivityModule;
import com.ctsig.android.di.scope.PerActivity;
import com.ctsig.android.ui.module.account.activity.LoginActivity;

import dagger.Component;

/**
 * @version V1.0
 * @des @Component: Components从根本上来说就是一个注入器，也可以说是@Inject和@Module的桥梁，它的主要作用就是连接这两个部分。
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 19:33
 */
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, AccountModule.class})
public interface AccountComponent extends ActivityComponent  {

    void inject(LoginActivity loginActivity);
}
