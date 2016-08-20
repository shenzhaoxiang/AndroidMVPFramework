package com.ctsig.android.di.scope;


import java.lang.annotation.Retention;
import javax.inject.Scope;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
 * @version V1.0
 * @des: @Scope:限定注解作用域
 * @author: shen
 * @email: shenzhaoxiang@gmail.com
 * @date: 2016-05-19 16:59
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {}