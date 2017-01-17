package com.sq.ywt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.sq.ywt.R;
import com.sq.ywt.view.TitleBarLayout;

/**
 * Created by wsy on 2017/1/17.
 */
public class ModifyPwdActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_modify_pwd);
        initView();
    }

    private void initView() {
        TitleBarLayout titleLayout = (TitleBarLayout) findViewById(R.id.titlelayout);
        titleLayout.setTitle("修改密码");
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
