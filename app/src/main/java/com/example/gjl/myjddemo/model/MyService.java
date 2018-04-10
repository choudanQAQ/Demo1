package com.example.gjl.myjddemo.model;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Retrofit就是api--javabean
 * <p>
 * get/post
 * 登录，注册等安全性比较高的，，post   Field    FieldMap
 * Body
 * <p>
 * 简单的就是获取数据 get  Query     QueryMap
 */

public interface MyService {

    @GET("ad/getAd")
    Observable<ShouYeBean> getAd(@QueryMap Map<String, String> map);
//    Call<ShouYeBean> getAd();


}
