package com.bupt.telis.weixininterface;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements View.OnClickListener, ViewPager
        .OnPageChangeListener {
    private ViewPager mViewPager;
    private List<Fragment> mTabls = new ArrayList<>();
    private int[] mFrags = {FragmentFactory.MESSAGE, FragmentFactory.CONTACT, FragmentFactory
            .FIND, FragmentFactory.ABOUT_ME};
    private FragmentPagerAdapter mAdapter;
    private List<ChangeColorIconWithText> mTabIndicators = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

        initEvent();
    }

    private void initEvent() {
        for (ChangeColorIconWithText mTabIndicator : mTabIndicators) {
            mTabIndicator.setOnClickListener(this);
        }
        mViewPager.setOnPageChangeListener(this);
    }

    private void initData() {
        for (int type : mFrags) {
            Fragment fragment = FragmentFactory.getFragment(type);
            mTabls.add(fragment);
        }

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mTabls.get(position);
            }

            @Override
            public int getCount() {
                return mTabls.size();
            }
        };
        mViewPager.setAdapter(mAdapter);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTabIndicators.add((ChangeColorIconWithText) findViewById(R.id.id_indicator_one));
        mTabIndicators.add((ChangeColorIconWithText) findViewById(R.id.id_indicator_two));
        mTabIndicators.add((ChangeColorIconWithText) findViewById(R.id.id_indicator_three));
        mTabIndicators.add((ChangeColorIconWithText) findViewById(R.id.id_indicator_four));

        mTabIndicators.get(0).setIconAlpha(1.0f);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //        alwaysShowIcon();
        getActionBar().setDisplayShowHomeEnabled(false);
        return true;
    }

    private void alwaysShowIcon() {
        ViewConfiguration config = ViewConfiguration.get(this);
        try {
            Field menuKey = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            menuKey.setAccessible(true);
            menuKey.setBoolean(config, false);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        resetOtherTabs();
        switch (v.getId()) {
            case R.id.id_indicator_one:
                mTabIndicators.get(0).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(0, false);
                break;
            case R.id.id_indicator_two:
                mTabIndicators.get(1).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(1, false);
                break;
            case R.id.id_indicator_three:
                mTabIndicators.get(2).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(2, false);
                break;
            case R.id.id_indicator_four:
                mTabIndicators.get(3).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(3, false);
                break;
        }
    }

    /**
     * 重置其他的tabs颜色
     */
    private void resetOtherTabs() {
        for (ChangeColorIconWithText indicator : mTabIndicators) {
            indicator.setIconAlpha(0.0f);
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset > 0) {
            ChangeColorIconWithText left = mTabIndicators.get(position);
            ChangeColorIconWithText right = mTabIndicators.get(position + 1);
            left.setIconAlpha(1 - positionOffset);
            right.setIconAlpha(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
