//package com.ctsig.android.base;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.ctsig.android.app.App;
//import com.ctsig.android.injector.component.ApiComponent;
//import com.ctsig.android.injector.component.AppComponent;
//
//import butterknife.ButterKnife;
//import icepick.Icepick;
//import nucleus.presenter.Presenter;
//import nucleus.view.NucleusSupportFragment;
//
///**
// * @des:
// * @author: shen
// * @email: shenzhaoxiang@gmail.com
// * @date: 2016-05-19 18:31
// */
//public abstract class BaseFragment<P extends Presenter> extends NucleusSupportFragment<P> implements IBaseFragment {
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        injectorPresenter();
//        super.onCreate(savedInstanceState);
//        //setPresenterFactory(getPresenterFactory());
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);
//        View rootView = inflater.inflate(bindLayout(), container, false);
//        ButterKnife.bind(this, rootView);
//        // 初始化控件
//        initViews(rootView,savedInstanceState);
//        // 业务操作
//        doBusiness(getActivity());
//        return rootView;
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        Icepick.restoreInstanceState(this, savedInstanceState);
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle bundle) {
//        super.onSaveInstanceState(bundle);
//        Icepick.saveInstanceState(this, bundle);
//    }
//
//    @Override
//    public Context getContext() {
//        return getActivity();
//    }
//
//    protected AppComponent getComponent() {
//        return ((App) getActivity().getApplication()).getComponent();
//    }
//
//    protected ApiComponent getApiComponent() {
//        return ((App) getActivity().getApplication()).getApiComponent();
//    }
//
//    protected void injectorPresenter() {}
//}
