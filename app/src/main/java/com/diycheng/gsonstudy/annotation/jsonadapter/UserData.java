package com.diycheng.gsonstudy.annotation.jsonadapter;

import com.google.gson.annotations.JsonAdapter;

import java.util.Date;

/**
 * Created by liwangcheng on 2017/7/3 09:57.
 * 演示 @JsonAdapter 反序列化使用
 */
@JsonAdapter(UserDataDeserializer.class)
public class UserData {

    String name;
    String email;
    boolean isDeveloper;
    int age;
    Date registerDate;

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isDeveloper=" + isDeveloper +
                ", age=" + age +
                ", registerDate=" + registerDate +
                '}';
    }
}