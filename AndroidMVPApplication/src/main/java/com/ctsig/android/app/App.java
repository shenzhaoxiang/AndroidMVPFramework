package com.ctsig.android.app;

import android.app.Application;
import android.content.Context;

import com.ctsig.android.BuildConfig;
import com.ctsig.android.di.component.ApplicationComponent;
import com.ctsig.android.di.component.DaggerApplicationComponent;
import com.ctsig.android.di.module.ApplicationModule;
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
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    ApplicationComponent appComponent;
    public ApplicationComponent getComponent() {
        if (appComponent == null) {
            appComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return appComponent;
    }
    public static RefWatcher getRefWatcher() {
        return refWatcher;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent appComponent) {
        this.appComponent = appComponent;
    }
}
