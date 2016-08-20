package com.ctsig.android.data.datasource;

import com.ctsig.android.data.api.AccountApi;
import com.ctsig.android.data.model.entity.User;

import rx.Observable;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 19:39
 */
public class AccountDataSource implements AccountApi {
    @Override
    public Observable<User> login(String username, String password) {
        return null;
    }
}
