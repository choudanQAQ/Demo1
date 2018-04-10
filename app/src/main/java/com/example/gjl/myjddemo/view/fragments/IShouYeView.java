package com.example.gjl.myjddemo.view.fragments;

import com.example.gjl.myjddemo.model.ShouYeBean;

import java.util.List;

/**
 * 首页的接口View
 */

public interface IShouYeView {

    //显示轮播图
    void showLunbo(List<ShouYeBean.DataBean> list);
    //显示秒杀
    void showMiaosha(List<ShouYeBean.MiaoshaBean.ListBeanX> list);
    //显示推荐
    void showTuiJian(List<ShouYeBean.TuijianBean.ListBean> list);
}
