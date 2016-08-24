package com.ctsig.android.ui.base;

import android.os.Bundle;
import android.support.design.widget.Snackbar;

import com.ctsig.android.base.BaseActivity;
import com.ctsig.android.widget.loading.LoadingView;

import nucleus.presenter.Presenter;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 21:07
 */
public abstract class BaseLoadingActivity<P extends Presenter> extends BaseActivity<P> implements LoadView {

    private LoadingView mLoadingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoadingView = new LoadingView(this, getLoadingMessage());
    }

    @Override
    public void showLoading() {
        mLoadingView.show();
    }

    @Override
    public void dismissLoading() {
        mLoadingView.dismiss();
    }

    public abstract String getLoadingMessage();

    @Override
    public void error(Throwable e) {
        Snackbar.make(getWindow().getDecorView(), e.getMessage(), Snackbar.LENGTH_LONG).show();
    }
}
