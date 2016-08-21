package com.ctsig.android.app;

import android.app.Application;
import android.content.Context;

import com.ctsig.android.BuildConfig;
import com.ctsig.android.di.component.ApiComponent;
import com.ctsig.android.di.component.AppComponent;
import com.ctsig.android.di.component.DaggerAppComponent;
import com.ctsig.android.di.module.AppModule;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;

/**
 * @version V1.0
 * @des Application
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 18:27
 */
public class App extends Application {
    private static RefWatcher refWatcher;

    private AppComponent appComponent;

    private ApiComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init(){
        // 内存泄漏检测工具
        refWatcher = LeakCanary.install(this);
        // 调试模式
        ButterKnife.setDebug(BuildConfig.DEBUG);
        // 浏览器调试
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
        initializeInjector();
        initializeInjectorApi();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public static RefWatcher getRefWatcher() {
        return refWatcher;
    }

    private void initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    private void initializeInjectorApi() {
//        apiComponent = DaggerApiComponent.builder()
//                .apiModule(new ApiModule())
//                .appComponent(getAppComponent())
//                .appModule(new AppModule(this))
//                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public ApiComponent getApiComponent() {
        return apiComponent;
    }
}
