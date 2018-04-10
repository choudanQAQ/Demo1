package com.example.gjl.myjddemo.view.custumview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.example.gjl.myjddemo.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gjl on 2018/3/29.
 */

public class MyBanner extends RelativeLayout {

    private ViewPager viewPager;
    private LinearLayout ll_points;
    private List<ImageView> points = new ArrayList<>();
    public static List<ImageView> list;
    private MyHandler myHandler=new MyHandler();
    public MyBanner(Context context) {
        this(context, null);
    }

    public MyBanner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = View.inflate(context, R.layout.layout_my_banner, this);

        //初始化控件
        viewPager = view.findViewById(R.id.my_viewPager);
        ll_points = view.findViewById(R.id.ll_points);

        //添加滑动事件
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                position=position%points.size();

                for (int i = 0; i < points.size(); i++) {
                    if (i==position){
                        points.get(i).setSelected(true);
                    }else {
                        points.get(i).setSelected(false);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void start(){
        myHandler.sendEmptyMessageDelayed(0,1000);
    }

    public void stop(){
        myHandler.removeCallbacksAndMessages(null);
    }

    public void setAdapter(Context context, PagerAdapter pagerAdapter) {
        viewPager.setAdapter(pagerAdapter);
        //添加小圆点
        for (int i = 0; i < list.size(); i++) {
            ImageView point = new ImageView(context);
            point.setImageResource(R.drawable.point_selector);
            //添加到
            ll_points.addView(point);
            points.add(point);
        }
        //默认第一个选中
        points.get(0).setSelected(true);
    }

    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            myHandler.sendEmptyMessageDelayed(0,1000);
        }
    }

    //适配器
    public static class MyAdapter extends PagerAdapter {
        private Context context;
        public MyAdapter(Context context, List<ImageView> list1) {
            this.context = context;
            list = list1;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position=position%list.size();
            ImageView imageView = list.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((ImageView) object);
        }
    }
}
