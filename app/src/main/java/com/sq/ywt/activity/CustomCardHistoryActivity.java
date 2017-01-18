package com.sq.ywt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import com.sq.ywt.R;
import com.sq.ywt.adapter.CustomCardHistorydapter;
import com.sq.ywt.adapter.MyTeamAdapter;
import com.sq.ywt.bean.NoticItemInfo;
import com.sq.ywt.view.TitleBarLayout;

import java.util.ArrayList;
import java.util.List;

import static com.sq.ywt.R.id.enddate;
import static com.sq.ywt.R.id.myteamList;
import static com.sq.ywt.R.id.startdate;


/**
 * Created by wsy on 2017/1/18.
 */
public class CustomCardHistoryActivity extends Activity {
    private CustomCardHistorydapter adapter;
    private ListView historyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_customcard_history);
        initView();
        init();
    }

    private void init() {
        adapter = new CustomCardHistorydapter(this);
        historyList.setAdapter(adapter);
        List<NoticItemInfo> data = new ArrayList<NoticItemInfo>();
        data.add(new NoticItemInfo());
        data.add(new NoticItemInfo());
        data.add(new NoticItemInfo());
        adapter.setData(data);
    }

    private void initView() {
        historyList = (ListView) findViewById(R.id.historyList);
        TitleBarLayout titleLayout = (TitleBarLayout) findViewById(R.id.titlelayout);
        titleLayout.setTitle("消费卡办理记录");
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
