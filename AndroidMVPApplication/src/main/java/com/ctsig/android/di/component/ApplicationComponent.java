package com.ctsig.android.di.component;

import android.content.Context;

import com.ctsig.android.di.module.ApplicationModule;
import com.ctsig.android.di.qualifier.ForApplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @version V1.0
 * @des: @Component: Components从根本上来说就是一个注入器，也可以说是@Inject和@Module的桥梁，它的主要作用就是连接这两个部分。
 * @author: shen
 * @email: shenzhaoxiang@gmail.com
 * @date: 2016-05-19 17:04
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ForApplication
    Context context();

    //Application application();
}
