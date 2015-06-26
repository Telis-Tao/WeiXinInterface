package com.bupt.telis.weixininterface;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Telis on 2015/5/30.
 */
public class FindFragment extends Fragment {
    List<List<InfoBean>> mLists;

    public FindFragment() {
        mLists = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.listview_fragment, null);
        List<List<InfoBean>> list = new ArrayList<>();
        List<InfoBean> tmp = new ArrayList<>();
        tmp.add(new InfoBean(R.drawable.ic_menu_allfriends, "朋友圈"));
        //        tmp.add(new InfoBean(R.drawable.ic_menu_allfriends, "画一画"));
        list.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(new InfoBean(R.drawable.ic_menu_allfriends, "扫一扫"));
        tmp.add(new InfoBean(R.drawable.ic_menu_allfriends, "摇一摇"));
        list.add(tmp);
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(new FindAdapter(getActivity(), list));
        return view;
    }
}
