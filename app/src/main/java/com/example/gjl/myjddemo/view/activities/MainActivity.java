package com.example.gjl.myjddemo.view.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gjl.myjddemo.R;
import com.example.gjl.myjddemo.view.fragments.BaseFragment;
import com.example.gjl.myjddemo.view.fragments.FragmentFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页面
 * <p>
 * 5个Fragment
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private View view;
    private List<BaseFragment> list = new ArrayList<>();
    private List<TextView> tv_list = new ArrayList<>();
    private FragmentManager fm;
    private final int SY=0,FL=1,FX=2,GWC=3,WD=4;
    @Override
    protected void initDatas() {

    }

    @Override
    protected void initViews() {
        //
        TextView main_shouye = view.findViewById(R.id.main_shouye);
        TextView main_fenlei = view.findViewById(R.id.main_fenlei);
        TextView main_faxian = view.findViewById(R.id.main_faxian);
        TextView main_gwc = view.findViewById(R.id.main_gwc);
        TextView main_wd = view.findViewById(R.id.main_wd);
        //将textvview添加到集合里面
        tv_list.add(main_shouye);
        tv_list.add(main_fenlei);
        tv_list.add(main_faxian);
        tv_list.add(main_gwc);
        tv_list.add(main_wd);
        main_shouye.setOnClickListener(this);
        main_fenlei.setOnClickListener(this);
        main_faxian.setOnClickListener(this);
        main_gwc.setOnClickListener(this);
        main_wd.setOnClickListener(this);
        //默认选中首页
        main_shouye.setSelected(true);
        //将Fragment添加到容器里面 replace不建议用

        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        for (int i = 0; i < 5; i++) {
            BaseFragment fragment = FragmentFactory.createFragment(i);
            ft.add(R.id.main_content, fragment);
            ft.hide(fragment);
            list.add(fragment);

        }

        ft.show(list.get(0));

        ft.commit();

    }

    @Override
    View createView() {
        view = View.inflate(this, R.layout.activity_main, null);
        return view;
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_shouye:
                //改变状态
                changeNav(SY);
                //联动
                changeFragment(SY);
                break;
            case R.id.main_fenlei:
                changeNav(FL);
                changeFragment(FL);
                break;
            case R.id.main_faxian:
                changeNav(FX);
                changeFragment(FX);
                break;
            case R.id.main_gwc:
                changeNav(GWC);
                changeFragment(GWC);
                break;
            case R.id.main_wd:
                changeNav(WD);
                changeFragment(WD);
                break;
        }
    }

    //切换导航栏状态的方法
    public void changeNav(int i) {
        for (int j = 0; j < tv_list.size(); j++) {
            if (j == i) {
                tv_list.get(i).setSelected(true);
            } else {
                tv_list.get(j).setSelected(false);
            }
        }
    }

    //切换Fragment的方法
    public void changeFragment(int type) {
        FragmentTransaction ft = fm.beginTransaction();
        for (int i = 0; i < list.size(); i++) {
            BaseFragment fragment = list.get(i);
            if (i == type) {
                ft.show(fragment);
            } else {
                ft.hide(fragment);
            }
        }
        ft.commit();
    }
}
