package com.ctsig.android.ui.module.account.presenter;

import android.os.Bundle;

import com.ctsig.android.base.BasePresenter;
import com.ctsig.android.utils.LogUtils;
import com.ctsig.android.data.api.AccountApi;
import com.ctsig.android.data.model.entity.User;
import com.ctsig.android.data.transformer.SchedulerTransformer;
import com.ctsig.android.ui.module.account.activity.LoginActivity;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action2;
import rx.functions.Func0;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 20:56
 */
public class LoginPresenter extends BasePresenter<LoginActivity> {

    private static final int REQUEST_ID = 1;
    private LoginActivity activity;

    @Inject
    AccountApi mAccountApi;

    private String username;
    private String password;

    public LoginPresenter(){
        LogUtils.d("LoginPresenter()");
    }

    @Override
    protected void onTakeView(LoginActivity activity) {
        super.onTakeView(activity);
        this.activity = activity;
    }

//    @Inject
//    public void setApi(AccountApi api){
//        this.mAccountApi = api ;
//    }

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        restartableFirst(REQUEST_ID, new Func0<Observable<User>>() {

            @Override
            public Observable<User> call() {
                return mAccountApi.login(username, password)
                        .compose(new SchedulerTransformer<User>())
                        .doOnSubscribe(new Action0() {
                            @Override
                            public void call() {
                                activity.showLoading();
                            }
                        }).doOnTerminate(new Action0() {
                            @Override
                            public void call() {
                                activity.dismissLoading();
                            }
                        });
            }
        }, new Action2<LoginActivity, User>() {
            @Override
            public void call(LoginActivity activity, User user) {
                activity.loginSuccess(user);
            }
        }, new Action2<LoginActivity, Throwable>() {
            @Override
            public void call(LoginActivity activity, Throwable throwable) {
                throwable.printStackTrace();
                activity.error(throwable);
            }
        });
    }

    public void login(String username, String password) {
        this.username = username ;
        this.password = password ;
        start(REQUEST_ID);
    }
}
