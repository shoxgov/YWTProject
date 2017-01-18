package com.sq.ywt.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.sq.ywt.R;
import com.sq.ywt.view.TitleBarLayout;

import static com.sq.ywt.R.id.recase_spinner;


/**
 * Created by wsy on 2017/1/18.
 */
public class BonusWithdrawActivity extends Activity {
    private Spinner bonus_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_bonus);
        initView();
        init();
    }

    private void initView() {
        TitleBarLayout titleLayout = (TitleBarLayout) findViewById(R.id.titlelayout);
        titleLayout.setTitle("奖金提现");
        titleLayout.setRightBtnShow("提现记录");
        titleLayout.setTitleBarListener(new TitleBarLayout.TitleBarListener() {

            @Override
            public void rightClick() {
                Intent history = new Intent();
                history.setClass(BonusWithdrawActivity.this, BonusHistoryActivity.class);
                startActivity(history);
            }

            @Override
            public void leftClick() {
                finish();
            }
        });
    }

    private void init() {
        bonus_spinner = (Spinner) findViewById(R.id.bonus_spinner);
        // 建立数据源
        String[] mItems = getResources().getStringArray(R.array.bank);
// 建立Adapter并且绑定数据源
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mItems);
        bonus_spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }
}
