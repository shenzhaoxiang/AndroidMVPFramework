package com.ctsig.android.injector.component;

import android.app.Activity;
import android.content.Context;

import com.ctsig.android.injector.module.ActivityModule;
import com.ctsig.android.injector.scope.PerActivity;

import dagger.Component;

/**
 * @version V1.0
 * @des @Component: Components从根本上来说就是一个注入器，也可以说是@Inject和@Module的桥梁，它的主要作用就是连接这两个部分。
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 19:16
 */
@PerActivity
@Component(
        dependencies = {//AppComponent.class,
                AppComponent.class},
        modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();

    Context context();
}
