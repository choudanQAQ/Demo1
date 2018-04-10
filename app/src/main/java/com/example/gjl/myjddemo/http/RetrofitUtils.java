package com.example.gjl.myjddemo.http;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络请求工具类
 * <p>
 * 1.单利
 * 2.get/post  拦截器
 */

public class RetrofitUtils {
    //单利
    private static RetrofitUtils retrofitUtils = null;
    private final Retrofit retrofit;

    public static RetrofitUtils getRetrofitUtils() {
        if (retrofitUtils == null) {
            retrofitUtils = new RetrofitUtils();
        }
        return retrofitUtils;
    }

    //初始化
    public RetrofitUtils() {
        //建造者模式，
//和RxJava集合使用的时候需要配置的
//直接将json---JavaBean
        retrofit = new Retrofit.Builder()//建造者模式，
                .baseUrl(HttpConfig.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//和RxJava集合使用的时候需要配置的
                .addConverterFactory(GsonConverterFactory.create(new Gson()))//直接将json---JavaBean
                .build();
    }


    //通过反射创建服务的实例对象
    //T  代表泛型里面的type
    //why  通过反射生成接口的子类对象，方便调用方法
    public <T> T createRequest(Class<T> clz) {
        T t = retrofit.create(clz);
        return t;
    }
}
