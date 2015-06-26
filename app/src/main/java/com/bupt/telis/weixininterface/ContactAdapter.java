package com.bupt.telis.weixininterface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Telis on 2015/5/30.
 */
public class ContactAdapter extends BaseAdapter {
    private Context mContext;
    private List<ContactBean> mList;

    public ContactAdapter(Context context, List<ContactBean> mList) {
        this.mContext = context;
        this.mList = mList;
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
        View mView;
        if (convertView == null) {
            mView = LayoutInflater.from(mContext).inflate(R.layout.contact_list_view, null);
        } else {
            mView = convertView;
        }
        ImageView icon = (ImageView) mView.findViewById(R.id.icon);
        TextView name = (TextView) mView.findViewById(R.id.name);
        icon.setImageResource(mList.get(position).getResId());
        name.setText(mList.get(position).getName());
        return mView;
    }
}
