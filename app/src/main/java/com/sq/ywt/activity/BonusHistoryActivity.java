package com.sq.ywt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import com.sq.ywt.R;
import com.sq.ywt.adapter.BonusHistorydapter;
import com.sq.ywt.bean.NoticItemInfo;
import com.sq.ywt.view.TitleBarLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wsy on 2017/1/18.
 */
public class BonusHistoryActivity extends Activity {
    private ListView historyList;
    private BonusHistorydapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bonus_history);
        initView();
        init();
    }

    private void initView() {
        historyList = (ListView) findViewById(R.id.bonushistoryList);
        TitleBarLayout titleLayout = (TitleBarLayout) findViewById(R.id.titlelayout);
        titleLayout.setTitle("提现记录");
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

    private void init() {
        adapter = new BonusHistorydapter(this);
        historyList.setAdapter(adapter);
        List<NoticItemInfo> data = new ArrayList<NoticItemInfo>();
        data.add(new NoticItemInfo());
        data.add(new NoticItemInfo());
        data.add(new NoticItemInfo());
        adapter.setData(data);
    }
}
