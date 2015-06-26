package com.bupt.telis.weixininterface;

/**
 * Created by Telis on 2015/5/30.
 */
public class ContactBean {
    private int resId;
    private String name;
    private String id;

    public ContactBean(int resId, String name) {
        this.resId = resId;
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
