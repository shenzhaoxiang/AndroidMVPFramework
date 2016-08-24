package com.ctsig.android.injector.module;

import android.app.Application;
import android.content.Context;

import com.ctsig.android.app.App;
import com.ctsig.android.injector.qualifier.ForApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @version V1.0
 * @des @Module: Modules类里面的方法专门提供依赖
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-21 10:21
 */
@Module
public class AppModule {
    private final App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideAppContext() {
        return app;
    }

    @ForApplication
    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }
}
