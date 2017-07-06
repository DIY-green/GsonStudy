package com.diycheng.gsonstudy.streamapi;

/**
 * Created by liwangcheng on 2017/7/5 19:46.
 */

public class User {

    String name;
    int age;
    String profession;

    public User() {
    }

    public User(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                '}';
    }
}
