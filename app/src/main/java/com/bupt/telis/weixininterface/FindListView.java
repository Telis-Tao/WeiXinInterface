package com.bupt.telis.weixininterface;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Telis on 2015/5/30.
 */
public class FindListView extends ListView {
    public FindListView(Context context) {
        super(context);
    }

    public FindListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FindListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
//        int getHeight = MeasureSpec.getSize(height);
        super.onMeasure(widthMeasureSpec, height);
    }
}
