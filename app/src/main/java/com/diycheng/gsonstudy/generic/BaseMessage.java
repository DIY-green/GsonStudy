package com.diycheng.gsonstudy.generic;

/**
 * Created by liwangcheng on 2017/6/2 09:49.
 */

public class BaseMessage {
    public int code;
    public String msg;
    public String data;

    @Override
    public String toString() {
        return "BaseMessage{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
