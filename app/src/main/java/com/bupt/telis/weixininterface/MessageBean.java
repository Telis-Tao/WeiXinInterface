package com.bupt.telis.weixininterface;

import android.graphics.Bitmap;

/**
 * Created by Telis on 2015/5/30.
 */
public class MessageBean {
    private Bitmap icon;
    private String title;

    private String content;
    private String date;

    public MessageBean(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
