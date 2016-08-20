package com.ctsig.android.ui.widget.loading;

import android.app.AlertDialog;
import android.content.Context;

import dmax.dialog.SpotsDialog;

/**
 * @version V1.0
 * @des loading
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 23:02
 */
public class LoadingView {
    private AlertDialog mLoadingDialog;

    public LoadingView(Context context, String message) {
        mLoadingDialog = new SpotsDialog(context, message);
    }

    public void show() {
        mLoadingDialog.show();
    }

    public void dismiss() {
        mLoadingDialog.dismiss();
    }
}
