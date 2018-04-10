package com.example.gjl.myjddemo.view.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gjl.myjddemo.R;

public abstract class BaseFragment extends Fragment {

    public  final String TAG = this.getClass().getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createView(inflater);
        return view;
    }
    //创建视图
     abstract View createView(LayoutInflater inflater);

}
