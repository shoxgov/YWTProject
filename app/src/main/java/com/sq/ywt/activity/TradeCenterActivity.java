package com.sq.ywt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;

import com.sq.ywt.R;
import com.sq.ywt.adapter.CustomGridViewAdapter;
import com.sq.ywt.bean.SettingItemInfo;
import com.sq.ywt.view.MyGridView;
import com.sq.ywt.view.TitleBarLayout;

import java.util.List;


public class TradeCenterActivity extends Activity {

    private List<SettingItemInfo> data;
    private MyGridView gridview;
    private CustomGridViewAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tradecenter);
        initView();
    }


    private void initView() {
        TitleBarLayout titleLayout = (TitleBarLayout) findViewById(R.id.titlelayout);
        titleLayout.setTitle("交易中心");
        titleLayout.setTitleBarListener(new TitleBarLayout.TitleBarListener() {

            @Override
            public void rightClick() {
            }

            @Override
            public void leftClick() {
                finish();
            }
        });
    }


}
