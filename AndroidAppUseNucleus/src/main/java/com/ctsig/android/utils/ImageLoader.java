package com.ctsig.android.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * @version V1.0
 * @des 封装Glide图片加载库
 * @author: shen
 * @email shenzhaoxiang@gmail.com
 * @date: 2016-08-20 16:34
 */
public class ImageLoader {

    /**
     * 加载图片
     * @param context 上下文
     * @param url 图片地址
     * @param imageView 图片组件
     */
    public static void displayImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .crossFade()
                .into(imageView);
    }

    /**
     * 加载图片
     * @param context 上下文信息
     * @param url 下载地址
     * @param imageView 图片组件
     * @param loadingImageResId  正在加载时显示的图片
     * @param errorImageResId  加载出错时显示的图片
     */
    public static void displayImage(Context context, String url, ImageView imageView, int loadingImageResId,int errorImageResId ) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .placeholder(loadingImageResId)
                .crossFade()
                .error(errorImageResId)
                .into(imageView);
    }
}
