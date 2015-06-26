package com.bupt.telis.weixininterface;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Telis on 2015/5/30.
 */
public class ContactFragment extends Fragment {
    private List<String> chooseList;

    public ContactFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_fragment, null);
        final ListView listView = (ListView) view.findViewById(R.id.list_view);
        final List<ContactBean> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 4; j++) {
                String s = String.valueOf((char) ('A' + i));
                list.add(new ContactBean(R.drawable.ic_menu_emoticons, s + s + s));
            }
        }
        Collections.sort(list, new Comparator<ContactBean>() {
            @Override
            public int compare(ContactBean lhs, ContactBean rhs) {
                char lc = lhs.getName().charAt(0);
                char rc = rhs.getName().charAt(0);
                if (lc < rc) {
                    return -1;
                } else if (lc > rc) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        final int listSize = list.size();
        final List<Integer> toastList = getToastList(list);
        listView.setAdapter(new ContactAdapter(getActivity(), list));

        final TextView toastTextView = (TextView) view.findViewById(R.id.toast_view);
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels - (int) (60 * dm.density) - (int) (40 * dm.density);
        TypedArray actionbarSizeTypedArray = getActivity().obtainStyledAttributes(new
                int[]{
                android.R.attr.actionBarSize
        });
        int actionBarHeight = (int) actionbarSizeTypedArray.getDimension(0, 0);
        final ListView chooseItemListView = (ListView) view.findViewById(R.id
                .list_view_choose_item);
        chooseList = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            chooseList.add(String.valueOf((char) ('A' + i)));
        }
        chooseItemListView.setAdapter(new ContactToastAdapter(getActivity(),
                chooseList, height -
                actionBarHeight * 2));
        chooseItemListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float height = chooseItemListView.getHeight();
                float y = event.getY();
                int selectPosition = (int) ((y / height) * 26);
                if (selectPosition < 0) {
                    selectPosition = 0;
                } else if (selectPosition > 25) {
                    selectPosition = 25;
                }
                //                Log.i("Position", String.valueOf(selectPosition));
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        toastTextView.setVisibility(View.VISIBLE);
                        toastTextView.setText(chooseList.get(selectPosition));
                        if (selectPosition < toastList.size())
                            listView.setSelection(toastList.get(selectPosition));
                        break;
                    case MotionEvent.ACTION_UP:
                        toastTextView.setVisibility(View.GONE);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (selectPosition < toastList.size()) {
                            toastTextView.setText(chooseList.get(selectPosition));
                            listView.setSelection(toastList.get(selectPosition));
                        } else {
                            listView.setSelection(listSize);
                        }
                        break;
                }
                return false;
            }
        });
        return view;
    }

    private List<Integer> getToastList(List<ContactBean> contactList) {
        List<Integer> list = new ArrayList<>();
        int size = contactList.size();
        list.add(0);
        for (int i = 0; i < size - 1; i++) {
            if (contactList.get(i).getName().charAt(0) != contactList.get(i + 1).getName().charAt
                    (0)) {
                list.add(i + 1);
            }
        }
        return list;
    }

}
