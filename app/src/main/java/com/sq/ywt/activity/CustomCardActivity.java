package com.sq.ywt.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.sq.ywt.R;
import com.sq.ywt.view.TitleBarLayout;

/**
 * Created by wsy on 2017/1/18.
 */
public class CustomCardActivity extends Activity {
    private Spinner customcard_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_customcard);
        initView();
    }

    private void initView() {
        TitleBarLayout titleLayout = (TitleBarLayout) findViewById(R.id.titlelayout);
        titleLayout.setTitle("消费卡办理");
        titleLayout.setRightBtnShow("历史查询");
        titleLayout.setTitleBarListener(new TitleBarLayout.TitleBarListener() {

            @Override
            public void rightClick() {
                Intent history = new Intent();
                history.setClass(CustomCardActivity.this, CustomCardHistoryActivity.class);
                startActivity(history);
            }

            @Override
            public void leftClick() {
                finish();
            }
        });

        customcard_spinner = (Spinner) findViewById(R.id.customcard_spinner);
        // 建立数据源
        String[] mItems = getResources().getStringArray(R.array.stargrade);
// 建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mItems);
        customcard_spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }
}
