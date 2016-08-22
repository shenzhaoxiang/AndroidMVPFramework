package com.ctsig.android.common.utils;


import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * @version V1.0
 * @des 二次封装日志工具 https://github.com/orhanobut/logger
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 15:40
 */
public class LogUtils {

    static {
        Logger
            .init("※※※")                 // default PRETTYLOGGER or use just init()
            .methodCount(2)                 // default 2
            //.hideThreadInfo()               // default shown
            .logLevel(LogLevel.FULL)        // default LogLevel.FULL
            .methodOffset(1);                // default 0
            //.logAdapter(new AndroidLogAdapter()); //default AndroidLogAdapter
    }

    public static void d(String message, Object... args) {
        Logger.d(message, args);
    }

    public static void d(Object object) {
        Logger.d(object);
    }

    public static void e(String message, Object... args) {
        Logger.e(null, message, args);
    }

    public static void e(Throwable throwable, String message, Object... args) {
        Logger.e(throwable, message, args);
    }

    public static void i(String message, Object... args) {
        Logger.i(message, args);
    }

    public static void v(String message, Object... args) {
        Logger.v(message, args);
    }

    public static void w(String message, Object... args) {
        Logger.w(message, args);
    }

    public static void wtf(String message, Object... args) {
        Logger.wtf(message, args);
    }

    public static void json(String json) {
        Logger.json(json);
    }

    public static void xml(String xml) {
        Logger.xml(xml);
    }

}
