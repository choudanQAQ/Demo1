package com.example.gjl.myjddemo.view.activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

/**
 * Activity的基类
 */

public abstract class BaseActivity extends FragmentActivity {

    public  final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏、actionbar----沉浸式
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(createView());
        //初始化控件
        initViews();
        //初始化数据
        initDatas();
    }

    protected abstract void initDatas();

    protected abstract void initViews();

    //创建View的方法
    abstract View createView();
}
