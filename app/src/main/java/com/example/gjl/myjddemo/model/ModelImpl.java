package com.example.gjl.myjddemo.model;

import android.util.Log;

import com.example.gjl.myjddemo.http.RetrofitUtils;
import com.example.gjl.myjddemo.presenter.IPresenter;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 子类具体去实现
 */

public class ModelImpl implements IModel {
    private static final String TAG = "ModelImpl---";
    private final IPresenter iPresenter;

    public ModelImpl(IPresenter iPresenter){
        this.iPresenter = iPresenter;
    }

    //请求数据
    @Override
    public void getLunBo(Map<String, String> map) {
        //使用Retrofit请求网络
        RetrofitUtils retrofitUtils = RetrofitUtils.getRetrofitUtils();
        MyService myService = retrofitUtils.createRequest(MyService.class);
        //调用方法
        myService.getAd(map)
                .subscribeOn(Schedulers.newThread())//将请求过程切换到一个线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShouYeBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "完成-----");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "e---"+e);
                    }

                    @Override
                    public void onNext(ShouYeBean shouYeBean) {
                        Log.d(TAG, "--"+shouYeBean.toString());

                        iPresenter.getAdData(shouYeBean.getData());
                        //取出推荐，传入Presenter
                        iPresenter.getTjData(shouYeBean.getTuijian().getList());
                        //秒杀
                        iPresenter.getMsData(shouYeBean.getMiaosha().getList());
                    }
                })
        ;
    }
}
