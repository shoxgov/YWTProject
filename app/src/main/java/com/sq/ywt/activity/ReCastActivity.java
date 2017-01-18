package com.sq.ywt.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.sq.ywt.R;
import com.sq.ywt.view.TitleBarLayout;

import static com.sq.ywt.R.id.customcard_spinner;


/**
 * Created by wsy on 2017/1/18.
 */
public class ReCastActivity extends Activity {
    private Spinner recase_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_recast);
        initView();
    }

    private void initView() {
        TitleBarLayout titleLayout = (TitleBarLayout) findViewById(R.id.titlelayout);
        titleLayout.setTitle("会员复投");
        titleLayout.setRightBtnShow("复投记录");
        titleLayout.setTitleBarListener(new TitleBarLayout.TitleBarListener() {

            @Override
            public void rightClick() {
                Intent history = new Intent();
                history.setClass(ReCastActivity.this, ReCastHistoryActivity.class);
                startActivity(history);
            }

            @Override
            public void leftClick() {
                finish();
            }
        });

        recase_spinner = (Spinner) findViewById(R.id.recase_spinner);
        // 建立数据源
        String[] mItems = getResources().getStringArray(R.array.recast);
// 建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mItems);
        recase_spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }
}
