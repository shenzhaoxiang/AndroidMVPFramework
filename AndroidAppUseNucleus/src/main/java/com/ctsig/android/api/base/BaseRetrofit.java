package com.ctsig.android.api.base;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 17:58
 */
public abstract class BaseRetrofit {
    public Retrofit get() {
        Retrofit.Builder builder = new Retrofit.Builder();

        builder.baseUrl(getApiEndpoint().getEndpoint())
                .client(getHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        return builder.build();
    }

    public abstract ApiEndpoint getApiEndpoint();
    public abstract OkHttpClient getHttpClient();
}
