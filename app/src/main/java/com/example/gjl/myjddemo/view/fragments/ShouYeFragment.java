package com.example.gjl.myjddemo.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.gjl.myjddemo.R;
import com.example.gjl.myjddemo.model.MiaoShaAdapter;
import com.example.gjl.myjddemo.model.ModelImpl;
import com.example.gjl.myjddemo.model.ShouYeBean;
import com.example.gjl.myjddemo.model.TuiJianAdapter;
import com.example.gjl.myjddemo.presenter.PresenterImpl;
import com.example.gjl.myjddemo.view.activities.DetailActivity;
import com.example.gjl.myjddemo.view.custumview.MyBanner;
import com.example.gjl.myjddemo.view.custumview.MyGridView;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gjl on 2018/3/29.
 */

public class ShouYeFragment extends BaseFragment implements IShouYeView {

    private View view;
    private MyBanner myBanner;
    private MyGridView tuijain_gv,ms_gv;

    @Override
    View createView(LayoutInflater inflater) {
        view = View.inflate(getActivity(), R.layout.sy_layout, null);
        //初始化视图
        initViews();
        return view;
    }

    private void initViews() {
        myBanner = view.findViewById(R.id.mybanner);
        MarqueeView marqueeView = (MarqueeView) view.findViewById(R.id.marquee);
        String notice = "心中有阳光，脚底有力量！心中有阳光，脚底有力量！心中有阳光，脚底有力量！";
        marqueeView.startWithText(notice);

// 在代码里设置自己的动画
        marqueeView.startWithText(notice, R.anim.anim_bottom_in, R.anim.anim_top_out);
        //推荐
        tuijain_gv = view.findViewById(R.id.tuijian_gv);
        ms_gv = view.findViewById(R.id.ms_gv);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //调用p层请求数据
        PresenterImpl presenter = new PresenterImpl();
        presenter.getAd(new ModelImpl(presenter), this);
    }

    //显示轮播图
    @Override
    public void showLunbo(final List<ShouYeBean.DataBean> list) {
        Log.d(TAG, "showLunbo:------ " + list);
        List<ImageView> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String icon = list.get(i).getIcon();
            ImageView imageView = new ImageView(getActivity());
            //点击事件
            final int finalI = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra("detail_url",list.get(finalI).getUrl());
                    startActivity(intent);
                }
            });
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(getActivity()).load(icon).into(imageView);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(15,0,0,0);
            imageView.setLayoutParams(lp);

            list1.add(imageView);

        }
        //放入Banner

        MyBanner.MyAdapter myAdapter = new MyBanner.MyAdapter(getActivity(), list1);
        myBanner.setAdapter(getActivity(), myAdapter);
        myBanner.start();
    }
    //秒杀
    @Override
    public void showMiaosha(List<ShouYeBean.MiaoshaBean.ListBeanX> list) {
        MiaoShaAdapter miaoShaAdapter = new MiaoShaAdapter(getActivity(), list);
        ms_gv.setAdapter(miaoShaAdapter);
    }

    //推荐
    @Override
    public void showTuiJian(List<ShouYeBean.TuijianBean.ListBean> list) {

//        tuijain_gv.setAdapter();
        TuiJianAdapter tuiJianAdapter = new TuiJianAdapter(getActivity(), list);
        tuijain_gv.setAdapter(tuiJianAdapter);
    }
}
