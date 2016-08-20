package com.ctsig.android.data.api;

import com.ctsig.android.data.model.entity.User;

import rx.Observable;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 19:36
 */
public interface AccountApi {

    Observable<User> login(String username, String password);
}
