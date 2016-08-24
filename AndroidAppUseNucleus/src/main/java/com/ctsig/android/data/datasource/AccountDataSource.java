package com.ctsig.android.data.datasource;

import android.content.Context;

import com.ctsig.android.common.config.GithubConfig;
import com.ctsig.android.utils.LogUtils;
import com.ctsig.android.data.api.AccountApi;
import com.ctsig.android.data.model.entity.User;
import com.ctsig.android.data.net.client.GithubAuthRetrofit;
import com.ctsig.android.data.net.request.CreateAuthorization;
import com.ctsig.android.data.net.response.AuthorizationResp;
import com.ctsig.android.data.net.service.AccountService;
import com.ctsig.android.data.pref.AccountPref;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 19:39
 */
public class AccountDataSource implements AccountApi {

    /**
     * 1、构造方法注入：在类的构造方法前面注释@Inject
     * 2、成员变量注入：在类的成员变量（非私有）前面注释@Inject
     * 3、函数方法注入：在函数前面注释@Inject
     */
    @Inject
    GithubAuthRetrofit mRetrofit;

    @Inject
    Context mContext;

    @Inject
    public AccountDataSource() {
        LogUtils.d("AccountDataSource()");
    }

    @Override
    public Observable<User> login(String username, String password) {
        mRetrofit.setAuthInfo(username, password);
        final AccountService accountService = mRetrofit.get().create(AccountService.class);

        CreateAuthorization createAuthorization = new CreateAuthorization();
        createAuthorization.note = GithubConfig.NOTE;
        createAuthorization.client_id = GithubConfig.CLIENT_ID;
        createAuthorization.client_secret = GithubConfig.CLIENT_SECRET;
        createAuthorization.scopes = GithubConfig.SCOPES;

        return accountService.createAuthorization(createAuthorization)
                .flatMap(new Func1<AuthorizationResp, Observable<User>>() {
                    @Override
                    public Observable<User> call(AuthorizationResp authorizationResp) {

                        String token = authorizationResp.getToken();

                        // save token
                        AccountPref.saveLoginToken(mContext, token);

                        return accountService.getUserInfo(authorizationResp.getToken());
                    }
                });
    }
}
