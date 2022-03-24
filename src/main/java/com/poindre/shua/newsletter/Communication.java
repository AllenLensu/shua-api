package com.poindre.shua.newsletter;

import com.alibaba.fastjson.JSON;

public class Communication {
    public static final String ENTER = "ENTER";
    public static final String SPEAK = "SPEAK";
    public static final String QUIT = "QUIT";

    private String type;

    private String addresser;

    private String addressee;

    private String content;

    private int online;

    public static String jsonStr(String type, String addresser, String addressee, String msg, int onlineTotal) {
        return JSON.toJSONString(new Communication(type, addresser, addressee, msg, onlineTotal));
    }

    public Communication(String type, String addresser, String addressee, String content, int online) {
        this.type = type;
        this.addresser = addresser;
        this.addressee = addressee;
        this.content = content;
        this.online = online;
    }

    public static String getENTER() {
        return ENTER;
    }

    public static String getSPEAK() {
        return SPEAK;
    }

    public static String getQUIT() {
        return QUIT;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddresser() {
        return addresser;
    }

    public void setAddresser(String addresser) {
        this.addresser = addresser;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }
}
