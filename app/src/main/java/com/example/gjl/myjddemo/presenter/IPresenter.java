package com.example.gjl.myjddemo.presenter;

import com.example.gjl.myjddemo.model.IModel;
import com.example.gjl.myjddemo.model.ShouYeBean;
import com.example.gjl.myjddemo.view.fragments.IShouYeView;

import java.util.List;

/**
 * MVP
 *
 *
 *
 *
 */

public interface IPresenter {

    //将首页的数据交个View显示
    void getAd(IModel iModel, IShouYeView iShouYeView);
    //获取m层数据
    void getAdData(List<ShouYeBean.DataBean> list);
    //推荐
    void getTjData(List<ShouYeBean.TuijianBean.ListBean> list);
    //秒杀
    void getMsData(List<ShouYeBean.MiaoshaBean.ListBeanX> list);
}
