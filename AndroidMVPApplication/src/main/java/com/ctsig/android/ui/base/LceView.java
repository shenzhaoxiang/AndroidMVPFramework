package com.ctsig.android.ui.base;

import android.support.annotation.UiThread;

import com.ctsig.android.base.IBaseView;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 19:38
 */
public interface LceView<M> extends IBaseView {

    @UiThread
    public void showLoading();

    @UiThread
    public void dismissLoading();

    @UiThread
    public void showContent(M data);

    @UiThread
    public void showError(Throwable e);

    @UiThread
    public void showEmpty();
}