package com.ctsig.android.data.net.client.core;

import com.ctsig.android.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 17:59
 */
public abstract class BaseOkHttpClient {
    private static final long TIMEOUT_CONNECT = 30 * 1000;

    public OkHttpClient get() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS)
                .addInterceptor(new HttpLoggingInterceptor()
                        .setLevel(BuildConfig.DEBUG ?
                                HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE));

        builder = customize(builder);

        return builder.build();
    }

    public abstract OkHttpClient.Builder customize(OkHttpClient.Builder builder);
}
