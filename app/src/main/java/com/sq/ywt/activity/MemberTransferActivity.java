package com.sq.ywt.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.sq.ywt.R;
import com.sq.ywt.view.TitleBarLayout;

/**
 * Created by wsy on 2017/1/18.
 */
public class MemberTransferActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_member_transfer);
        initView();
    }

    private void initView() {
        TitleBarLayout titleLayout = (TitleBarLayout) findViewById(R.id.titlelayout);
        titleLayout.setTitle("会员转账");
        titleLayout.setRightBtnShow("转账记录");
        titleLayout.setTitleBarListener(new TitleBarLayout.TitleBarListener() {

            @Override
            public void rightClick() {
                Intent history = new Intent();
                history.setClass(MemberTransferActivity.this, MemberTransferHistoryActivity.class);
                startActivity(history);
            }

            @Override
            public void leftClick() {
                finish();
            }
        });
    }
}
