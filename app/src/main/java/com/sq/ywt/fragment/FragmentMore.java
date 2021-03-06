package com.sq.ywt.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.sq.ywt.R;
import com.sq.ywt.activity.BussinessManagerActivity;
import com.sq.ywt.activity.FinanceManagerActivity;
import com.sq.ywt.activity.MailCenterActivity;
import com.sq.ywt.activity.PersonCenterActivity;
import com.sq.ywt.activity.TradeCenterActivity;
import com.sq.ywt.adapter.CustomGridViewAdapter;
import com.sq.ywt.bean.SettingItemInfo;
import com.sq.ywt.view.MyGridView;

import java.util.ArrayList;
import java.util.List;

import static android.widget.AdapterView.OnItemClickListener;


public class FragmentMore extends Fragment {

    private List<SettingItemInfo> data;
    private MyGridView gridview;
    private CustomGridViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        init();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initView() {
        gridview = (MyGridView) getView().findViewById(R.id.more_gridview);
        adapter = new CustomGridViewAdapter(getActivity());
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(listener);
    }

    private void init() {
        initInfos();
        adapter.setData(data);
    }

    private void initInfos() {
        data = new ArrayList<SettingItemInfo>();
        SettingItemInfo bussiness = new SettingItemInfo();
        bussiness.setImgId(R.mipmap.ic_launcher);
        bussiness.setName("业务管理");
        data.add(bussiness);
        SettingItemInfo finance = new SettingItemInfo();
        finance.setImgId(R.mipmap.ic_launcher);
        finance.setName("财务管理");
        data.add(finance);
        SettingItemInfo trade = new SettingItemInfo();
        trade.setImgId(R.mipmap.ic_launcher);
        trade.setName("交易中心");
        data.add(trade);
        SettingItemInfo personal = new SettingItemInfo();
        personal.setImgId(R.mipmap.ic_launcher);
        personal.setName("个人中心");
        data.add(personal);
        SettingItemInfo charge = new SettingItemInfo();
        charge.setImgId(R.mipmap.ic_launcher);
        charge.setName("分管中心");
        data.add(charge);
        SettingItemInfo email = new SettingItemInfo();
        email.setImgId(R.mipmap.ic_launcher);
        email.setName("邮件中心");
        data.add(email);
    }

    OnItemClickListener listener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            switch (position) {
                case 0:
                    Intent bussiness = new Intent();
                    bussiness.setClass(getActivity(), BussinessManagerActivity.class);
                    getActivity().startActivity(bussiness);
                    break;
                case 1:
                    Intent finance = new Intent();
                    finance.setClass(getActivity(), FinanceManagerActivity.class);
                    getActivity().startActivity(finance);
                    break;
                case 2:
                    Intent trade = new Intent();
                    trade.setClass(getActivity(), TradeCenterActivity.class);
                    getActivity().startActivity(trade);
                    break;
                case 3:
                    Intent person = new Intent();
                    person.setClass(getActivity(), PersonCenterActivity.class);
                    getActivity().startActivity(person);
                    break;
                case 4:
                    Toast.makeText(getActivity(), "暂未定义", Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    Intent mail = new Intent();
                    mail.setClass(getActivity(), MailCenterActivity.class);
                    getActivity().startActivity(mail);
                    break;
            }
        }
    };

}
