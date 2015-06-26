package com.bupt.telis.weixininterface;

import android.support.v4.app.Fragment;

/**
 * Created by Telis on 2015/5/30.
 */
public class FragmentFactory {
    public static final int MESSAGE = 1;
    public static final int CONTACT = 2;
    public static final int FIND = 3;
    public static final int ABOUT_ME = 4;


    public static Fragment getFragment(int TYPE) {
        switch (TYPE) {
            case MESSAGE:
                return new MessageFragment();
            case CONTACT:
                return new ContactFragment();
            case FIND:
                return new FindFragment();
            case ABOUT_ME:
                return new AboutMeFragment();
            default:
                return new MessageFragment();
        }


    }

}
