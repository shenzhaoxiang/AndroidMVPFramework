package com.ctsig.android.di.module;

import com.ctsig.android.data.api.AccountApi;
import com.ctsig.android.data.datasource.AccountDataSource;

import dagger.Module;
import dagger.Provides;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-21 10:21
 */
@Module
public class ApiModule {

    @Provides
    AccountApi provideAccountApi(AccountDataSource dataSource){
        return dataSource;
    }
}
