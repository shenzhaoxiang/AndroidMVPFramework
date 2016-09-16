package com.ctsig.android.api.osc;

/**
 * @version: V1.0
 * @des:
 * @author: Shen
 * @email: shenzhaoxiang@gmail.com
 * @date: 2016-08-25 14:23
 */
public class OSCApi {

    private OSCService oscService;

    public OSCApi(OSCRetrofit oscRetrofit){
        oscService = oscRetrofit.get().create(OSCService.class) ;
    }

}
