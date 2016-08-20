package com.ctsig.android.data.pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.ctsig.android.data.model.entity.User;
import com.ctsig.android.ui.module.account.activity.LoginActivity;
import com.google.gson.Gson;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 23:36
 */
public class AccountPref {

    private static final String KEY_LOGIN_TOKEN = "login_token";
    private static final String KEY_LOGON_USER = "logon_user";

    private static SharedPreferences getPreference(Context context) {
        return context.getApplicationContext()
                .getSharedPreferences("account_preference.xml", Context.MODE_PRIVATE);
    }

    public static void saveLoginToken(Context context, String loginToken) {
        getPreference(context).edit().putString(KEY_LOGIN_TOKEN, loginToken).apply();
    }

    public static String getLogonToken(Context context) {
        return getPreference(context).getString(KEY_LOGIN_TOKEN, "");
    }

    public static void saveLogonUser(Context context, User user) {
        String userJson = new Gson().toJson(user);
        getPreference(context).edit().putString(KEY_LOGON_USER, userJson).apply();
    }

    public static void removeLogonUser(Context context) {
        getPreference(context).edit().remove(KEY_LOGON_USER).apply();
    }

    public static User getLogonUser(Context context) {
        User user = null;
        String userJson = getPreference(context).getString(KEY_LOGON_USER, "");
        if (!TextUtils.isEmpty(userJson)) {
            user = new Gson().fromJson(userJson, User.class);
        }
        return user;
    }

    public static boolean isLogon(Context context) {
        return !TextUtils.isEmpty(getLogonToken(context)) && getLogonUser(context) != null;
    }

    public static boolean checkLogon(Context context) {
        if (!isLogon(context)) {
            LoginActivity.launch(context);
            return false;
        }
        return true;
    }
}
