package com.ctsig.base.mvp.lce;

import android.support.annotation.UiThread;

import com.ctsig.base.mvp.MvpView;


/**
 * Created by mingjun on 16/8/9.
 */
public interface LoadView extends MvpView {

    @UiThread
    public void showLoading();

    @UiThread
    public void dismissLoading();

    @UiThread
    public void error(Throwable e);
}
