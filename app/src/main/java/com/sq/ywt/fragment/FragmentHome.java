package com.sq.ywt.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sq.ywt.R;
import com.sq.ywt.activity.BonusDetailActivity;
import com.sq.ywt.activity.BonusWithdrawActivity;
import com.sq.ywt.activity.MailCenterActivity;
import com.sq.ywt.activity.MemberTransferActivity;
import com.sq.ywt.activity.NoticeInfoActivity;
import com.sq.ywt.activity.RegisterActivity;
import com.sq.ywt.view.BannerView;

import java.util.ArrayList;
import java.util.List;


public class FragmentHome extends Fragment implements View.OnClickListener {


    private BannerView bannerView;
    private LinearLayout bannerlayout;
    private TextView recharge, withdraw, rewarddetail, transfer, email, notic_info, notic_more;
    private Button register;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        init();
    }

    private void initView() {
        // 初始化
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        notic_info = (TextView) getView().findViewById(R.id.notic_info);
        notic_more = (TextView) getView().findViewById(R.id.notic_more);
        bannerlayout = (LinearLayout) getView().findViewById(R.id.bannerlayout);
        bannerView = new BannerView(getActivity());
        bannerlayout.addView(bannerView);
        recharge = (TextView) getView().findViewById(R.id.home_function_recharge);
        withdraw = (TextView) getView().findViewById(R.id.home_function_withdraw);
        rewarddetail = (TextView) getView().findViewById(R.id.home_function_rewarddetail);
        transfer = (TextView) getView().findViewById(R.id.home_function_transfer);
        email = (TextView) getView().findViewById(R.id.home_function_email);
        register = (Button) getView().findViewById(R.id.home_function_register);
    }

    private void init() {
        List<String> imgurl = new ArrayList<>();
        imgurl.add("http://image.codes51.com/Article/image/20151118/20151118232155_0937.jpg");
        imgurl.add("http://t12.baidu.com/it/u=3816865172,3823366830&fm=76");
        imgurl.add("http://t10.baidu.com/it/u=3376351686,4044625692&fm=76");
        bannerView.setList(imgurl);

        notic_info.setOnClickListener(this);
        notic_more.setOnClickListener(this);
        recharge.setOnClickListener(this);
        withdraw.setOnClickListener(this);
        rewarddetail.setOnClickListener(this);
        transfer.setOnClickListener(this);
        email.setOnClickListener(this);
        register.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.notic_info:
            case R.id.notic_more:
                Intent notic_more = new Intent();
                notic_more.setClass(getActivity(), NoticeInfoActivity.class);
                getActivity().startActivity(notic_more);
                break;
            case R.id.home_function_recharge:

                break;
            case R.id.home_function_withdraw:
                Intent bonus = new Intent();
                bonus.setClass(getActivity(), BonusWithdrawActivity.class);
                getActivity().startActivity(bonus);
                break;
            case R.id.home_function_rewarddetail:
                Intent bonusDetail = new Intent();
                bonusDetail.setClass(getActivity(), BonusDetailActivity.class);
                getActivity().startActivity(bonusDetail);
                break;
            case R.id.home_function_transfer:
                Intent transfer = new Intent();
                transfer.setClass(getActivity(), MemberTransferActivity.class);
                getActivity().startActivity(transfer);
                break;
            case R.id.home_function_email:
                Intent mailCenter = new Intent();
                mailCenter.setClass(getActivity(), MailCenterActivity.class);
                getActivity().startActivity(mailCenter);
                break;
            case R.id.home_function_register:
                Intent registory_more = new Intent();
                registory_more.setClass(getActivity(), RegisterActivity.class);
                getActivity().startActivity(registory_more);
                break;
        }
    }
}
