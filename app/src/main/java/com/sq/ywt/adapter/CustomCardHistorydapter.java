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

import com.sq.ywt.R;
import com.sq.ywt.bean.NoticItemInfo;

import java.util.List;

/**
 * @Class: GridViewAdapter
 * @version: V1.0
 */
public class CustomCardHistorydapter extends BaseAdapter {
    private Context mContext;
    private List<NoticItemInfo> mList;

    public CustomCardHistorydapter(Context mContext) {
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
                    R.layout.customcardhistory_item, null);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    private class ViewHolder {
    }
}