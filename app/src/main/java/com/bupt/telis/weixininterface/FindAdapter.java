package com.bupt.telis.weixininterface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Telis on 2015/5/30.
 */
public class FindAdapter extends BaseAdapter {
    private Context mContext;
    private List<List<InfoBean>> mList;

    public FindAdapter(Context context, List<List<InfoBean>> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.info_outer_list_view, null);
        } else {
            view = convertView;
        }
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(new subAdapter(mContext, mList.get(position)));
        return view;
    }

    private class subAdapter extends BaseAdapter {
        private Context mContext;
        private List<InfoBean> list;

        public subAdapter(Context mContext, List<InfoBean> list) {
            this.mContext = mContext;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final View view;
            if (convertView == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.info_listview, null);
            } else {
                view = convertView;
            }
            ImageView icon = (ImageView) view.findViewById(R.id.icon);
            TextView name = (TextView) view.findViewById(R.id.name);
            icon.setImageResource(list.get(position).getResId());
            name.setText(list.get(position).getName());
            return view;
        }
    }
}
