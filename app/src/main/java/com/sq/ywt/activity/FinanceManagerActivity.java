package com.sq.ywt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;

import com.sq.ywt.R;
import com.sq.ywt.adapter.CustomGridViewAdapter;
import com.sq.ywt.bean.SettingItemInfo;
import com.sq.ywt.view.MyGridView;
import com.sq.ywt.view.TitleBarLayout;

import java.util.ArrayList;
import java.util.List;

import static android.widget.AdapterView.OnItemClickListener;


public class FinanceManagerActivity extends Activity {

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
        titleLayout.setTitle("财务管理");
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
        bussiness.setName("奖金提现");
        data.add(bussiness);
        SettingItemInfo finance = new SettingItemInfo();
        finance.setImgId(R.mipmap.ic_launcher);
        finance.setName("汇款充值");
        data.add(finance);
        SettingItemInfo trade = new SettingItemInfo();
        trade.setImgId(R.mipmap.ic_launcher);
        trade.setName("入账记录");
        data.add(trade);
        SettingItemInfo personal = new SettingItemInfo();
        personal.setImgId(R.mipmap.ic_launcher);
        personal.setName("出账记录");
        data.add(personal);
        SettingItemInfo charge = new SettingItemInfo();
        charge.setImgId(R.mipmap.ic_launcher);
        charge.setName("奖金明细");
        data.add(charge);
        SettingItemInfo email = new SettingItemInfo();
        email.setImgId(R.mipmap.ic_launcher);
        email.setName("会员转账");
        data.add(email);
        SettingItemInfo customWithdraw = new SettingItemInfo();
        customWithdraw.setImgId(R.mipmap.ic_launcher);
        customWithdraw.setName("消费卡套现");
        data.add(customWithdraw);
    }

    OnItemClickListener listener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            switch (position) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        }
    };

}
