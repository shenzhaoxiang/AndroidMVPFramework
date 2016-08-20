package com.ctsig.android.data.api;

import com.ctsig.android.BuildConfig;

/**
 * @des API
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-05-19 16:19
 */
public class Api {
    // 微信精选数据数据API
//    public static final String BASE_URL = "http://v.juhe.cn/";
    // 问答机器人
    public static final String BASE_URL = BuildConfig.API_URL;
    // 聚合微信精选key
    public static final String KEY_WEIXIN = "3764850bc29d2a42034d9df9a7f5a00b" ;
    // 聚合问答机器人key
    public static final String KEY_ROBOT = "ed5c844ba7e2c86a16d5a5bb5cccaca5" ;
    // 每页20条数据
    public static final int PAGE_SIZE = 20 ;
    // 数据格式
    public static final String DATA_TYPE = "json" ;
}
