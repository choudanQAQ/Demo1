package com.example.gjl.myjddemo.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.gjl.myjddemo.R;

/**
 * Created by gjl on 2018/3/29.
 */

public class DetailActivity extends BaseActivity {

    private View view;
    private WebView webView;

    @Override
    protected void initDatas() {
        Intent intent = getIntent();

        final String detail_url = intent.getStringExtra("detail_url");
        webView.loadUrl(detail_url);
        //防止启动系统浏览器
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(detail_url);
                return true;
            }
        });
    }

    @Override
    protected void initViews() {
        webView = view.findViewById(R.id.detail_wv);
    }

    @Override
    View createView() {
        view = View.inflate(this, R.layout.layout_detail, null);

        return view;
    }
}
