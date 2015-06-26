package com.bupt.telis.weixininterface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Telis on 2015/6/2.
 */
public class ContactToastAdapter extends BaseAdapter {
    private List<String> list;
    private Context context;
    private int screenHeight;

    public ContactToastAdapter(Context context, List<String> list, int height) {
        super();
        this.context = context;
        this.list = list;
        screenHeight = height;
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
        View view = LayoutInflater.from(context).inflate(R.layout.contact_choose_item, null);
        TextView textview = (TextView) view.findViewById(R.id.text_view);
        textview.setText(list.get(position));
        textview.setHeight(screenHeight / 26);
        return view;
    }
}
