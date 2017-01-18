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
import com.sq.ywt.bean.SettingItemInfo;

import java.util.List;

/**
 * @Class: GridViewAdapter
 * @version: V1.0
 */
public class CustomGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<SettingItemInfo> mList;

    public CustomGridViewAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    public void setData(List<SettingItemInfo> mList) {
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
                    R.layout.customgridview_item, null);
            holder.img = (ImageView) convertView.findViewById(R.id.item_img);
            holder.name = (TextView) convertView.findViewById(R.id.item_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final SettingItemInfo sii = mList.get(position);
        holder.img.setBackgroundResource(sii.getImgId());
        holder.name.setText(sii.getName());
        return convertView;
    }

    private class ViewHolder {
        public TextView name;
        ImageView img;
    }
}