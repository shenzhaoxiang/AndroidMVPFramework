package com.ctsig.android.data.net.service;

import com.ctsig.android.data.model.entity.User;
import com.ctsig.android.data.net.request.CreateAuthorization;
import com.ctsig.android.data.net.response.AuthorizationResp;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 23:29
 */
public interface AccountService {

    @POST("/authorizations")
    Observable<AuthorizationResp> createAuthorization(
            @Body CreateAuthorization createAuthorization);

    @GET("/user")
    Observable<User> getUserInfo(@Query("access_token") String accessToken);
}
