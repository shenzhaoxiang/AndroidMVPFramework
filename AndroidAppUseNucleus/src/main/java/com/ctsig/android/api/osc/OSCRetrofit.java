package com.ctsig.android.api.osc;

import com.ctsig.android.api.Api;
import com.ctsig.android.data.net.client.core.ApiEndpoint;
import com.ctsig.android.data.net.client.core.BaseRetrofit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-24 17:18
 */
public class OSCRetrofit extends BaseRetrofit {

    OSCHttpClient mHttpClient;

    @Inject
    public OSCRetrofit(OSCHttpClient mHttpClient) {
        this.mHttpClient = mHttpClient;
    }


    @Override
    public ApiEndpoint getApiEndpoint() {
        return new ApiEndpoint() {
            @Override
            public String getEndpoint() {
                return Api.GITHUB_BASE_URL;
            }
        } ;
    }

    @Override
    public OkHttpClient getHttpClient() {
        return mHttpClient.get();
    }
}
