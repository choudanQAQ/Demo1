package com.example.gjl.myjddemo.presenter;

import com.example.gjl.myjddemo.model.IModel;
import com.example.gjl.myjddemo.model.ShouYeBean;
import com.example.gjl.myjddemo.view.fragments.IShouYeView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by gjl on 2018/3/24.
 */

public class PresenterImpl implements IPresenter {

    private IShouYeView iShouYeView;

    @Override
    public void getAd(IModel iModel, IShouYeView iShouYeView) {
        this.iShouYeView=iShouYeView;
        //imodel请求数据
        Map<String,String> map=new HashMap<>();
        iModel.getLunBo(map);

    }
    //需要在定义一个方法，从model里面调用，从而获取数据
    @Override
    public void getAdData(List<ShouYeBean.DataBean> list) {
        iShouYeView.showLunbo(list);
    }

    @Override
    public void getTjData(List<ShouYeBean.TuijianBean.ListBean> list) {
        iShouYeView.showTuiJian(list);
    }

    @Override
    public void getMsData(List<ShouYeBean.MiaoshaBean.ListBeanX> list) {
        iShouYeView.showMiaosha(list);
    }
}
