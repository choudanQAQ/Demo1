package com.example.gjl.myjddemo.view.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gjl.myjddemo.R;

import java.util.Timer;

/**
 * 闪屏页面
 *
 * 过渡动画
 *  本页消除的时候，向左移动
 *  要跳转的页面从右往左移入
 */
public class SplashActivity extends BaseActivity {


    private View view;
    private TextView splash_time;
    private int time = 3;
    private Timer timer;
    private MyHandler myHandler =new MyHandler();
    @Override
    protected void initDatas() {
        //开始计时

    }

    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "==="+splash_time+"--"+time);
            splash_time.setText(time+"s");

            if (time==0){
                myHandler.removeCallbacksAndMessages(null);
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                //添加过渡动画
                overridePendingTransition(R.anim.enter_anim,R.anim.out_anim);
            }
            time--;
            myHandler.sendEmptyMessageDelayed(0,1000);
        }
    }

    @Override
    protected void initViews() {
        splash_time = view.findViewById(R.id.splash_time);
        Log.d(TAG, "initViews: "+splash_time);
        ImageView spalsh_icon = view.findViewById(R.id.splash_pic);
        myHandler.sendEmptyMessage(0);
    }

    @Override
    View createView() {
        view = View.inflate(this, R.layout.activity_splash, null);
        return view;
    }
}
