package com.ctsig.android.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.ctsig.android.app.App;
import com.ctsig.android.di.component.AppComponent;
import com.ctsig.android.di.module.ActivityModule;
import com.squareup.leakcanary.RefWatcher;

import butterknife.ButterKnife;
import icepick.Icepick;
import nucleus.presenter.Presenter;
import nucleus.view.NucleusAppCompatActivity;

/**
 * @version V1.0
 * @des: Activity基类
 * @author: shen
 * @email: shenzhaoxiang@gmail.com
 * @date: 2016-05-19 16:24
 */
public abstract class BaseActivity <P extends Presenter> extends NucleusAppCompatActivity<P> implements IBaseActivity {
    protected final String TAG = getClass().getSimpleName();

    /**当前Activity渲染的视图View**/
    private View mContextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        injectorPresenter();
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 屏幕方向固定
        if(getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        // 设置layout
        mContextView = LayoutInflater.from(this).inflate(bindLayout(), null);
        setContentView(mContextView);
        // 初始化
        init();
        //初始化控件
        initViewsAndEvents(mContextView);
        //业务操作
        doBusiness(this);
    }

    private void init(){
        // 注解绑定
        ButterKnife.bind(this);
        // 设置presenter
        setPresenterFactory(getPresenterFactory());
        //初始化参数
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
        }else{
            bundle = new Bundle();
        }
        getBundleExtras(bundle);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    @Override
    public Context getContext() {
        return this;
    }


    protected AppComponent getAppComponent() {
        return ((App) getApplication()).getAppComponent();
    }


    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    protected void injectorPresenter() {}

    @CallSuper
    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = App.getRefWatcher();
        refWatcher.watch(this);
    }


    /**********************************************************************************************/
    /*****************                   Activity跳转                   ***************************/
    /**********************************************************************************************/
    /**
     * startActivity
     *
     * @param clazz
     */
    protected void readyGo(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * startActivity with bundle
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * startActivity then finish
     *
     * @param clazz
     */
    protected void readyGoThenKill(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        finish();
    }

    /**
     * startActivity with bundle then finish
     *
     * @param clazz
     * @param bundle
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz
     * @param requestCode
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz
     * @param requestCode
     * @param bundle
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }
    /**********************************************************************************************/
    /*****************                   Activity跳转                   ***************************/
    /**********************************************************************************************/

}
