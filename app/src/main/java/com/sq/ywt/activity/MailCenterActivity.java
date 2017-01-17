package com.sq.ywt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import com.sq.ywt.R;
import com.sq.ywt.adapter.MailAdapter;
import com.sq.ywt.bean.NoticItemInfo;
import com.sq.ywt.view.TitleBarLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wsy on 2017/1/17.
 */
public class MailCenterActivity extends Activity {
    private ListView mailList;
    private MailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mailcenter);
        initView();
        init();
    }

    private void initView() {
        mailList = (ListView) findViewById(R.id.mailList);
        TitleBarLayout titleLayout = (TitleBarLayout) findViewById(R.id.titlelayout);
        titleLayout.setTitle("邮件中心");
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
        adapter = new MailAdapter(this);
        mailList.setAdapter(adapter);
        List<NoticItemInfo> data = new ArrayList<NoticItemInfo>();
        data.add(new NoticItemInfo());
        data.add(new NoticItemInfo());
        data.add(new NoticItemInfo());
        adapter.setData(data);
    }
}
