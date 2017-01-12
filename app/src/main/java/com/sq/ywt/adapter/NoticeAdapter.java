/**
 * @Title: GridViewAdapter.java
 * @date: 2015-11-23 下午4:01:40
 * @Copyright: (c) 2015, unibroad.com Inc. All rights reserved.
 */
package com.sq.ywt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sq.ywt.R;
import com.sq.ywt.bean.NoticItemInfo;
import com.sq.ywt.bean.SettingItemInfo;

import java.util.List;

/**
 * @Class: GridViewAdapter
 * @Description: TODO(描述类作用)
 * @author: wsy@unibroad.com
 * @version: V1.0
 */
public class NoticeAdapter extends BaseAdapter {
    private Context mContext;
    private List<NoticItemInfo> mList;

    public NoticeAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    public void setData(List<NoticItemInfo> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mList == null) {
            return 0;
        } else {
            return this.mList.size();
        }
    }

    @Override
    public Object getItem(int position) {
        if (mList == null) {
            return null;
        } else {
            return this.mList.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(this.mContext).inflate(
                    R.layout.notic_item, null);
            holder.title = (TextView) convertView.findViewById(R.id.notic_title);
            holder.time = (TextView) convertView.findViewById(R.id.notic_time);
            holder.detail = (TextView) convertView.findViewById(R.id.notic_detail);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    private class ViewHolder {
        public TextView title;
        public TextView time;
        public TextView detail;
    }
}