package com.diycheng.gsonstudy.typeadapter;

/**
 * Created by liwangcheng on 2017/7/6 15:31.
 */

public class User {

    String name;
    int age;
    String email;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
