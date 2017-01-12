package com.sq.ywt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import com.sq.ywt.R;
import com.sq.ywt.adapter.NoticeAdapter;
import com.sq.ywt.bean.NoticItemInfo;
import com.sq.ywt.view.TitleBarLayout;
import com.sq.ywt.view.TitleBarLayout.TitleBarListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wsy on 2017/1/12.
 */

public class NoticeInfoActivity extends Activity {
    private ListView commList;
    private NoticeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_notic);
        initViews();
        init();
    }

    private void initViews() {
        commList = (ListView) findViewById(R.id.commList);
        TitleBarLayout titleLayout = (TitleBarLayout) findViewById(R.id.titlelayout);
        titleLayout.setTitle("公告");
        titleLayout.setTitleBarListener(new TitleBarListener() {

            @Override
            public void rightClick() {
            }

            @Override
            public void leftClick() {
                finish();
            }
        });
    }

    private void init(){
        adapter = new NoticeAdapter(this);
        commList.setAdapter(adapter);
        List<NoticItemInfo> data = new ArrayList<NoticItemInfo>();
        data.add(new NoticItemInfo());
        data.add(new NoticItemInfo());
        data.add(new NoticItemInfo());
        adapter.setData(data);
    }
}
