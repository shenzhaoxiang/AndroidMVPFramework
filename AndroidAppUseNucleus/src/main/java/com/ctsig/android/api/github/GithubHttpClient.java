package com.ctsig.android.api.github;

import android.app.Application;

import com.ctsig.android.api.base.CacheHttpClient;
import com.ctsig.android.data.pref.AccountPref;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-24 18:13
 */
public class GithubHttpClient extends CacheHttpClient{

    @Inject
    public Application application;

    @Inject
    public GithubHttpClient() {
    }

    public String getAcceptHeader() {
        return "application/vnd.github.v3.json";
    }

    @Override
    public OkHttpClient.Builder customize(OkHttpClient.Builder builder) {
        builder = super.customize(builder);

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .header("Accept", getAcceptHeader())
                        .header("User-Agent", "GithubApp");

                if (AccountPref.isLogon(application)) {
                    requestBuilder
                            .header("Authorization", "token " + AccountPref.getLogonToken(application));
                }

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        return builder;
    }

}
