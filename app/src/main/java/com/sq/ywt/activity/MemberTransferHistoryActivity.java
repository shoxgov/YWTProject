package com.sq.ywt.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import com.sq.ywt.R;
import com.sq.ywt.adapter.MemberTransferHistorydapter;
import com.sq.ywt.adapter.bonusdetaildapter;
import com.sq.ywt.bean.NoticItemInfo;
import com.sq.ywt.view.TitleBarLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created by wsy on 2017/1/18.
 */
public class MemberTransferHistoryActivity extends Activity implements View.OnClickListener{
    private TextView startdate;
    private TextView enddate;
    private MemberTransferHistorydapter adapter;
    private ListView membertransferList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_member__transfer_history);
        initView();
        init();
    }

    private void init() {
        adapter = new MemberTransferHistorydapter(this);
        membertransferList.setAdapter(adapter);
        List<NoticItemInfo> data = new ArrayList<NoticItemInfo>();
        data.add(new NoticItemInfo());
        data.add(new NoticItemInfo());
        data.add(new NoticItemInfo());
        adapter.setData(data);
    }

    private void initView() {
        membertransferList = (ListView) findViewById(R.id.membertransferList);
        startdate = (TextView) findViewById(R.id.startdate);
        startdate.setOnClickListener(this);
        enddate = (TextView) findViewById(R.id.enddate);
        enddate.setOnClickListener(this);
        TitleBarLayout titleLayout = (TitleBarLayout) findViewById(R.id.titlelayout);
        titleLayout.setTitle("转账记录");
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
            case R.id.startdate:
                Calendar startCalendar = Calendar.getInstance();
                // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
                new DatePickerDialog(MemberTransferHistoryActivity.this,
                        // 绑定监听器
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                startdate.setText(year + "年" + monthOfYear
                                        + "月" + dayOfMonth + "日");
                            }
                        }
                        // 设置初始日期
                        , startCalendar.get(Calendar.YEAR), startCalendar.get(Calendar.MONTH), startCalendar
                        .get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.enddate:
                Calendar endCalendar = Calendar.getInstance();
                // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
                new DatePickerDialog(MemberTransferHistoryActivity.this,
                        // 绑定监听器
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                enddate.setText(year + "年" + monthOfYear
                                        + "月" + dayOfMonth + "日");
                            }
                        }
                        // 设置初始日期
                        , endCalendar.get(Calendar.YEAR), endCalendar.get(Calendar.MONTH), endCalendar
                        .get(Calendar.DAY_OF_MONTH)).show();
                break;
        }
    }
}
