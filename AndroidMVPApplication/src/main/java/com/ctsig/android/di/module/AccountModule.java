package com.ctsig.android.di.module;

import com.ctsig.android.data.api.AccountApi;
import com.ctsig.android.data.datasource.AccountDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @version V1.0
 * @des @Module: Modules类里面的方法专门提供依赖
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 19:33
 */
@Module
public class AccountModule {
    @Provides
    @Singleton
    AccountApi provideAccountApi(AccountDataSource dataSource) {
        return dataSource;
    }

}
