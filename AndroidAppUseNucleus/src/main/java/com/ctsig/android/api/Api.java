package com.ctsig.android.api;

import com.ctsig.android.BuildConfig;

/**
 * @version V1.0
 * @des
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-22 11:43
 */
public interface Api {
    // public static final String BASE_URL = BuildConfig.API_URL;

    // github url
    public static final String GITHUB_BASE_URL = BuildConfig.GITHUB_API_URL;

    public static final String CTG_BASE_URL = "http://192.168.104.142:8080/web/api/" ;


    // 缓存大小设置
    public static final long CACHE_SIZE = 1024 * 1024 * 50;

}
