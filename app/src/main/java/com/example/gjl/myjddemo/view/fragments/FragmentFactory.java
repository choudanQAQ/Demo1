package com.example.gjl.myjddemo.view.fragments;

/**
 * Created by gjl on 2018/3/23.
 */

public class FragmentFactory {

    public static BaseFragment createFragment(int type) {
        BaseFragment fragment = null;
        switch (type) {
            case 0:
                fragment = new ShouYeFragment();
                break;
            case 1:
                fragment = new FenLeiFragment();
                break;
            case 2:
                fragment = new FaXianFragment();
                break;
            case 3:
                fragment = new GwcFragment();
                break;
            case 4:
                fragment = new WdFragment();
                break;
        }
        return fragment;
    }

}
