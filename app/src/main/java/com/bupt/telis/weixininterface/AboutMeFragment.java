package com.bupt.telis.weixininterface;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Telis on 2015/5/30.
 */
public class AboutMeFragment extends Fragment {


    List<List<InfoBean>> mLists;

    public AboutMeFragment() {
        mLists = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.about_me_fragment, null);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        TextView nickname = (TextView) view.findViewById(R.id.nickname);
        TextView id = (TextView) view.findViewById(R.id.id);
        ImageView code = (ImageView) view.findViewById(R.id.code);
        PersonalInfoBean info = new PersonalInfoBean(R.drawable.ic_menu_invite, "灰灰狼",
                "huihuilang2014", R.drawable.ic_menu_camera);
        icon.setImageResource(info.getIcon());
        nickname.setText(info.getNickname());
        id.setText("微信号:" + info.getId());
        code.setImageResource(info.getCode());
        List<List<InfoBean>> list = new ArrayList<>();
        List<InfoBean> tmp = new ArrayList<>();
        tmp.add(new InfoBean(R.drawable.ic_menu_allfriends, "相册"));
        tmp.add(new InfoBean(R.drawable.ic_menu_allfriends, "收藏"));
        list.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(new InfoBean(R.drawable.ic_menu_allfriends, "钱包"));
        list.add(tmp);
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(new FindAdapter(getActivity(), list));
        return view ;
    }
}
