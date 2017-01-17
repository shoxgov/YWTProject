package com.sq.ywt.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

import com.sq.ywt.R;
import com.sq.ywt.adapter.NoticeAdapter;
import com.sq.ywt.view.MyViewPager;

import java.util.ArrayList;


/**
 * Created by wsy on 2017/1/12.
 */

public class RegisterActivity extends Activity implements View.OnClickListener {
    private ListView commList;
    private NoticeAdapter adapter;
    private MyViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        initViewPager();
    }


    private void initViewPager() {
        viewPager = (MyViewPager) findViewById(R.id.viewPager);
        viewPager.setScrollble(false);
        View view1 = LayoutInflater.from(this).inflate(R.layout.layout_register_1, null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.layout_register_2, null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.layout_register_3, null);
        View view4 = LayoutInflater.from(this).inflate(R.layout.layout_register_4, null);

        view1.findViewById(R.id.register1_btn_cancel).setOnClickListener(this);
        view1.findViewById(R.id.register1_btn_next).setOnClickListener(this);
        view2.findViewById(R.id.register2_btn_prev).setOnClickListener(this);
        view2.findViewById(R.id.register2_btn_next).setOnClickListener(this);
        view3.findViewById(R.id.register3_btn_prev).setOnClickListener(this);
        view3.findViewById(R.id.register3_btn_next).setOnClickListener(this);
        view4.findViewById(R.id.register4_btn_submit).setOnClickListener(this);

        ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);

        MYViewPagerAdapter adapter = new MYViewPagerAdapter();
        adapter.setViews(views);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register1_btn_cancel:
                finish();
                break;
            case R.id.register1_btn_next:
                viewPager.setCurrentItem(1);
                break;
            case R.id.register2_btn_prev:
                viewPager.setCurrentItem(0);
                break;
            case R.id.register2_btn_next:
                viewPager.setCurrentItem(2);
                break;
            case R.id.register3_btn_prev:
                viewPager.setCurrentItem(1);
                break;
            case R.id.register3_btn_next:
                viewPager.setCurrentItem(3);
                break;
            case R.id.register4_btn_submit:
                finish();
                break;
        }
    }

    public class MYViewPagerAdapter extends PagerAdapter {

        private ArrayList<View> views;

        public void setViews(ArrayList<View> views) {
            this.views = views;
        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {

            ((ViewPager) container).removeView(views.get(position));
        }

        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager) container).addView(views.get(position));
            return views.get(position);
        }
    }
}
