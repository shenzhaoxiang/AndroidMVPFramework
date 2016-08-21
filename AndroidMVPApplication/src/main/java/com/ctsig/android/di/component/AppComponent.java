package com.ctsig.android.di.component;

import android.app.Application;
import android.content.Context;

import com.ctsig.android.app.App;
import com.ctsig.android.di.module.AppModule;
import com.ctsig.android.di.qualifier.ForApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-21 10:20
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(App app);

    @ForApplication
    Context context();

    @ForApplication
    Application application();
}
