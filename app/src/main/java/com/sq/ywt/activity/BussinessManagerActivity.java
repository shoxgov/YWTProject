package com.sq.ywt.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Toast;

import com.sq.ywt.R;
import com.sq.ywt.adapter.CustomGridViewAdapter;
import com.sq.ywt.bean.SettingItemInfo;
import com.sq.ywt.view.MyGridView;
import com.sq.ywt.view.TitleBarLayout;

import java.util.ArrayList;
import java.util.List;

import static android.widget.AdapterView.OnItemClickListener;


public class BussinessManagerActivity extends Activity {

    private List<SettingItemInfo> data;
    private MyGridView gridview;
    private CustomGridViewAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.titlebar_gridview);
        initView();
        init();
    }


    private void initView() {
        TitleBarLayout titleLayout = (TitleBarLayout) findViewById(R.id.titlelayout);
        titleLayout.setTitle("业务管理");
        titleLayout.setTitleBarListener(new TitleBarLayout.TitleBarListener() {

            @Override
            public void rightClick() {
            }

            @Override
            public void leftClick() {
                finish();
            }
        });
        gridview = (MyGridView) findViewById(R.id.more_gridview);
        adapter = new CustomGridViewAdapter(this);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(listener);
    }

    private void init() {
        initInfos();
        adapter.setData(data);
    }

    private void initInfos() {
        data = new ArrayList<SettingItemInfo>();
        SettingItemInfo bussiness = new SettingItemInfo();
        bussiness.setImgId(R.mipmap.ic_launcher);
        bussiness.setName("我的团队");
        data.add(bussiness);
        SettingItemInfo finance = new SettingItemInfo();
        finance.setImgId(R.mipmap.ic_launcher);
        finance.setName("网络关系");
        data.add(finance);
        SettingItemInfo trade = new SettingItemInfo();
        trade.setImgId(R.mipmap.ic_launcher);
        trade.setName("推荐关系");
        data.add(trade);
        SettingItemInfo personal = new SettingItemInfo();
        personal.setImgId(R.mipmap.ic_launcher);
        personal.setName("会员复投");
        data.add(personal);
        SettingItemInfo charge = new SettingItemInfo();
        charge.setImgId(R.mipmap.ic_launcher);
        charge.setName("注册会员");
        data.add(charge);
        SettingItemInfo email = new SettingItemInfo();
        email.setImgId(R.mipmap.ic_launcher);
        email.setName("消费卡办理");
        data.add(email);
    }

    OnItemClickListener listener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            switch (position) {
                case 0:
                    Intent myteam = new Intent();
                    myteam.setClass(BussinessManagerActivity.this, MyTeamActivity.class);
                    startActivity(myteam);
                    break;
                case 1:
                    Toast.makeText(BussinessManagerActivity.this, "暂未定义", Toast.LENGTH_SHORT).show();
                    break;
                case 2:Toast.makeText(BussinessManagerActivity.this, "暂未定义", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Intent reinsert = new Intent();
                    reinsert.setClass(BussinessManagerActivity.this, ReCastActivity.class);
                    startActivity(reinsert);
                    break;
                case 4:
                    Intent registory_more = new Intent();
                    registory_more.setClass(BussinessManagerActivity.this, RegisterActivity.class);
                    startActivity(registory_more);
                    break;
                case 5:
                    Intent card = new Intent();
                    card.setClass(BussinessManagerActivity.this, CustomCardActivity.class);
                    startActivity(card);
                    break;
            }
        }
    };

}
