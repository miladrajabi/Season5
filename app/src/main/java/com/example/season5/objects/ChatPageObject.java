package com.example.season5.objects;

public class ChatPageObject {

    String msg;
    Boolean me;
    String date;
    Boolean seen;
    int type;

    public static final int TYPE_MESSAGE = 0;
    public static final int TYPE_DATE = 1;

    public ChatPageObject() {
    }

    public ChatPageObject(String msg) {
        this.msg = msg;
    }

    public ChatPageObject(String msg, Boolean me, String date, Boolean seen, int type) {
        this.msg = msg;
        this.me = me;
        this.date = date;
        this.seen = seen;
        this.type = type;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Boolean getMe() {
        return me;
    }

    public void setMe(Boolean me) {
        this.me = me;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
