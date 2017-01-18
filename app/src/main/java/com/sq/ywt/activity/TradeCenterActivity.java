package com.sq.ywt.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;

import com.sq.ywt.R;
import com.sq.ywt.adapter.CustomGridViewAdapter;
import com.sq.ywt.bean.SettingItemInfo;
import com.sq.ywt.view.MyGridView;
import com.sq.ywt.view.TitleBarLayout;

import java.util.List;


public class TradeCenterActivity extends Activity implements View.OnClickListener {

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
        findViewById(R.id.trade_buy_apply).setOnClickListener(this);
        findViewById(R.id.trade_buy_apply_history).setOnClickListener(this);
        findViewById(R.id.trade_credit_apply).setOnClickListener(this);
        findViewById(R.id.trade_credit_apply_history).setOnClickListener(this);
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


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.trade_buy_apply:
//                Intent buy = new Intent();
//                buy.setClass(TradeCenterActivity.this, PersonCenterActivity.class);
//                startActivity(buy);
                break;
            case R.id.trade_buy_apply_history:

                break;
            case R.id.trade_credit_apply:
                Intent credit = new Intent();
                credit.setClass(TradeCenterActivity.this, TradeCreditApplyActivity.class);
                startActivity(credit);
                break;
            case R.id.trade_credit_apply_history:

                break;
        }
    }
}
