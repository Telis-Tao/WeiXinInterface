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
public class MessageAdapter extends BaseAdapter {
    private Context mContext;
    private List<MessageBean> mList;

    public MessageAdapter(Context context, List<MessageBean> list) {
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
        View mView;
        if (convertView == null) {
            mView = LayoutInflater.from(mContext).inflate(R.layout.message_listview, null);
        } else {
            mView = convertView;
        }
        ImageView mIcon = (ImageView) mView.findViewById(R.id.icon);
        TextView mTitle = (TextView) mView.findViewById(R.id.title);
        TextView mContent = (TextView) mView.findViewById(R.id.content);
        TextView mDate = (TextView) mView.findViewById(R.id.date);
        mIcon.setImageResource(R.drawable.ic_menu_search);
        mTitle.setText(mList.get(position).getTitle());
        mContent.setText(mList.get(position).getContent());
        mDate.setText(mList.get(position).getDate());
        return mView;
    }
}
