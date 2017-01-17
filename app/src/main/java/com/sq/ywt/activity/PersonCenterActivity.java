package com.sq.ywt.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.sq.ywt.R;
import com.sq.ywt.view.TitleBarLayout;


public class PersonCenterActivity extends Activity implements View.OnClickListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_person);
        initView();
    }


    private void initView() {
        findViewById(R.id.person_info).setOnClickListener(this);
        findViewById(R.id.person_modify_info).setOnClickListener(this);
        findViewById(R.id.person_modify_pwd).setOnClickListener(this);
        findViewById(R.id.person_register).setOnClickListener(this);
        TitleBarLayout titleLayout = (TitleBarLayout) findViewById(R.id.titlelayout);
        titleLayout.setTitle("个人中心");
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


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.person_info:
                break;
            case R.id.person_modify_info:
                Intent info = new Intent();
                info.setClass(this, ModifyInfoActivity.class);
                this.startActivity(info);
                break;
            case R.id.person_modify_pwd:
                Intent pwd = new Intent();
                pwd.setClass(this, ModifyPwdActivity.class);
                this.startActivity(pwd);
                break;
            case R.id.person_register:
                Intent register = new Intent();
                register.setClass(this, RegisterActivity.class);
                this.startActivity(register);
                break;
        }
    }
}
