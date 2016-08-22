package com.ctsig.android.injector.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @version V1.0
 * @des: Qualifier: 当类的类型不足以鉴别一个依赖的时候，我们就可以使用这个注解标示
 * @author: shen
 * @email: shenzhaoxiang@gmail.com
 * @date: 2016-05-19 16:59
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ForActivity {
}
