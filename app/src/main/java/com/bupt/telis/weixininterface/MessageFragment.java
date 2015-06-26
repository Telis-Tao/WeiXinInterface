package com.bupt.telis.weixininterface;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MessageFragment extends Fragment {

    private String mTitle = "Default";
    public static final String TITLE = "title";

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (getArguments() != null) {
            mTitle = getArguments().getString(TITLE);
        }
        View view = inflater.inflate(R.layout.listview_fragment, null);
        view.setBackgroundColor(Color.parseColor("#FFFFFF"));
        List<MessageBean> list = new ArrayList<>();
        list.add(new MessageBean("腾讯新闻", "25岁女毒枭家藏百公斤毒品", "早上09:17"));
        list.add(new MessageBean("社会万象", "江苏一面馆遭遇奇葩小偷 对着监控炫起舞姿", "早上09:17"));
        list.add(new MessageBean("时政新闻", "解读：李克强首提中拉“四大支柱”蕴含何深意", "早上09:17"));
        list.add(new MessageBean("国际新闻", "印度高温持续 民众烈日下煎蛋", "早上09:17"));
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        listView.setAdapter(new MessageAdapter(getActivity(), list));
        //        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //            @Override
        //            public void onItemClick(AdapterView<?> parent, View view, int position,
        // long id) {
        //                Toast.makeText(getActivity(), String.valueOf(position), Toast
        // .LENGTH_SHORT).show();
        ////                Log.i("test","test");
        //            }
        //        });
        return view;
    }


}
