package com.diycheng.gsonstudy.exclusionstrategy;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Created by liwangcheng on 2017/6/20 09:18.
 */

public class User {
    String name;
    String phone_num;
    String _qq;
    float weight;
    char _badge; // 徽章
    boolean isNew;
    int age;
    @Expose
    Date birthday;

    @Override
    public String toString() {
        return "User{" +
                "publicName='" + name + '\'' +
                ", phone_num='" + phone_num + '\'' +
                ", _qq='" + _qq + '\'' +
                ", weight='" + weight + '\'' +
                ", _badge=" + _badge +
                ", isNew=" + isNew +
                ", finalAge=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
