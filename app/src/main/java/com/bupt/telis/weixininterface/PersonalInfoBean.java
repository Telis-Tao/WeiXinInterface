package com.bupt.telis.weixininterface;

/**
 * Created by Telis on 2015/5/30.
 */
public class PersonalInfoBean {
    private int icon;
    private String nickname;
    private String id;
    private int code;

    public PersonalInfoBean(int icon, String nickname, String id, int code) {
        this.icon = icon;
        this.nickname = nickname;
        this.id = id;
        this.code = code;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
