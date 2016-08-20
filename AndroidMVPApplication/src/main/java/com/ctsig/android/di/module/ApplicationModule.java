package com.ctsig.android.di.module;

import android.app.Application;
import android.content.Context;

import com.ctsig.android.app.App;
import com.ctsig.android.di.qualifier.ForApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @version V1.0
 * @des: @Module: Modules类里面的方法专门提供依赖
 * @author: shen
 * @email: shenzhaoxiang@gmail.com
 * @date: 2016-05-19 16:58
 */
@Module
public class ApplicationModule {
    private final App app;

    public ApplicationModule(App app) {
        this.app = app;
    }

    @ForApplication
    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }

    @ForApplication
    @Provides
    @Singleton
    public Context provideAppContext() {
        return app.getApplicationContext();
    }

}
