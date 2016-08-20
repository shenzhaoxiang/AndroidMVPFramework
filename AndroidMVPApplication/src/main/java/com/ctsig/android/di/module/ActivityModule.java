package com.ctsig.android.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.ctsig.android.di.qualifier.ForActivity;
import com.ctsig.android.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @version V1.0
 * @des @Module: Modules类里面的方法专门提供依赖
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-07-08 16:52
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    public ActivityModule(Fragment fragment) {
        activity = fragment.getActivity();
    }

    @Provides
    @PerActivity
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @ForActivity
    Context providesContext() {
        return activity;
    }
}
